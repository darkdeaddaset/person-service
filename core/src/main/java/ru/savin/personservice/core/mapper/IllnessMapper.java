package ru.savin.personservice.core.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.savin.personservice.core.model.Illness;

import java.util.List;

@Mapper
public interface IllnessMapper {
    @Results(id = "illness", value = {
            @Result(property = "typeId", column = "type_id"),
            @Result(property = "medicalCardId", column = "medical_card_id"),
            @Result(property = "appearanceDttm", column = "apprearance_dttm"),
            @Result(property = "recoveryDt", column = "recovery_dy")
    })

    @Select("select id, medical_card_id as medicalCardId, type_id as typeId, heaviness, appearance_dttm as appearanceDttm, recovery_dt as recoveryDt " +
            "from illness;")
    List<Illness> getAll();
}
