package com.bendrioue.expressmenu.mapper;

import com.bendrioue.expressmenu.dto.MenuDto;
import com.bendrioue.expressmenu.model.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {MenuCategoryMapper.class})
public interface MenuMapper {

    @Mapping(source = "fastFood.id", target = "fastFoodId")
    MenuDto toDto(Menu menu);
}
