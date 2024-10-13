package com.coworking.coworkingSpaces.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "spaces")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Spaces {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "image", nullable = false)
    private String image;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String city;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String description;
    @Column(nullable = false)
    private double price;
}
