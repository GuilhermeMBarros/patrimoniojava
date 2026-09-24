package br.com.patrimonio.pojo;

import java.sql.Date;

public class Cursos {

	private Integer id;
	private String nome;
	private String sigla;
	private Integer criado_por;
	private Date criado_em;
	
	
	
	public Cursos() {
	}
	
	
	
	public Cursos(Integer id, String nome, String sigla, Integer criado_por, Date criado_em) {
		super();
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
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
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
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
