package com.example.ProiectPao1.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SportivLotDto extends SportivDto{

    private Double indemnizatie;
    private Integer nr_ani_lot;

    @Builder

    public SportivLotDto(long id, String cnp, String nume, String prenume, int an_nastere, char gen, String categorie, Double indemnizatie, Integer nr_ani_lot, long antrenorId, Double indemnizatie1, Integer nr_ani_lot1) {
        super(id, cnp, nume, prenume, an_nastere, gen, categorie, antrenorId);
        this.indemnizatie = indemnizatie;
        this.nr_ani_lot = nr_ani_lot;
    }
}
