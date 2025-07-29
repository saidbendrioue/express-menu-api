// Menu.java
package com.bendrioue.expressmenu.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_menu")
public class Menu {
    @Id
    private UUID id;
    private String name;
    private String description;
    private boolean active;
    
    @ManyToOne
    private FastFood fastFood;
    
    @OneToMany(mappedBy = "menu")
    private List<Section> sections;
}
