package com.example.ProiectPao1.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tipurisporturi")
public class TipSport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nume")
    private String nume;
    @Column(name = "echipa")
    private Boolean echipa;
    @Column(name = "dificultate")
    private char dificultate;
}
