package com.etelhado.cep.models;

public class Estado {

	private Integer codigo;
	private String sigla;
	private String nome;

	public Estado() {
		super();
	}

	public Estado(Integer codigo, String sigla, String nome) {
		super();
		this.codigo = codigo;
		this.sigla = sigla;
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
