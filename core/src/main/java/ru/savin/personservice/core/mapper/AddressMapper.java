package ru.savin.personservice.core.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.savin.personservice.core.model.Address;

import java.util.List;

@Mapper
public interface AddressMapper {


    @Select ("select id, contact_id as contactId, country_id as countryId, city, index, street, building, flat " +
            "from address;")
    List<Address> getAllAddress();
}
