package jp.co.sss.practice.p08.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import jp.co.sss.practice.p08.q01.form.BodyTempForm;

@Controller
public class Practice0801Controller {
	@GetMapping("/body_temp/input")
	public String showBodyTempInput(@ModelAttribute BodyTempForm bodyTempForm) {
		return "practice08/01/bt_input";
	}

	@PostMapping("/body_temp/check")
	public String bodyTempInputValidation(@Valid @ModelAttribute BodyTempForm bodyTempForm, BindingResult result) {
		//入力チェックにエラーがある場合は入力画面を表示
		if (result.hasErrors()) {
			return "practice08/01/bt_input";
		}
		//体温が正常範囲内か判定
		if (bodyTempForm.getBodyTemp() > 35.0 && bodyTempForm.getBodyTemp() < 37.5) {
			return "practice08/01/bt_ok";
		} else {
			return "practice08/01/bt_ng";
		}
	}
}
