package br.com.andremeiras.gerenciamentoalunos.serviceImplements;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.andremeiras.gerenciamentoalunos.entity.Aluno;
import br.com.andremeiras.gerenciamentoalunos.repository.AlunoRepository;
import br.com.andremeiras.gerenciamentoalunos.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService {

	AlunoRepository alunoRepository;

	public AlunoServiceImpl(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	@Override
	public List<Aluno> getAllAlunos() {
		return alunoRepository.findAll();
	}

	@Override
	public Aluno salvarAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	@Override
	public Aluno getAlunoById(Long id) {
		return alunoRepository.findById(id).get();
	}

	@Override
	public Aluno atualizarAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	@Override
	public void excluirAlunoById(Long id) {
		alunoRepository.deleteById(id);
	}

}
