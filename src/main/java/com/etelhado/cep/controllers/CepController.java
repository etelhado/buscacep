package com.etelhado.cep.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etelhado.cep.models.Cep;
import com.etelhado.cep.repositories.CepRepository;

@RestController
@RequestMapping(path = "/api/cep")
public class CepController {

	private final CepRepository cepRepository;
	
	public CepController(CepRepository cepRepository) {
		this.cepRepository = cepRepository;
	}
	
	@GetMapping(path = "/{cep}")
	public ResponseEntity<Cep> buscar(@PathVariable(name = "cep") String cep) {
		var ceps = this.cepRepository.buscarCep(cep);
		if(ceps != null) {
			return ResponseEntity.ok(ceps);
		}
		return ResponseEntity.noContent().build();
	}
	
}
