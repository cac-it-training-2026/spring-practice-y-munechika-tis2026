package jp.co.sss.practice.p07.q02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jp.co.sss.practice.p07.entity.Type;
import jp.co.sss.practice.p07.repository.TypeRepository;

@Controller
public class Practice0702Controller {
	@Autowired
	TypeRepository typeRepository;
	@Autowired
	EntityManager entityManager;

	//検索条件入力画面表示用
	@GetMapping("/fruits_shop/named/input")
	public String searchInput(Model model) {
		model.addAttribute("types", typeRepository.findAll());

		return "practice07/02/search_input";
	}

	//表示情報の取得、結果表示用
	@GetMapping("/fruits_shop/named/result")
	public String showFindNamedQueryByPriceRangeAndType(Integer minPrice, Integer maxPrice,
			Integer typeId, Model model) {
		//Typeエンティティのオブジェクトを生成しtypeIdをセット
		Type type = new Type();
		type.setTypeId(typeId);
		//エンティティマネージャのメソッドでQueryオブジェクトを生成
		Query query = entityManager.createNamedQuery("findNamedQueryByPriceRangeAndType");
		//Typeエンティティのオブジェクト・minPrice・maxPriceをクエリのパラメータにバインド
		query.setParameter("type", type);
		query.setParameter("min", minPrice);
		query.setParameter("max", maxPrice);
		//クエリを実行し検索結果をリクエストスコープに保存
		model.addAttribute("items", query.getResultList());

		return "practice07/02/items_list";
	}

}
