package com.etelhado.cep.models;

public class CidadeCep {
	private Integer codigo;
	private String nome;
	private String ibge;
	private Logradouro logradouro;
	
	
	
	public CidadeCep() {
		super();
	}
	public CidadeCep(Integer codigo, String nome, String ibge, Logradouro logradouro) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.ibge = ibge;
		this.logradouro = logradouro;
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
	public Logradouro getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}
	
	
}
