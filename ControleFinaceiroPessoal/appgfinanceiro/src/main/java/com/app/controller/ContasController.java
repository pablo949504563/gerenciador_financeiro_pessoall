package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.ContasModel;
import com.app.repository.ContasRepository;
import com.app.service.ContaService;

@Controller
public class ContasController {
	
	@Autowired
	private ContasRepository cr;

	
	@RequestMapping("/")
	public String contas() {
		
		return "contas";
	}
	
	@RequestMapping(value="/cadastrarContas", method=RequestMethod.GET)
	public String formContas(ContasModel contasModel) {
		
		return "cadastrarContas";
		
	}

	@RequestMapping(value="/cadastrarContas", method=RequestMethod.POST)
	public String formCadastrarContas(ContasModel contasModel) {
		cr.save(contasModel);
		return "cadastrarContas";
	
	}
	
	@RequestMapping("/contas")
	public ModelAndView listarContas() {
		ModelAndView mv = new ModelAndView("/contas");
		Iterable<ContasModel> conta = cr.findAll();
		mv.addObject("contas", conta);
		return mv;
	}
	
		
	private final ContaService contaService;
	public ContasController(ContaService contaService) {
		this.contaService = contaService;
	}
	@GetMapping("/contasTotais")
	public String listaContas(Model model) {
		model.addAttribute("contas", contaService.listarContas());
		model.addAttribute("totalContas", contaService.calcularTotalContas());
		return "contas";
	}
	
	
}
