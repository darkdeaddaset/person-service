package ru.savin.personservice.core.mapper;

import org.apache.ibatis.annotations.*;
import ru.savin.personservice.core.model.MedicalCard;

import java.util.List;

@Mapper
public interface MedicalCardMapper {
    @Results(id = "medical_card", value = {
            @Result(property = "clientStatus", column = "client_status"),
            @Result(property = "medStatus", column = "med_status"),
            @Result(property = "registryDt", column = "registry_dt"),
            @Result(property = "comment", column = "comment")
    })

    @Select("select id, client_status as clientStatus, med_status as medStatus, registry_dt as registryDt, comment " +
            "from medical_card;")
    List<MedicalCard> getAllMedicalCard();
}
