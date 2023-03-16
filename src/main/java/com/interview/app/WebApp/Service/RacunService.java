package com.interview.app.WebApp.Service;

import java.util.List;

import com.interview.app.WebApp.Models.Racun;

public interface RacunService {
    public List<Racun> findAll();
    public Racun findRacunById(Long id);
    public Racun addRacun(Racun racun);
    public Racun updateRacun(Racun racun);
    public void deleteRacun(Long id);
}
