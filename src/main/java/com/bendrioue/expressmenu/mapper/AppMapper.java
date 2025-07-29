package com.bendrioue.expressmenu.mapper;

import com.bendrioue.expressmenu.dto.*;
import com.bendrioue.expressmenu.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppMapper {

    // User mappings
    @Mapping(target = "id", ignore = true)
    UserDto userToUserDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fastFoods", ignore = true)
    User userDtoToUser(UserDto userDto);

    // FastFood mappings
    @Mapping(target = "ownerId", source = "owner.id")
    @Mapping(target = "menus", ignore = true) // Avoid circular reference
    FastFoodDto fastFoodToFastFoodDto(FastFood fastFood);

    @Mapping(target = "owner", ignore = true)
    @Mapping(target = "menus", ignore = true)
    FastFood fastFoodDtoToFastFood(FastFoodDto fastFoodDto);

    // Menu mappings
    @Mapping(target = "fastFoodId", source = "fastFood.id")
    MenuDto menuToMenuDto(Menu menu);

    @Mapping(target = "fastFood", ignore = true)
    @Mapping(target = "sections", ignore = true)
    Menu menuDtoToMenu(MenuDto menuDto);

    // Section mappings
    @Mapping(target = "menuId", source = "menu.id")
    SectionDto sectionToSectionDto(Section section);

    @Mapping(target = "menu", ignore = true)
    Section sectionDtoToSection(SectionDto sectionDto);

    // Product mappings
    @Mapping(target = "sectionId", source = "section.id")
    ProductDto productToProductDto(Product product);

    @Mapping(target = "section", ignore = true)
    Product productDtoToProduct(ProductDto productDto);
}