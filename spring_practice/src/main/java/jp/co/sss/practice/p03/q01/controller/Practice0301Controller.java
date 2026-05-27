package jp.co.sss.practice.p03.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Practice0301Controller {
	@GetMapping("/input")
	public String input() {
		return "practice03/01/input_form";
	}

	@GetMapping("/send/get_method")
	public String getMethod(String color) {
		System.out.println("##GETメソッドで受け取りました");
		System.out.println("##パラメータの値:" + color);

		return "practice03/01/get_result";
	}

	@PostMapping("/send/post_method")
	public String postMethod(String color) {
		System.out.println("==POSTメソッドで受け取りました");
		System.out.println("==パラメータの値:" + color);

		return "practice03/01/post_result";
	}
}
