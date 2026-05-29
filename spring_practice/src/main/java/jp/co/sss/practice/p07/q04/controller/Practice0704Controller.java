package jp.co.sss.practice.p07.q04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.sss.practice.p07.repository.FruitsShopItemRepository;

@Controller
public class Practice0704Controller {
	@Autowired
	FruitsShopItemRepository repository;

	@GetMapping("fruits_shop/type/sort/bycount")
	public String showTypeListFindQuerySortByTypeCount(Model model) {
		model.addAttribute("types", repository.findQuerySortByTypeCount());

		return "practice07/04/type_list";
	}
}
