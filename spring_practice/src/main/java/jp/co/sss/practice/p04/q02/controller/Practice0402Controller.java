package jp.co.sss.practice.p04.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class Practice0402Controller {
	@GetMapping("/numguess/start")
	public String numguessStart(HttpSession session) {
		Integer hitNumber = (int) (Math.floor(Math.random() * 9) + 1);

		session.setAttribute("hitNumber", hitNumber);

		System.out.println("当たりの数値:" + (Integer) session.getAttribute("hitNumber"));

		return "practice04/02/numguess_start";
	}

	@GetMapping("/numguess/input")
	public String numguessInput() {
		return "practice04/02/numguess_input";
	}

	@GetMapping("/numguess/judge")
	public String numguessJudge(HttpSession session, Integer inputNum) {
		if (((Integer) session.getAttribute("hitNumber")) == inputNum) {
			return "redirect:/numguess/hit";
		} else {
			return "practice04/02/numguess_judge";
		}
	}

	@GetMapping("/numguess/hit")
	public String numguessHit(HttpSession session) {
		session.setAttribute("message", "当たりです！正解は" + ((Integer) session.getAttribute("hitNumber")) + "でした。");

		session.removeAttribute("hitNumber");

		return "practice04/02/numguess_end";
	}
}
