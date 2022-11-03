package ru.savin.personservice.core.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RolesMapper {
    @Select("select id from role_test where name_role = #{name_role};")
    Long getRole(@Param("name_role") String name_role);

    @Insert("insert into user_role(user_id, roles) values (#{user_id}, #{roles});")
    void save(@Param("user_id") long user_id, @Param("roles") int roles);

    @Select("select roles from user_role where user_id = #{user_id}")
    Long getByRoleId(@Param("user_id") long user_id);

    @Select("select roles from user_role where user_id = #{user_id}")
    String getNameRole(@Param("user_id") long user_id);
}
