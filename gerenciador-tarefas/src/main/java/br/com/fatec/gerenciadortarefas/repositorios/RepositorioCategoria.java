package br.com.fatec.gerenciadortarefas.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fatec.gerenciadortarefas.modelos.Categoria;
import br.com.fatec.gerenciadortarefas.modelos.Tarefa;

public interface RepositorioCategoria extends JpaRepository<Categoria, Long> {
	
}
