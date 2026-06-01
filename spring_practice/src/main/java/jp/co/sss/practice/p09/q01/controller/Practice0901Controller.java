package jp.co.sss.practice.p09.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import jp.co.sss.practice.p09.q01.form.PersonalInfoForm;

@Controller
public class Practice0901Controller {
	//入力画面表示用
	@GetMapping("/personal_info/input")
	public String showPersonalInfoInput(@ModelAttribute PersonalInfoForm personalInfoForm) {
		return "practice09/01/info_input";
	}

	//入力チェック処理用のメソッド
	@PostMapping("/personal_info/check")
	public String checkPersonalInfo(@Valid @ModelAttribute PersonalInfoForm personalInfoForm, BindingResult result) {
		//入力エラーがある場合入力画面を表示
		if (result.hasErrors()) {
			return "practice09/01/info_input";
		} else {
			return "practice09/01/input_ok";
		}
	}
}
