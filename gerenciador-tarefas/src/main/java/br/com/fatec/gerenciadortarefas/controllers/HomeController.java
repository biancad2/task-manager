package br.com.fatec.gerenciadortarefas.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@GetMapping("/")
	public ModelAndView home(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/home");
		mv.addObject("mensagem","Ola, " + request.getUserPrincipal().getName());
		return mv;
	}
}
