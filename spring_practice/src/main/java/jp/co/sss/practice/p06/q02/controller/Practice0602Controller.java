package jp.co.sss.practice.p06.q02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.sss.practice.p06.entity.Area;
import jp.co.sss.practice.p06.repository.AreaRepository;
import jp.co.sss.practice.p06.repository.FruitsAreaRepository;

@Controller
public class Practice0602Controller {
	@Autowired
	FruitsAreaRepository fruitsAreaRepository;
	@Autowired
	AreaRepository areaRepository;

	@GetMapping("/fruits/select/area")
	public String showAreaSelection(Model model) {
		model.addAttribute("areas", areaRepository.findAllByOrderByAreaIdAsc());

		return "practice06/02/area_select";
	}

	@GetMapping("/fruits/select/area/result")
	public String showFruitsListByAreaId(@RequestParam Integer areaId, Model model) {
		//areaリポジトリを用いてareaId検索しAreaエンティティに格納
		Area area = areaRepository.getReferenceById(areaId);

		//Areaエンティティから地域名を取り出しリクエストスコープに保存
		model.addAttribute("areaName", area.getAreaName());

		//fruitsAreaリポジトリを用いてareaIdに一致するレコードを全件検索しリクエストスコープに保存
		model.addAttribute("fruits", fruitsAreaRepository.findByAreaAreaIdOrderByFruitIdAsc(areaId));

		return "practice06/02/fruits_list";
	}
}
