package com.interview.app.WebApp.Models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    private Long racun_id;
    private String iban;
    private Integer tip_racuna;
    private String valuta;
    private Integer klijent_id;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate datum_otvaranja;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate datum_zatvaranja;
}
