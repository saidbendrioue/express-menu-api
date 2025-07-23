package com.bendrioue.expressmenu.mapper;

import com.bendrioue.expressmenu.dto.MenuCategoryDto;
import com.bendrioue.expressmenu.model.MenuCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {MenuItemMapper.class})
public interface MenuCategoryMapper {
    MenuCategoryDto toDto(MenuCategory category);
}
