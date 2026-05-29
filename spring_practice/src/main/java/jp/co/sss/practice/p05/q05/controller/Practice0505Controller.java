package jp.co.sss.practice.p05.q05.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.sss.practice.p05.bean.FruitsSeasonBean;
import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.form.FruitsSeasonForm;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0505Controller {
	@Autowired
	FruitsSeasonRepository repository;

	//入力画面表示表
	@GetMapping("/fruits/add/input")
	public String fruitsAddInput() {
		return "practice05/05/fruit_input";
	}

	//登録受付、登録処理、登録完了画面表示用
	@PostMapping("/fruits/add/complete")
	public String fruitsAddComplete(@ModelAttribute FruitsSeasonForm fruitForm, Model model) {
		//FruitsSeasonエンティティの生成
		FruitsSeason fruitsSeason = new FruitsSeason();
		//フォームクラスからエンティティにコピー
		BeanUtils.copyProperties(fruitForm, fruitsSeason);
		//エンティティをFruitsSeasonRepository#save()でテーブルに登録
		fruitsSeason = repository.save(fruitsSeason);
		//Bean生成
		FruitsSeasonBean fruitsSeasonBean = new FruitsSeasonBean();
		//エンティティからBeanにコピー
		BeanUtils.copyProperties(fruitsSeason, fruitsSeasonBean);
		//Beanをリクエストスコープに保存
		model.addAttribute("fruit", fruitsSeasonBean);

		return "practice05/05/fruit_detail";
	}
}
