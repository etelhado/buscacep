package com.etelhado.cep.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.etelhado.cep.models.Cep;
import com.etelhado.cep.models.CidadeCep;
import com.etelhado.cep.models.Logradouro;

@Repository
public class CepRepository {
	private final NamedParameterJdbcTemplate template;

	public CepRepository(NamedParameterJdbcTemplate template) {
		super();
		this.template = template;
	}
	
	
	public Cep buscarCep(String cep) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT e.codigo as codigo_estado, e.nome as nome_estado, e.sigla as sigla_estado,");
		buffer.append("c.codigo as codigo_cidade, c.nome as nome_cidade, c.ibge as ibge_cidade,");
		buffer.append("l.codigo as codigo_endereco, l.bairro as bairro_endereco, l.complemento as complemento_endereco, ");
		buffer.append("l.endereco as endereco_endereco, l.numero as numero_endereco, l.cep as cep_endereco ");
		buffer.append("FROM estados e join cidade c on c.codigo_estado = e.codigo join logradouro l on l.codigo_cidade = c.codigo WHERE l.cep = :cep");
		return template.query(buffer.toString(), new HashMap<String,String>(){
			private static final long serialVersionUID = 1L;

		{
			put("cep",cep);
		}}, rs-> {
			List<Cep> ceps = new ArrayList<>();
			while(rs.next()) {
				Cep cepObj = new Cep();
				CidadeCep cidade = new CidadeCep();
				Logradouro logradouro = new Logradouro();
				
				cepObj.setCodigo(rs.getInt("codigo_estado"));
				cepObj.setSigla(rs.getString("sigla_estado"));
				cepObj.setNome(rs.getString("nome_estado"));
				
				cidade.setCodigo(rs.getInt("codigo_cidade"));
				cidade.setIbge(rs.getString("ibge_cidade"));
				cidade.setNome(rs.getString("nome_cidade"));
				
				logradouro.setCodigo(rs.getInt("codigo_endereco"));
				logradouro.setBairro(rs.getString("bairro_endereco"));
				logradouro.setCodigoCidade(rs.getInt("codigo_cidade"));
				logradouro.setComplemento(rs.getString("complemento_endereco"));
				logradouro.setEndereco(rs.getString("endereco_endereco"));
				logradouro.setNumero(rs.getString("numero_endereco"));
				logradouro.setCep(rs.getString("cep_endereco"));
				
				cidade.setLogradouro(logradouro);
				cepObj.setCidade(cidade);
				
				ceps.add(cepObj);
				
			}
			return ceps.stream().findFirst().orElse(null);
		} );
		
		
		


		
	}
}
