package com.produban.ejercicio010;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView res = new ModelAndView("welcome");
		res.addObject("compra", new CompraForm());
		return res;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView welcome(CompraForm form) {
		ModelAndView res = new ModelAndView("welcome");
		int a = form.getCantidad();
		form.setCantidad(form.getSalaId());
		form.setSalaId(a);
		res.addObject("compra", form);
		return res;
	}
	
}
