package ru.savin.personservice.core.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.savin.personservice.core.model.Contact;

import java.util.List;

@Mapper
public interface ContactMapper {
    @Results(id = "contact", value = {
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "profileLink", column = "profile_link")
    })

    @Select("select id, phone_number as phoneNumber, profile_link as profileLink from contact;")
    List<Contact> getAll();
}
