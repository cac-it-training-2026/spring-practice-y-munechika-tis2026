package jp.co.sss.practice.p10.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Practice1001Controller {
	@GetMapping("/filter/def")
	public String thisDoesNothing() {
		return "practice10/01/filter_view";
	}

	@GetMapping("/filter/xyz")
	public String yoCheckItOut() {
		return "practice10/01/filter_redirect";
	}
}
