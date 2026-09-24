package br.com.patrimonio.pojo;

import java.sql.Date;

public class Locais {

	private Integer id;
	private String nome;
	private String descricao;
	private Integer criado_por;
	private Date criado_em;
	
	
	
	public Locais() {
	}
	
	
	
	public Locais(Integer id, String nome, String descricao, Integer criado_por, Date criado_em) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao= descricao;
		this.criado_por = criado_por;
		this.criado_em = criado_em;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getCriado_por() {
		return criado_por;
	}
	public void setCriado_por(Integer criado_por) {
		this.criado_por = criado_por;
	}
	public Date getCriado_em() {
		return criado_em;
	}
	public void setCriado_em(Date criado_em) {
		this.criado_em = criado_em;
	}
}
