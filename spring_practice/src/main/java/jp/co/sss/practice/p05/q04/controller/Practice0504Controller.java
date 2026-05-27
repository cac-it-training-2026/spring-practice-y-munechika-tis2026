package jp.co.sss.practice.p05.q04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0504Controller {
	@Autowired
	FruitsSeasonRepository repository;

	//季節選択画面表示用
	@GetMapping("/fruits/search/input")
	public String fruitSeasonSelection() {
		return "practice05/04/fruits_select_season";
	}

	//検索処理、結果表示用
	@GetMapping("/fruits/search/result")
	public String showFruitsListFindBySeasonMonth(Integer season, Model model) {
		//検索結果をリクエストスコープに保存
		model.addAttribute("fruits", repository.findBySeasonMonthOrderByFruitId(season));

		//検索条件文字列を生成してリクエストスコープに保存
		if (season == 13) {
			model.addAttribute("keyword", "通年");
		} else {
			model.addAttribute("keyword", season + "月");
		}

		return "practice05/04/fruits_list";
	}
}
