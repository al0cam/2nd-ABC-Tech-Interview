package com.interview.app.WebApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.app.WebApp.Models.Racun;
import com.interview.app.WebApp.Repositories.RacunRepository;

@RestController
public class RacunController {

	@Autowired
	RacunRepository racunRepository;

    @GetMapping("/greeting")
	public String greeting() {
		return "Hello World!";
	}
	
	@GetMapping("/")
	public List<Racun> getAllRacun() {
		return racunRepository.findAll();
	}
}
