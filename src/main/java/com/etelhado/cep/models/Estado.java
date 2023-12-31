package com.etelhado.cep.models;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

public class Estado {

	private Integer codigo;
	@NotBlank(message = "Informe uma Sigla")
	@Length(min = 2, max = 2, message = "A sigla deve conter 2 caracteres")
	private String sigla;
	@NotBlank(message = "Informe o nome do estado")
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
