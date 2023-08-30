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

import com.etelhado.cep.models.Estado;
import com.etelhado.cep.services.EstadoService;

import jakarta.validation.Valid;



@RestController
@RequestMapping(path = "api/estados")
public class EstadoController {

	private final EstadoService estadoService;

	public EstadoController(EstadoService estadoService) {
		this.estadoService = estadoService;
	}
	
	
	@GetMapping(path = "/")
	public ResponseEntity<List<Estado>> listar() {
		var estados = estadoService.listar();
		return ResponseEntity.ok(estados);
	}
	
	@GetMapping(path = "/{codigo}")
	public ResponseEntity<Estado> buscarId(@PathVariable(name = "codigo") Integer codigo) {
		var estado = this.estadoService.buscarPorId(codigo);
		if(estado == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(estado);
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<?> cadastrar(@RequestBody @Valid Estado estado, BindingResult result) {
		if(result.hasErrors()) {
			Map<String,String> mensagem = new HashMap<String, String>();
			result.getFieldErrors().stream().forEach(error -> {
				mensagem.put(error.getField(), error.getDefaultMessage());
			});
			return ResponseEntity.badRequest().body(mensagem);
		}
		this.estadoService.cadastrar(estado);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping(path = "/")
	public ResponseEntity<?> atualizar(@RequestBody @Valid Estado estado, BindingResult result) {
		if(result.hasErrors()) {
			Map<String,String> mensagem = new HashMap<String, String>();
			result.getFieldErrors().stream().forEach(error -> {
				mensagem.put(error.getField(), error.getDefaultMessage());
			});
			return ResponseEntity.badRequest().body(mensagem);
		}
		this.estadoService.atualizar(estado);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();	
	}
	
	
}
