package com.etelhado.cep.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etelhado.cep.exceptions.RegistroNaoCadastradoEx;
import com.etelhado.cep.models.Cidade;
import com.etelhado.cep.services.CidadeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/cidades")
public class CidadeController {

	private final CidadeService service;

	public CidadeController(CidadeService service) {
		super();
		this.service = service;
	}

	@GetMapping(path = "/")
	public ResponseEntity<List<Cidade>> listar() {
		var cidades = this.service.listar();
		return ResponseEntity.ok(cidades);
	}

	@GetMapping(path = "/{codigo}")
	public ResponseEntity<Cidade> buscar(@PathVariable(name = "codigo") Integer codigo) {
		var cidade = this.service.buscarPorId(codigo);
		if (cidade == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cidade);
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<?> cadastrar(@RequestBody @Valid Cidade cidade, BindingResult result) {
		if(result.hasErrors()) {
			Map<String,String> mensagem = new HashMap<String, String>();
			result.getFieldErrors().stream().forEach(error -> {
				mensagem.put(error.getField(), error.getDefaultMessage());
			});
			return ResponseEntity.badRequest().body(mensagem);
		}
		try {
			this.service.cadastrar(cidade);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (RegistroNaoCadastradoEx e) {
			Map<String,String> mensagem = new HashMap<String, String>();
			mensagem.put("mensagem", "Falha ao cadastrar estado não localizado!");
			return ResponseEntity.badRequest().body(mensagem);
		}
		
	}
	
	@PutMapping(path = "/")
	public ResponseEntity<?> atualizar(@RequestBody @Valid Cidade cidade, BindingResult result) {
		if(result.hasErrors()) {
			Map<String,String> mensagem = new HashMap<String, String>();
			result.getFieldErrors().stream().forEach(error -> {
				mensagem.put(error.getField(), error.getDefaultMessage());
			});
			return ResponseEntity.badRequest().body(mensagem);
		}
		try {
			this.service.atualizar(cidade);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (RegistroNaoCadastradoEx e) {
			Map<String,String> mensagem = new HashMap<String, String>();
			mensagem.put("mensagem", "Falha ao atualizar estado não localizado!");
			return ResponseEntity.badRequest().body(mensagem);
		}
		
	}

}
