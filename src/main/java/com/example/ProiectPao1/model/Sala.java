package com.example.ProiectPao1.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sali")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nume")
    private String nume;
    @Column(name = "locatie")
    private String locatie;
    @Column(name = "evaluare")
    private int evaluare;
    @Column(name = "lungime_zona_sport")
    private int lungime_zona_sport;
    @Column(name = "latime_zona_sport")
    private int latime_zona_sport;
    @Column(name = "lungime_sala")
    private int lungime_sala;
    @Column(name = "latime_sala")
    private int latime_sala;
    @Column(name = "inaltime_sala")
    private int inaltime_sala;
    @Column(name = "renovat")
    private Boolean renovat;
    @Column(name = "tipsportid")
    private long tipsportId;
}
