package com.example.ProiectPao1.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sportivi")
public class Sportiv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "cnp")
    private String cnp;
    @Column(name = "nume")
    private String nume;
    @Column(name = "prenume")
    private String prenume;
    @Column(name = "an_nastere")
    private int an_nastere;
    @Column(name = "gen")
    private char gen;
    @Column(name = "categorie")
    private String categorie;

    @Column(name = "indemnizatie")
    private Double indemnizatie;
    @Column(name = "nr_ani_lot")
    private Integer nr_ani_lot;

    @Column(name = "antrenorid")
    private long antrenorId;
}
