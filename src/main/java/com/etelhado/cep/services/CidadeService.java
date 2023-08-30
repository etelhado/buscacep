package com.etelhado.cep.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.etelhado.cep.exceptions.RegistroNaoCadastradoEx;
import com.etelhado.cep.models.Cidade;
import com.etelhado.cep.repositories.CidadeRepository;
import com.etelhado.cep.repositories.EstadoRepository;

@Service
public class CidadeService {
	private final CidadeRepository repository;
	private final EstadoRepository estadoRepository;

	public CidadeService(CidadeRepository repository, EstadoRepository estadoRepository) {
		super();
		this.repository = repository;
		this.estadoRepository = estadoRepository;
	}

	public List<Cidade> listar() {
		return this.repository.listar();
	}

	public Cidade buscarPorId(Integer codigo) {
		return this.repository.buscarPorId(codigo);
	}

	public void cadastrar(Cidade cidade) throws RegistroNaoCadastradoEx {
		var estado = this.estadoRepository.buscarPorId(cidade.getCodigoEstado());
		if(estado == null) throw new RegistroNaoCadastradoEx("Estado não localizado");
		this.repository.cadastrar(cidade);
	}

	public void atualizar(Cidade cidade) throws RegistroNaoCadastradoEx {
		var estado = this.estadoRepository.buscarPorId(cidade.getCodigoEstado());
		if(estado == null) throw new RegistroNaoCadastradoEx("Estado não localizado");
		this.repository.atualizar(cidade);
	}
}
