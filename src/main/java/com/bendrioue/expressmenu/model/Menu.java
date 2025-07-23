// Menu.java
package com.bendrioue.expressmenu.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Menu {
 @Id
    private UUID id;
    private String name;
    private String description;
    private boolean isActive;
    
    @ManyToOne
    private FastFood fastFood;
    
    @OneToMany(mappedBy = "menu")
    private List<MenuCategory> categories;
}
