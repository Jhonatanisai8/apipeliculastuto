package com.api.apipeliculas.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Integer year;
    @Column(nullable = false)
    private Integer votes;
    @Column(nullable = false)
    private Double rating;
    @Column(nullable = false)
    private String imageUrl;
    

}
