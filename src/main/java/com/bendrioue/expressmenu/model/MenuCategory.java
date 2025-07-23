// MenuCategory.java
package com.bendrioue.expressmenu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MenuCategory {
    @Id
    private UUID id;
    private String name;
    private int displayOrder;
    
    @ManyToOne
    private Menu menu;
    
    @OneToMany(mappedBy = "category")
    private List<MenuItem> items;
}