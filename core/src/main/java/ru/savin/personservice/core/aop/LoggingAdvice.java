package ru.savin.personservice.core.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LoggingAdvice {
    @Pointcut(value = "execution(* ru.savin.personservice.core.controller.*.*(..))")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object appLogger(ProceedingJoinPoint pjp) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        String methodName = pjp.getSignature().getName();
        String className = pjp.getClass().toString();

        Object[] array = pjp.getArgs();

        log.info("Вызван метод: " + className + ": "
                + methodName + "()"
                + "с аргументами: "
                + objectMapper.writeValueAsString(array));

        Object o = null;

        try {
            o = pjp.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        log.info(className + ": "
                + methodName + "()"
                + " Response: "
                + objectMapper.writeValueAsString(array));
        return o;
    }
}
