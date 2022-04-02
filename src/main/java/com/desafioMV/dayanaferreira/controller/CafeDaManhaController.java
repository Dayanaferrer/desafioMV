package com.desafioMV.dayanaferreira.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.desafioMV.dayanaferreira.models.CafeDaManha;
import com.desafioMV.dayanaferreira.repository.CafeDaManhaRepository;

@Controller
public class CafeDaManhaController {
	
	@Autowired
	private CafeDaManhaRepository cf;
	
	@RequestMapping(value= "/cadastrar", method= {RequestMethod.GET})
	public String form() {
		return "cafeManha/formCafe";
	}
	
	@RequestMapping(value= "/cadastrar", method= {RequestMethod.POST})
	public String form(CafeDaManha cafeDaManha) {
		
		cf.save(cafeDaManha);
		
		return "redirect:/cadastrar";
	}
	
	@RequestMapping("/cadastros")
	public String listaCafeDaManha() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<CafeDaManha> cafeDaManha = cf.findAll();
		mv.addObject("cadastros",cafeDaManha);
		return mv;
		
	}
	
	
	

}
