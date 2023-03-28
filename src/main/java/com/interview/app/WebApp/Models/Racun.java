package com.interview.app.WebApp.Models;

import java.time.LocalDate;

import org.springframework.lang.Nullable;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Racun {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="racunSeq")
    @SequenceGenerator(name="racunSeq", sequenceName = "racun_seq", allocationSize=1)
    private Long racunId;
    private String iban;
    private Integer tipRacuna;
    private String valuta;
    private Integer klijentId;
    private LocalDate datumOtvaranja;
    @Nullable
    private LocalDate datumZatvaranja;
}
