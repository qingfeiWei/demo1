package com.example.demo.mapper;

import com.example.demo.entity.UnitEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Component
public interface UnitMapper {
    @Select("select * from TB_5BB22S0DOBK9W9H")
    List<UnitEntity> findAll();
}
