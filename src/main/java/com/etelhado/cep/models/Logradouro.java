package com.etelhado.cep.models;

public class Logradouro {

	private Integer codigo;
	private String endereco;
	private String bairro;
	private String complemento;
	private String numero;
	private String cep;
	private Integer codigoCidade;

	public Logradouro() {
		super();

	}

	public Logradouro(Integer codigo, String endereco, String bairro, String complemento, String numero, String cep,
			Integer codigoCidade) {
		super();
		this.codigo = codigo;
		this.endereco = endereco;
		this.bairro = bairro;
		this.complemento = complemento;
		this.numero = numero;
		this.cep = cep;
		this.codigoCidade = codigoCidade;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getCodigoCidade() {
		return codigoCidade;
	}

	public void setCodigoCidade(Integer codigoCidade) {
		this.codigoCidade = codigoCidade;
	}

}
