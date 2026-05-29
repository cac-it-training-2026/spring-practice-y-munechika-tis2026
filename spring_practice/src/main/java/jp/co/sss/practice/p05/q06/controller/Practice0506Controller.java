package jp.co.sss.practice.p05.q06.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.sss.practice.p05.bean.FruitsSeasonBean;
import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.form.FruitsSeasonForm;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0506Controller {
	@Autowired
	FruitsSeasonRepository repository;

	//フルーツ名選択画面表示用
	@GetMapping("/fruits/update")
	public String fruitsUpdateSelection(Model model) {
		//フルーツ情報一覧をDBから取得しリクエストスコープに保存
		model.addAttribute("fruits", repository.findAll());

		return "practice05/06/fruit_select";
	}

	//入力画面表示用
	@PostMapping("/fruits/update/input")
	public String fruitsUpdateInput(@RequestParam Integer fruitId, Model model) {
		//主キー検索
		FruitsSeason fruitSeason = repository.getReferenceById(fruitId);
		//Bean生成
		FruitsSeasonBean fruitsSeasonBean = new FruitsSeasonBean();
		//FruisSeasonエンティティからBeanにコピー
		BeanUtils.copyProperties(fruitSeason, fruitsSeasonBean);
		//Beanをリクエストスコープに保存
		model.addAttribute("fruit", fruitsSeasonBean);

		return "practice05/06/fruit_input";
	}

	//更新受付、更新処理、更新完了画面表示用
	@PostMapping("/fruits/update/complete/{fruitId}")
	public String fruitsUpdateComplete(@PathVariable Integer fruitId, FruitsSeasonForm fruitForm, Model model) {
		//FruitsSeasonエンティティにid検索でヒットしたレコードを格納
		FruitsSeason fruitsSeason = repository.getReferenceById(fruitId);
		//フォームクラスからfruitId以外をFruitsSeasonエンティティにコピー
		BeanUtils.copyProperties(fruitForm, fruitsSeason, "fruitId");
		//テーブル更新
		fruitsSeason = repository.save(fruitsSeason);
		//Bean生成
		FruitsSeasonBean fruitsSeasonBean = new FruitsSeasonBean();
		//FruitSeasonエンティティからBeanにコピー
		BeanUtils.copyProperties(fruitsSeason, fruitsSeasonBean);
		//Beanをリクエストスコープに保存
		model.addAttribute("fruit", fruitsSeasonBean);

		return "practice05/06/fruit_detail";
	}

}
