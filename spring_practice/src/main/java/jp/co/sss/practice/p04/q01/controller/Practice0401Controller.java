package jp.co.sss.practice.p04.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.sss.practice.p04.q01.form.BmiForm;

@Controller
public class Practice0401Controller {
	@GetMapping("/bmi/input")
	public String bmiInput() {
		return "practice04/01/bmi_input";
	}

	@PostMapping("/bmi/result")
	public String bmiResult(@ModelAttribute BmiForm bmiForm) {
		bmiForm.setBmi(bmiForm.getWeight() / Math.pow((bmiForm.getHeight() / 100), 2));

		return "practice04/01/bmi_result";
	}
}
