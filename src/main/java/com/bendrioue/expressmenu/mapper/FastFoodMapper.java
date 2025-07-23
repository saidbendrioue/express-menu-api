package com.bendrioue.expressmenu.mapper;

import com.bendrioue.expressmenu.dto.FastFoodDto;
import com.bendrioue.expressmenu.model.FastFood;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FastFoodMapper {
    FastFoodDto toDto(FastFood fastFood);
}
