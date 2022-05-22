package com.example.ProiectPao1.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cluburi")
public class Club implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nume")
    private String nume;
    @Column(name = "email")
    private String email;
    @Column(name = "numar_inregistrare")
    private int numar_inregistrare;
    @Column(name = "an_infiintare")
    private int an_infiintare;
    @Column(name = "administratorid")
    private long administratorId;

}
