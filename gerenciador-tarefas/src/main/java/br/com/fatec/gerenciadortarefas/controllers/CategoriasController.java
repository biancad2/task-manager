package br.com.fatec.gerenciadortarefas.controllers;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fatec.gerenciadortarefas.modelos.Categoria;
import br.com.fatec.gerenciadortarefas.modelos.Usuario;
import br.com.fatec.gerenciadortarefas.repositorios.RepositorioCategoria;
import br.com.fatec.gerenciadortarefas.servicos.ServicoUsuario;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {

	@Autowired
	private RepositorioCategoria repositorioCategoria;
	
	//@Autowired
	//private ServicoUsuario servicoUsuario;

	@GetMapping("/listar")
	public ModelAndView listar(HttpServletRequest request ) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("categorias/listar");
		mv.addObject("categorias", repositorioCategoria.findAll());
		return mv;
	}
	
	@GetMapping("/inserir")
	public ModelAndView inserir() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("categorias/inserir");
		mv.addObject("categoria", new Categoria());
		return mv;
		
	}
	
	@PostMapping("/inserir")
	public ModelAndView inserir(@Valid Categoria categoria, BindingResult result, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("categorias/inserir");
			mv.addObject(categoria);
		}else {
			repositorioCategoria.save(categoria);
			mv.setViewName("redirect:/categorias/listar");
		}
		return mv;
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		Categoria categoria = repositorioCategoria.getOne(id);
		mv.setViewName("categorias/alterar");
		mv.addObject("categoria", categoria);
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(@Valid Categoria categoria, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("categorias/alterar");
		}else {
			mv.setViewName("redirect:/categorias/listar");
			repositorioCategoria.save(categoria);
		}
		return mv;
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id) {
		repositorioCategoria.deleteById(id);
		return "redirect:/categorias/listar";
	}
	

}
