package com.interview.app.WebApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.app.WebApp.Models.Racun;

public interface RacunRepository extends JpaRepository<Racun, Long> {
    
}
