package br.com.fatec.gerenciadortarefas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatec.gerenciadortarefas.modelos.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

	Usuario findByEmail(String email);
	
}
