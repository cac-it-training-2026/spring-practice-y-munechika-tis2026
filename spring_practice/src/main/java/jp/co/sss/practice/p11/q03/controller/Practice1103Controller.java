package jp.co.sss.practice.p11.q03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Practice1103Controller {
	@GetMapping("/layout/first")
	public String showFirstLayout() {

		return "practice11/03/first";
	}

	@GetMapping("/layout/second")
	public String showSecondLayout() {

		return "practice11/03/second";
	}

	@GetMapping("/layout/third")
	public String showThirdLayout() {

		return "practice11/03/third";
	}

}
