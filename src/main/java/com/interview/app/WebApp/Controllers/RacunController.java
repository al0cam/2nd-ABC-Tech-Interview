package com.interview.app.WebApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.interview.app.WebApp.Models.Racun;
import com.interview.app.WebApp.Service.RacunService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class RacunController {

	@Autowired
	RacunService racunService;

    @GetMapping("/greeting")
	public String greeting() {
		return "Hello World!";
	}
	
	@GetMapping("/")
	public List<Racun> getAllRacun() {
		return racunService.findAll();
	}

	@GetMapping("/racun/{id}")
	public Racun getRacunById(@PathVariable("id") Long id) {
		return racunService.findRacunById(id);
	}

	@PostMapping("/racun/add")
	public Racun addRacun(@RequestBody Racun racun) {
		return racunService.addRacun(racun);
	}

	@PostMapping("/racun/update")
	public Racun updateRacun(@RequestBody Racun racun) {
		return racunService.updateRacun(racun);
	}

	@DeleteMapping("/racun/delete/{id}")
	public void deleteRacun(@PathVariable("id") Long id) {
		racunService.deleteRacun(id);
	}

}