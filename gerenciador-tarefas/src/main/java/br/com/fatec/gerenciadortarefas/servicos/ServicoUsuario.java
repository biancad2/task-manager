package br.com.fatec.gerenciadortarefas.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fatec.gerenciadortarefas.modelos.Usuario;
import br.com.fatec.gerenciadortarefas.repositorios.RepositorioUsuario;

@Service
public class ServicoUsuario {
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	public Usuario procurarPorEmail(String email) {
		return repositorioUsuario.findByEmail(email);
	}
	
	public void salvar(Usuario usuario) {
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));		
		repositorioUsuario.save(usuario);
	}
}
