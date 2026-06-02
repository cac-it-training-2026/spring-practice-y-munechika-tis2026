package jp.co.sss.practice.p11.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Practice1102Controller {
	@GetMapping("/checkbox/input")
	public String showCheckBoxes() {
		return "practice11/02/checkbox_input";
	}

	@PostMapping("/checkbox/result")
	public String showVisitedPlaces(Model model, String[] destPrefs) {
		model.addAttribute("destPrefs", destPrefs);

		return "practice11/02/result";
	}
}
