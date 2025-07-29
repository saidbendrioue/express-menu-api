// FastFoodDto.java
package com.bendrioue.expressmenu.dto;

import lombok.*;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FastFoodDto {
    private UUID id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String logoUrl;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private UUID ownerId;
    private List<MenuDto> menus;
}

