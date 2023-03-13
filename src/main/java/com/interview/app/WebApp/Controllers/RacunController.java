package com.interview.app.WebApp.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RacunController {
    @GetMapping("/greeting")
	public String greeting() {
		return "Hello World!";
	}
}
