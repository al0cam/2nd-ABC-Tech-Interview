package com.interview.app.WebApp.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.app.WebApp.Models.Racun;
import com.interview.app.WebApp.Repositories.RacunRepository;

@Service
public class RacunServiceImp implements RacunService{
    @Autowired
    RacunRepository racunRepository;    

    @Override
    public List<Racun> findAll() {
        return racunRepository.findAll();
    }

    @Override
    public Racun findRacunById(Long id) {
        return racunRepository.findById(id).get();
    }

    @Override
    public Racun addRacun(Racun racun) {
        return racunRepository.save(racun);
    }

    @Override
    public Racun updateRacun(Racun racun) {
        return racunRepository.save(racun);
    }

    @Override
    public void deleteRacun(Long id) {
        racunRepository.deleteById(id);
    }

    @Override
    public List<Racun> findByDate(LocalDate date) {
        // return racunRepository.findByDatumZatvaranjaGreaterThanEqualOrDatumZatvaranjaIsNull(date);
        return racunRepository.findByDateBetween(date);
    }
    
}
