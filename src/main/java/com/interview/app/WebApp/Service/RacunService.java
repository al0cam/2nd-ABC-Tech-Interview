package com.interview.app.WebApp.Service;

import java.util.List;

import com.interview.app.WebApp.Models.Racun;

public interface RacunService {
    public List<Racun> getAllRacun();
    public Racun getRacunById(Long id);
    public Racun addRacun(Racun racun);
    public Racun updateRacun(Racun racun);
    public void deleteRacun(Long id);
}
