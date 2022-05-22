package com.example.ProiectPao1.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AntrenorOlimpicDto extends AntrenorDto{
    private Double bonus;
    private Integer nr_ani_olimp_rez;

    @Builder

    public AntrenorOlimpicDto(long id, String nume, String prenume, String email, int ani_experienta, Boolean este_acreditat, int nr_sportivi_act, Double salariu, long clubId, long tipsportId, Double bonus, Integer nr_ani_olimp_rez) {
        super(id, nume, prenume, email, ani_experienta, este_acreditat, nr_sportivi_act, salariu, clubId, tipsportId);
        this.bonus = bonus;
        this.nr_ani_olimp_rez = nr_ani_olimp_rez;
    }
}
