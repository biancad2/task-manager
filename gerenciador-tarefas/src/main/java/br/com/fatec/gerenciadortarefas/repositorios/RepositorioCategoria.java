package br.com.fatec.gerenciadortarefas.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.fatec.gerenciadortarefas.modelos.Categoria;

public interface RepositorioCategoria extends JpaRepository<Categoria, Long> {
	
	
}
