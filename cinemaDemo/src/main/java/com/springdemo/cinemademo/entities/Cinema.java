package com.springdemo.cinemademo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cinema implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double longitude, altitude, latitude;
    private int nombreSalles;
    @OneToMany(mappedBy = "cinema")
    private Collection<Salle> salles;
    @ManyToOne
    private Ville ville;

}
