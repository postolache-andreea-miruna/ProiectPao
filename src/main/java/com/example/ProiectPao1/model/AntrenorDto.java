package com.example.ProiectPao1.model;


import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class AntrenorDto {
    private long id;
    private String nume;
    private String prenume;
    private String email;
    private int ani_experienta;
    private Boolean este_acreditat;
    private int nr_sportivi_act;
    private Double salariu;
    private long clubId;
    private long tipsportId;

    public AntrenorDto() {}

    public AntrenorDto(long id, String nume, String prenume, String email, int ani_experienta, Boolean este_acreditat, int nr_sportivi_act, Double salariu, long clubId, long tipsportId) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.ani_experienta = ani_experienta;
        this.este_acreditat = este_acreditat;
        this.nr_sportivi_act = nr_sportivi_act;
        this.salariu = salariu;
        this.clubId = clubId;
        this.tipsportId = tipsportId;
    }
}
