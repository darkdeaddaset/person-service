package ru.savin.personservice.core.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RolesMapper {
    @Select("select role_test.id from role_test where name_role = #{name_role};")
    long getRole(String name_role);

    @Insert("insert into role_user(role_id, user_id) values (#{role_id}, #{user_id});")
    void save(@Param("role_id") long role_id, @Param("user_id") long user_id);

    @Select("select role_id from role_user where user_id = #{user_id}")
    long getByRoleId(@Param("user_id") long user_id);

    @Select("select name_role from role_test where id = #{id}")
    String getNameRole(@Param("id") long id);
}
