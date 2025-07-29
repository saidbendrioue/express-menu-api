// Section.java
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
@Table(name = "t_section")
public class Section {
    @Id
    private UUID id;
    private String name;
    private int displayOrder;
    
    @ManyToOne
    private Menu menu;
    
    @OneToMany(mappedBy = "section")
    private List<Product> products;
}