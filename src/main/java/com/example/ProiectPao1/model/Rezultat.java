package com.example.ProiectPao1.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.DateFormat;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "rezultate")
public class Rezultat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nume_competitie")
    private String nume_competitie;
    @Column(name = "nume_proba")
    private String nume_proba;
    @Column(name = "timp")
    private int timp;
    @Column(name = "zi_rez")
    private int zi_rez;
    @Column(name = "luna_rez")
    private int luna_rez;
    @Column(name = "an_rez")
    private int an_rez;
    @Column(name = "sportivid")
    private long sportivId;
}
