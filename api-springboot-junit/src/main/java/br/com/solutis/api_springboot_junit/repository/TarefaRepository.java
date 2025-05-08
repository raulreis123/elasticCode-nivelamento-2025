package br.com.solutis.api_springboot_junit.repository;

import br.com.solutis.api_springboot_junit.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
}
