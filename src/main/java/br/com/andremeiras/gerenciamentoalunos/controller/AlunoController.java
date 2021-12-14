package br.com.andremeiras.gerenciamentoalunos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.andremeiras.gerenciamentoalunos.entity.Aluno;
import br.com.andremeiras.gerenciamentoalunos.service.AlunoService;

@Controller
public class AlunoController {

	private AlunoService alunoService;

	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@GetMapping("/alunos")
	public String listarAlunos(Model model) {
		model.addAttribute("alunos", alunoService.getAllAlunos());
		return "alunos";
	}

	@GetMapping("/alunos/cadastro")
	public String cadastrarAlunoViaForm(Model model) {
		Aluno aluno = new Aluno();
		model.addAttribute("aluno", aluno);
		return "cadastrarAluno";
	}

	@PostMapping("/alunos")
	public String salvarAluno(@ModelAttribute("aluno") Aluno aluno) {
		alunoService.salvarAluno(aluno);
		return "redirect:/alunos";
	}

	@GetMapping("/alunos/editar/{id}")
	public String editarAlunoViaForm(@PathVariable Long id, Model model) {
		model.addAttribute("aluno", alunoService.getAlunoById(id));
		return "atualizarAluno";
	}

	@PostMapping("/alunos/{id}")
	public String atualizarAluno(@PathVariable Long id, @ModelAttribute("aluno") Aluno aluno, Model model) {
		Aluno existeAluno = alunoService.getAlunoById(id);
		existeAluno.setId(id);
		existeAluno.setNome(aluno.getNome());
		existeAluno.setSobrenome(aluno.getSobrenome());
		existeAluno.setEmail(aluno.getEmail());
		existeAluno.setIdade(aluno.getIdade());

		alunoService.atualizarAluno(existeAluno);

		return "redirect:/alunos";
	}

	@GetMapping("/alunos/excluir/{id}")
	public String excluirAluno(@PathVariable Long id) {
		alunoService.excluirAlunoById(id);
		return "redirect:/alunos";
	}
}
