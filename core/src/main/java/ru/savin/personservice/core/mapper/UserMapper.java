package ru.savin.personservice.core.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.savin.personservice.core.model.User;

import java.util.Optional;

@Mapper
public interface UserMapper {
    @Select("select * from users where login = #{login}")
    Optional<User> getUser(@Param("login") String login);

    @Select("select login, password from users where user_test.login = #{login} and user_test.password = #{password};")
    Optional<User> getUserByLoginAndPassword(@Param("login") String login, @Param("password") String password);

    @Select("select id from users where login = #{login};")
    Long getIdOfUser(@Param("login") String login);
    @Insert("insert into users(login,password) values (#{login}, #{password})")
    void save(User user);
}
