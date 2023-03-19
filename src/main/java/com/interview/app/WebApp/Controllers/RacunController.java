package com.interview.app.WebApp.Controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.interview.app.WebApp.Models.Racun;
import com.interview.app.WebApp.Service.RacunService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class RacunController {

	@Autowired
	RacunService racunService;

    @GetMapping("/greeting")
	public String greeting() {
		return "HelloWorld";
	}

	@GetMapping("/")
	public String getAllRacun(Model model) {
		LocalDate date = LocalDate.now();
		List<Racun> racuni = racunService.findByDate(date);
		model.addAttribute("racuni", racuni);
		return "Table";
	}
	
	@PostMapping("/")
	public String getAllRacunForDate(@ModelAttribute("date") LocalDate date, Model model) {
		if(date == null)
			date = LocalDate.now();
		List<Racun> racuni = racunService.findByDate(date);
		model.addAttribute("racuni", racuni);
		return "Table";
	}

	@GetMapping("/racun/{id}")
	public Racun getRacunById(@PathVariable("id") Long id) {
		return racunService.findRacunById(id);
	}

	@PostMapping("/racun/add")
	public Racun addRacun(@RequestBody Racun racun) {
		return racunService.addRacun(racun);
	}

	// Update does the same thing as add which could be troublesome.
	@PostMapping("/racun/update")
	public Racun updateRacun(@RequestBody Racun racun) {
		return racunService.updateRacun(racun);
	}

	@DeleteMapping("/racun/delete/{id}")
	public void deleteRacun(@PathVariable("id") Long id) {
		racunService.deleteRacun(id);
	}

}