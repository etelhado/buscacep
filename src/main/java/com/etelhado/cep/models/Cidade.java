package com.etelhado.cep.models;

public class Cidade {
	private Integer codigo;
	private String nome;
	private String ibge;
	private Integer codigoEstado;

	public Cidade() {
		super();

	}

	public Cidade(Integer codigo, String nome, String ibge, Integer codigoEstado) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.ibge = ibge;
		this.codigoEstado = codigoEstado;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public Integer getCodigoEstado() {
		return codigoEstado;
	}

	public void setCodigoEstado(Integer codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

}
