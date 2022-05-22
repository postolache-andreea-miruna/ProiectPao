package com.example.ProiectPao1.model;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class SportivDto {

    private long id;
    private String cnp;
    private String nume;
    private String prenume;
    private int an_nastere;
    private char gen;
    private String categorie;
    private long antrenorId;

    public SportivDto() {}

    public SportivDto(long id, String cnp, String nume, String prenume, int an_nastere, char gen, String categorie, long antrenorId) {
        this.id = id;
        this.cnp = cnp;
        this.nume = nume;
        this.prenume = prenume;
        this.an_nastere = an_nastere;
        this.gen = gen;
        this.categorie = categorie;
        this.antrenorId = antrenorId;
    }
}
