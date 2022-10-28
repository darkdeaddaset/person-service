package ru.savin.personservice.core.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.savin.personservice.core.model.Person;

import java.util.List;

@Mapper
public interface PersonMapper {
    @Select("select id, first_name as firstName, last_name as lastName from person_data;")
    List<Person> getAllPersons();

    @Insert("insert into person_data (id, last_name, first_name, age, sex)"
    + "values (#{id}, #{last_name}, #{first_name}, #{age}, #{sex})")
    Person addPerson(Person person);
}
