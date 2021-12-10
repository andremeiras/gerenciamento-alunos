package br.com.andremeiras.gerenciamentoalunos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.andremeiras.gerenciamentoalunos.service.AlunoService;

@Controller
public abstract class AlunoController {

	private AlunoService alunoService;

	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@GetMapping("/alunos")
	public String listarAlunos(Model model) {
		model.addAttribute("alunos", alunoService.getAllAlunos());

		return "alunos.html";
	}

}
