package com.springdemo.cinemademo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double longitude, altitude, latitude;
    @OneToMany(mappedBy = "ville")
    private Collection<Cinema> cinemas;
}
