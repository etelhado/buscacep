package com.etelhado.cep.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.etelhado.cep.models.Cidade;

@Repository
public class CidadeRepository {

	private final NamedParameterJdbcTemplate template;

	public CidadeRepository(NamedParameterJdbcTemplate template) {
		super();
		this.template = template;
	}

	public List<Cidade> listar() {
		return template.query("SELECT * FROM cidade", rs -> {
			List<Cidade> cidades = new ArrayList<>();
			while (rs.next()) {
				Cidade cidade = new Cidade();
				cidade.setCodigo(rs.getInt("codigo"));
				cidade.setIbge(rs.getString("ibge"));
				cidade.setNome(rs.getString("nome"));
				cidade.setCodigoEstado(rs.getInt("codigo_estado"));
				cidades.add(cidade);
			}
			return cidades;
		});
	}

	public Cidade buscarPorId(Integer codigo) {
		return template.query("SELECT * FROM cidade WHERE codigo = :codigo", new HashMap<String, Object>() {
			private static final long serialVersionUID = 1L;

			{
				put("codigo", codigo);
			}
		}, rs -> {
			List<Cidade> cidades = new ArrayList<>();
			while (rs.next()) {
				Cidade cidade = new Cidade();
				cidade.setCodigo(rs.getInt("codigo"));
				cidade.setIbge(rs.getString("ibge"));
				cidade.setNome(rs.getString("nome"));
				cidade.setCodigoEstado(rs.getInt("codigo_estado"));
				cidades.add(cidade);
			}
			return cidades.stream().findFirst().orElse(null);
		});
	}

	public void cadastrar(Cidade cidade) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO cidade (nome, ibge, codigo_estado )");
		buffer.append(" VALUES ( :nome, :ibge, :codigo_estado)");
		template.update(buffer.toString(), new HashMap<String, Object>() {
			private static final long serialVersionUID = 1L;

			{
				put("nome", cidade.getNome());
				put("ibge", cidade.getIbge());
				put("codigo_estado", cidade.getCodigoEstado());

			}

		});

	}

	public void atualizar(Cidade cidade) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UPDATE cidade SET nome = :nome, ibge = :ibge, codigo_estado = :codigo_estado");
		buffer.append("WHERE codigo = :codigo");
		template.update(buffer.toString(), new HashMap<String, Object>() {

			private static final long serialVersionUID = 1L;

			{
				put("nome", cidade.getNome());
				put("ibge", cidade.getIbge());
				put("codigo_estado", cidade.getCodigoEstado());
				put("codigo", cidade.getCodigo());
			}
		});
	}

}
