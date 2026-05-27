package jp.co.sss.practice.p05.q03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jp.co.sss.practice.p05.bean.FruitsSeasonBean;
import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0503Controller {
	@Autowired
	FruitsSeasonRepository repository;

	//全件検索（fruitId昇順）
	@GetMapping("/fruits/list/sort/id")
	public String showFruitsListByOrderByFruitIdAsc(Model model) {
		model.addAttribute("fruits", repository.findAllByOrderByFruitIdAsc());

		return "practice05/03/fruits_list";
	}

	@GetMapping("/fruits/detail/{fruitId}")
	//入力された値を受け取り、DBの検索条件として利用
	public String showFruitListByReferenceById(@PathVariable Integer fruitId, Model model) {
		//FruitsSeasonリポジトリを用いてfruitId検索し、FruitsSeasonエンティティに格納
		FruitsSeason fruitsSeason = repository.getReferenceById(fruitId);

		//JavaBeanオブジェクトを作成
		FruitsSeasonBean fruitsSeasonBean = new FruitsSeasonBean();

		//検索結果（FruitsSeasonエンティティ）をJavaBeanオブジェクトにコピー
		fruitsSeasonBean.setFruitId(fruitsSeason.getFruitId());
		fruitsSeasonBean.setFruitName(fruitsSeason.getFruitName());
		fruitsSeasonBean.setSeasonMonth(fruitsSeason.getSeasonMonth());

		//JavaBeanオブジェクトをリクエストスコープに保存
		model.addAttribute("fruit", fruitsSeasonBean);

		return "practice05/03/fruit_detail";
	}
}
