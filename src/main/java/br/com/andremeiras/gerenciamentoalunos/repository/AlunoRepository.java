package br.com.andremeiras.gerenciamentoalunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.andremeiras.gerenciamentoalunos.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
