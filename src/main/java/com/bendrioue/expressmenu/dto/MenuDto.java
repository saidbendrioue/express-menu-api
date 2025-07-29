// MenuDto.java
package com.bendrioue.expressmenu.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto {
    private UUID id;
    private String name;
    private String description;
    private boolean active;
    private UUID fastFoodId;
    private List<SectionDto> sections;
}