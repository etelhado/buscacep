package com.etelhado.cep.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.etelhado.cep.models.Estado;

@Repository
public class EstadoRepository {

	private final NamedParameterJdbcTemplate template;

	public EstadoRepository(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	public List<Estado> listar() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT * FROM estados");
		return template.query(buffer.toString(), (rs) -> {
			List<Estado> estados = new ArrayList<Estado>();
			while (rs.next()) {
				Estado estado = new Estado();
				estado.setCodigo(rs.getInt("codigo"));
				estado.setNome(rs.getString("nome"));
				estado.setSigla(rs.getString("sigla"));
				estados.add(estado);
			}
			return estados;
		});
	}

	public Estado buscarPorId(Integer codigo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT * FROM estados WHERE codigo = :codigo");
		return template.query(buffer.toString(), new HashMap<String, Object>() {

			private static final long serialVersionUID = 1L;

			{
				put("codigo", codigo);
			}
		}, (rs) -> {
			List<Estado> estados = new ArrayList<Estado>();
			while (rs.next()) {
				Estado estado = new Estado();
				estado.setCodigo(rs.getInt("codigo"));
				estado.setNome(rs.getString("nome"));
				estado.setSigla(rs.getString("sigla"));
				estados.add(estado);
			}
			return estados.stream().findFirst().orElse(null);
		});
	}

	public void atualizar(Estado estado) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UPDATE estados SET sigla = :sigla, nome = :nome WHERE codigo = :codigo");
		template.update(buffer.toString(), new HashMap<String, Object>() {
			private static final long serialVersionUID = 1L;

			{
				put("sigla", estado.getSigla());
				put("nome", estado.getNome());
				put("codigo", estado.getCodigo());
			}
		});

	}

	public void cadastrar(Estado estado) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("	INSERT INTO estados");
		buffer.append(" ( sigla,nome )");
		buffer.append(" VALUES (:sigla,:nome)");
		template.update(buffer.toString(), new HashMap<String, Object>() {
			private static final long serialVersionUID = 1L;

			{
				put("sigla", estado.getSigla());
				put("nome", estado.getNome());
			}
		});

	}
	
	 
	

}
