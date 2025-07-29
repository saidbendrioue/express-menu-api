// FastFood.java
package com.bendrioue.expressmenu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_fast_food")
public class FastFood {
    @Id
    private UUID id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String logoUrl;
    private LocalTime openingTime;
    private LocalTime closingTime;

    @ManyToOne
    private User owner;

    @OneToMany(mappedBy = "fastFood")
    private List<Menu> menus;
}
