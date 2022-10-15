package com.springdemo.cinemademo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomClient;
    private double prix;
    @Column(unique = false,nullable = true)
    private Integer codePayement;
    private boolean reserve;
    @ManyToOne
    //@JsonIgnore
    private Place place;
    @ManyToOne
    //@JsonIgnore
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Projection projection;
}
