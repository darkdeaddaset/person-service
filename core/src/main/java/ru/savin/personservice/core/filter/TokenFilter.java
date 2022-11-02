package ru.savin.personservice.core.filter;

import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.savin.personservice.core.model.jwt.JwtAuthentication;
import ru.savin.personservice.core.utils.JwtProvider;
import ru.savin.personservice.core.utils.JwtUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
public class TokenFilter extends OncePerRequestFilter {
    private final String AUTHORIZATION = "Authorization";
    private final String BEARER = "Bearer ";
    private JwtProvider jwtProvider;

    private String getTokenFromRequest(HttpServletRequest httpServletRequest) {
        String bearer = httpServletRequest.getHeader(AUTHORIZATION);

        if (StringUtils.hasText(bearer) && bearer.startsWith(BEARER)) {
            return bearer.substring(BEARER.length());
        }
        return null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = getTokenFromRequest(httpServletRequest);

        if (token != null && jwtProvider.validateAccess(token)){
            Claims claims = jwtProvider.getAccessToken(token);
            JwtAuthentication jwtAuthentication = JwtUtil.generate(claims);
            jwtAuthentication.setAuthenticated(true);
            SecurityContextHolder.getContext().setAuthentication(jwtAuthentication);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
