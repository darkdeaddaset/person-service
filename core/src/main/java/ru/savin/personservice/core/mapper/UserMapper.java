package ru.savin.personservice.core.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import ru.savin.personservice.core.model.User;

import java.util.Optional;

@Mapper
public interface UserMapper {
    @Select("user_test.id, user_test.login, user_test.password, user_test.authorities where user_test.login = #{login}")
    Optional<User> getUser(String login);

    @Select("select login, password from user_test where user_test.login = #{login} and user_test.password = #{password};")
    Optional<User> getUserByLoginAndPassword(@Param("login") String login, @Param("password") String password);

    @Select("select user_test.id from user_test where user_test.login = #{login};")
    long getIdOfUser(String login);
    @Insert("insert into user_test(login,password) values (#{login}, #{password})")
    void save(User user);
}
