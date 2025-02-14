package com.app.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import com.app.model.ContasModel;
import com.app.repository.ContasRepositoryT;

@Service
public class ContaService {
	
	private final ContasRepositoryT contasRepositoryT;
	
	public ContaService(ContasRepositoryT contasRepositoryT) {
		this.contasRepositoryT = contasRepositoryT;	
	}
	public List<ContasModel>listarContas(){
		return contasRepositoryT.findAll();
	}
	public BigDecimal calcularTotalContas() {
		return contasRepositoryT.findAll()
				.stream()
				.map(ContasModel::getValorPagamento)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		
	}
	
}
	
	

