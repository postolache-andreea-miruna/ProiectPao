package com.example.ProiectPao1.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.util.PropertySource;

import javax.persistence.*;
import java.util.Comparator;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "antrenori")
public class Antrenor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nume")
    private String nume;
    @Column(name = "prenume")
    private String prenume;
    @Column(name = "email")
    private String email;
    @Column(name = "ani_experienta")
    private int ani_experienta;
    @Column(name = "este_acreditat")
    private Boolean este_acreditat;
    @Column(name = "nr_sportivi_act")
    private int nr_sportivi_act;
    @Column(name = "salariu")
    private Double salariu;
    @Column(name = "bonus")
    private Double bonus;
    @Column(name = "nr_ani_olimp_rez")
    private Integer nr_ani_olimp_rez;
    @Column(name = "clubid")
    private long clubId;
    @Column(name = "tipsportid")
    private long tipsportId;


}
