package com.etelhado.cep.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etelhado.cep.models.Estado;
import com.etelhado.cep.services.EstadoService;



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
	
	
}
