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
    private Long racunId;
    private String iban;
    private Integer tipRacuna;
    private String valuta;
    private Integer klijentId;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate datumOtvaranja;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate datumZatvaranja;
}
