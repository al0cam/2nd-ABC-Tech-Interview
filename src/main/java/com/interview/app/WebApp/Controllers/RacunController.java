package com.interview.app.WebApp.Controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.interview.app.WebApp.Models.Racun;
import com.interview.app.WebApp.Service.RacunService;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class RacunController {

	@Autowired
	RacunService racunService;

    @GetMapping("/greeting")
	public String greeting() {
		return "HelloWorld";
	}

	@GetMapping("/")
	public String getAllRacun(@RequestParam(name="date", required=false) LocalDate date, Model model) {
		System.out.println("dateGET: "+date);
		if(date == null)
			date = LocalDate.now();
		List<Racun> racuni = racunService.findByDate(date);
		model.addAttribute("date", date);
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
	public ResponseEntity<Racun> addRacun(@RequestBody Racun racun) {
		System.out.println("DATUM: "+racun.getDatumOtvaranja());
		System.out.println("DATUMZa: "+racun.getDatumZatvaranja());
		if(racunService.addRacun(racun) != null)
			return ResponseEntity.ok(racun);	
		else
			return ResponseEntity.badRequest().build();
	}

	// Update does the same thing as add which could be troublesome.
	@PutMapping("/racun/update")
	public Racun updateRacun(@RequestBody Racun racun) {
		return racunService.updateRacun(racun);
	}

	@PostMapping("/racun/delete/{id}")
	public String deleteRacun(
		@PathVariable("id") Long id, 
		@ModelAttribute("date") LocalDate date, 
		RedirectAttributes redirectAttributes) 
	{
		System.out.println("date: "+date);
		racunService.deleteRacun(id);
		redirectAttributes.addFlashAttribute("date", date);
		return "redirect:/";
	}

}