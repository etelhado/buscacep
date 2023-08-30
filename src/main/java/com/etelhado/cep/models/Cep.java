package com.etelhado.cep.models;

public class Cep {
	private Integer codigo;
	private String sigla;
	private String nome;
	CidadeCep cidade;

	public Cep() {
	}

	public Cep(Integer codigo, String sigla, String nome, CidadeCep cidade) {
		super();
		this.codigo = codigo;
		this.sigla = sigla;
		this.nome = nome;
		this.cidade = cidade;
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

	public CidadeCep getCidade() {
		return cidade;
	}

	public void setCidade(CidadeCep cidade) {
		this.cidade = cidade;
	}

}
