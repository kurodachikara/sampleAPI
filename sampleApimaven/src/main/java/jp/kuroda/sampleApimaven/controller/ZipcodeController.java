package jp.kuroda.sampleApimaven.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.kuroda.sampleApimaven.dto.ZipcodeDto;
import jp.kuroda.sampleApimaven.service.ZipcodeService;

@Controller
public class ZipcodeController {
	@Autowired
	ZipcodeService zipService;	
	@GetMapping("/zipcode")
	public String zipcodeForm(HttpSession session,Model model) {
		return "zipcode";
	}
	@PostMapping("/zipcode/confirm")
	public String zipcodeConfirm(HttpSession session,Model model,@RequestParam("zipcode")String zipcode) {
		if(zipcode==null||zipcode.equals("")) {
			model.addAttribute("errormessage","郵便番号を入力してください");
			return zipcodeForm(session,model);
		}
		ZipcodeDto zipcodeDto=zipService.service(zipcode);
		model.addAttribute("zipcodeList",zipcodeDto.getResults());
		return "zipcode-confirm";
	}//
}
