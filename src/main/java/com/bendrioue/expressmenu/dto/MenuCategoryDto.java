// MenuCategoryDto.java
package com.bendrioue.expressmenu.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuCategoryDto {
    private UUID id;
    private String name;
    private int displayOrder;
    private UUID menuId;
    private List<MenuItemDto> items;
}
