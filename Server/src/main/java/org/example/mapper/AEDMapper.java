package org.example.mapper;

import org.example.entities.AED;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface AEDMapper {

    @Insert("INSERT INTO aed (name, description, latitude, longitude) VALUES (#{name}, #{description}, #{latitude}, #{longitude})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addAed(AED aed);

    @Delete("DELETE FROM aed WHERE id = #{id}")
    int deleteAed(Long id);

    @Select("SELECT id, name, description, latitude, longitude FROM aed")
    List<AED> getAllAeds();
}
