package com.bendrioue.expressmenu.mapper;

import com.bendrioue.expressmenu.dto.MenuItemDto;
import com.bendrioue.expressmenu.model.MenuItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MenuItemMapper {
    MenuItemDto toDto(MenuItem item);
}
