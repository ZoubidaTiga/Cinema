package com.springdemo.cinemademo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Projection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date dateProjection;
    private double prix;
    @ManyToOne
    private Film film;
    @ManyToOne
    //@JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Salle salle;
    @OneToMany(mappedBy = "projection")
    //@JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Ticket> tickets;
    @ManyToOne
    private Seance seance;
}
