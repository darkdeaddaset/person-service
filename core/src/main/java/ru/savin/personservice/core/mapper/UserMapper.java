package ru.savin.personservice.core.mapper;

import org.apache.ibatis.annotations.*;
import ru.savin.personservice.core.model.User;

import java.util.Optional;
import java.util.Set;

@Mapper
public interface UserMapper {
    @Select("select * from users where login = #{login}")
    Optional<User> getUser(@Param("login") String login);

    @Select("select id, login, password from users where users.login = #{login} and users.password = #{password};")
    Optional<User> getUserByLoginAndPassword(@Param("login") String login, @Param("password") String password);

    @Select("select id from users where users.login = #{login};")
    Long getIdOfUser(@Param("login") String login);
    @Insert("insert into users(login,password) values (#{login}, #{password})")
    void save(User user);
}
