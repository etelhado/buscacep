package com.etelhado.cep.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.etelhado.cep.models.Estado;
import com.etelhado.cep.repositories.EstadoRepository;

@Service
public class EstadoService {
	private final EstadoRepository estadoRepository;

	public EstadoService(EstadoRepository estadoRepository) {
		this.estadoRepository = estadoRepository;
	}

	public List<Estado> listar() {
		return this.estadoRepository.listar();
	}

	public Estado buscarPorId(Integer codigo) {
		return this.estadoRepository.buscarPorId(codigo);
	}

	public void atualizar(Estado estado) {
		this.estadoRepository.atualizar(estado);
	}

	public void cadastrar(Estado estado) {
		this.estadoRepository.cadastrar(estado);
	}
}
