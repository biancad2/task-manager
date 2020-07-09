package br.com.fatec.gerenciadortarefas.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fatec.gerenciadortarefas.modelos.Usuario;
import br.com.fatec.gerenciadortarefas.servicos.ServicoUsuario;

@Controller
public class ContaController {
	
	@Autowired
	private ServicoUsuario servicoUsuario;
	
	@GetMapping("/login")
	public String login() {
	 return "conta/login";	
	}

	@GetMapping("/registration")
	public ModelAndView registrar() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("conta/registrar");
		mv.addObject("usuario", new Usuario());
		
		return mv;
	}
	
	@PostMapping("/registration")
	public ModelAndView registrar(@Valid Usuario usuario, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		Usuario usr = servicoUsuario.procurarPorEmail(usuario.getEmail());
		if(usr != null) {
			result.rejectValue("email", "", "Usuario ja cadastrado!");
		}
		if (result.hasErrors()) {
			mv.setViewName("conta/registrar");
			mv.addObject("usuario", usuario);
		} else {
			servicoUsuario.salvar(usuario);
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	

}
