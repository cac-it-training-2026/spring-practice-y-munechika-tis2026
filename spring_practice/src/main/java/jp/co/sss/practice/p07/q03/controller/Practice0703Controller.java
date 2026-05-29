package jp.co.sss.practice.p07.q03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.sss.practice.p07.entity.Type;
import jp.co.sss.practice.p07.repository.FruitsShopItemRepository;
import jp.co.sss.practice.p07.repository.TypeRepository;

@Controller
public class Practice0703Controller {
	@Autowired
	FruitsShopItemRepository fruitsShopItemRepository;
	@Autowired
	TypeRepository typeRepository;

	@GetMapping("/fruits_shop/query/input")
	public String fruitsShopQueryInput(Model model) {
		model.addAttribute("types", typeRepository.findAll());

		return "practice07/03/search_input";
	}

	@GetMapping("/fruits_shop/query/result")
	public String showItemsListFindByPriceRangeAndType(Integer minPrice, Integer maxPrice, Integer typeId,
			Model model) {
		Type type = new Type();
		type.setTypeId(typeId);

		model.addAttribute("items", fruitsShopItemRepository.findByPriceRangeAndType(minPrice, maxPrice, type));

		return "practice07/03/items_list";
	}
}
