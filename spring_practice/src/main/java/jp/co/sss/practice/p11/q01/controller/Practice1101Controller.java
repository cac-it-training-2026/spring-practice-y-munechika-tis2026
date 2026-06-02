package jp.co.sss.practice.p11.q01.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Practice1101Controller {
	@GetMapping("/fortune")
	public String showFortune(Model model) {
		Integer luckNum = (int) ((Math.random() * 10000) % 5 + 1);
		System.out.println(luckNum);
		model.addAttribute("luckNum", luckNum);
		model.addAttribute("now", new Date());

		return "practice11/01/fortune";
	}
}
