// MenuItemDto.java
package com.bendrioue.expressmenu.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemDto {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private boolean isAvailable;
    private String imageUrl;
    private UUID categoryId;
}
