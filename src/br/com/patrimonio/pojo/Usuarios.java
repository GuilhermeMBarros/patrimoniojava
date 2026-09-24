package br.com.patrimonio.pojo;
 
/**
* Classe usuarios que representa a tabela na camada de aplicação.
* esta classe irá nos ajudar na metodologia  SOLID. Neste caso
* no S  do solid, que é o preincipio da responsabilidade única.
*/
 
import java.sql.Date;

public class Usuarios  {
	private Integer id;
	private String nome;
	private String email;
	private String senha_hash;
	private Perfil perfil;
	private Boolean ativo;
	private Date criado_em;
	private Date atualizado_em;
	
	public Usuarios() {
	}
	
	public Usuarios(Integer id, String nome, String email, String senha_hash, Perfil perfil, Boolean ativo,
			Date criado_em, Date atualizado_em) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha_hash = senha_hash;
		this.perfil = perfil;
		this.ativo = ativo;
		this.criado_em = criado_em;
		this.atualizado_em = atualizado_em;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha_hash() {
		return senha_hash;
	}
	public void setSenha_hash(String senha_hash) {
		this.senha_hash = senha_hash;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public Date getCriado_em() {
		return criado_em;
	}
	public void setCriado_em(Date criado_em) {
		this.criado_em = criado_em;
	}
	public Date getAtualizado_em() {
		return atualizado_em;
	}
	public void setAtualizado_em(Date atualizado_em) {
		this.atualizado_em = atualizado_em;
	}

	//O método toString foi criado para retornar o nome 
	//do usuário todas as vezes que o objeto usuário
	//for chamado. Não será carregado apenas o nome. 
	//Na verdade o objeto ususário inteiro será carregado,
	//sendo este usuário representado pelo nome.
	@Override
	public String toString() {
		return this.nome;
	}
}
 