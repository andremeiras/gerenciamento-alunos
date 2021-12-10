package br.com.andremeiras.gerenciamentoalunos.service;

import java.util.List;

import br.com.andremeiras.gerenciamentoalunos.entity.Aluno;

public interface AlunoService {

	List<Aluno> getAllAlunos();

	Aluno salvarAluno(Aluno aluno);
}
