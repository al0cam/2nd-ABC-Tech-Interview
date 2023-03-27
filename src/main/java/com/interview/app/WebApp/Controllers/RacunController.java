package com.interview.app.WebApp.Controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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
		Racun newRacun = new Racun();
		model.addAttribute("date", date);
		model.addAttribute("newRacun", newRacun);
		model.addAttribute("racuni", racuni);
		return "Table";
	}

	@GetMapping("/racun/{id}")
	public Racun getRacunById(@PathVariable("id") Long id) {
		return racunService.findRacunById(id);
	}

	@PostMapping("/racun/add")
	public String addRacun(
		@RequestParam(name="date", required=false) LocalDate date, 
		@ModelAttribute Racun racun) 
	{
		if(racunService.addRacun(racun) != null)
			return "redirect:/?date="+date;
		return null;
	}

	// No kind of mapping except post or get works
	@PostMapping("/racun/update")
	public String updateRacun(
		@RequestParam(name="date", required=false)
		LocalDate date, 
		@RequestBody Racun racun) 
	{
		if(racunService.updateRacun(racun) != null)
		{
			return "redirect:/?date="+date;
		}
		return null;
	}

	// Delete mapping doesnt work for some reason.
	@PostMapping("/racun/delete/{id}")
	public String deleteRacun(
		@PathVariable("id") Long id, 
		@ModelAttribute("date") LocalDate date) 
	{
		System.out.println("date: "+date);
		racunService.deleteRacun(id);
		return "redirect:/?date="+date;
	}

}