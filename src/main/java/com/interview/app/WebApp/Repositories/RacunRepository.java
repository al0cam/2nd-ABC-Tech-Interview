package com.interview.app.WebApp.Repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.interview.app.WebApp.Models.Racun;

public interface RacunRepository extends JpaRepository<Racun, Long> {
    // became obsolete when I added the @Query annotation because it can't handle the OR statement
    // public List<Racun> findByDatumZatvaranjaGreaterThanEqualOrDatumZatvaranjaIsNull(LocalDate date);

    @Query("SELECT r FROM Racun r WHERE (:date BETWEEN r.datumOtvaranja AND r.datumZatvaranja) OR :date >= r.datumOtvaranja AND r.datumZatvaranja IS NULL")
    public List<Racun> findByDateBetween(@Param("date") LocalDate date);
}
