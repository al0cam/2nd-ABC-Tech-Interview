package com.interview.app.WebApp.Models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Racun {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long racun_id;

    @Getter
    @Setter
    private String iban;

    @Getter
    @Setter
    private Integer tip_racuna;

    @Getter
    @Setter
    private String valuta;
    
    @Getter
    @Setter
    private Integer klijent_id;
    
    @Getter
    @Setter
    private Date datum_otvaranja;

    @Getter
    @Setter
    private Date datum_zatvaranja;

}
