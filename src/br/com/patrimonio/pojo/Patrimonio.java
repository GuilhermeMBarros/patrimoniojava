package br.com.patrimonio.pojo;
 
import java.sql.Date;
 
public class Patrimonio {
	
	private Integer id;
	private String numero_tombamento;
	private String nome;
	private String descricao;
	private Integer curso_id;
	private Integer local_id;
	private Integer categoria_id;
	private Integer criado_por;
	private Integer atualizado_por;
	private Status status;
	private Double valor_aquisicao;
	private Date data_aquisicao;
	private Date criado_em;
	private Date atualizado_em;
	
	public Patrimonio() {
	}
	
	public Patrimonio(Integer id, String numero_tombamento, String nome, String descricao, Integer curso_id, Integer local_id, Integer categoria_id,
			Integer criado_por, Integer atualizado_por, Status status, Double valor_aquisicao, Date data_aquisicao, Date criado_em, Date atualizado_em) {
		this.id = id;
		this.numero_tombamento = numero_tombamento;
		this.nome = nome;
		this.descricao = descricao;
		this.curso_id = curso_id;
		this.local_id = local_id;
		this.categoria_id = categoria_id;
		this.criado_por = criado_por;
		this.atualizado_por = atualizado_por;
		this.status = status;
		this.valor_aquisicao = valor_aquisicao;
		this.data_aquisicao = data_aquisicao;
		this.criado_em = criado_em;
		this.atualizado_em = atualizado_em;
	}
 
	public Integer getId() {
		return id;
	}
 
	public void setId(Integer id) {
		this.id = id;
	}
 
	public String getNumero_tombamento() {
		return numero_tombamento;
	}
 
	public void setNumero_tombamento(String numero_tombamento) {
		this.numero_tombamento = numero_tombamento;
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
 
	public Integer getCurso_id() {
		return curso_id;
	}
 
	public void setCurso_id(Integer curso_id) {
		this.curso_id = curso_id;
	}
 
	public Integer getLocal_id() {
		return local_id;
	}
 
	public void setLocal_id(Integer local_id) {
		this.local_id = local_id;
	}
 
	public Integer getCategoria_id() {
		return categoria_id;
	}
 
	public void setCategoria_id(Integer categoria_id) {
		this.categoria_id = categoria_id;
	}
 
	public Integer getCriado_por() {
		return criado_por;
	}
 
	public void setCriado_por(Integer criado_por) {
		this.criado_por = criado_por;
	}
 
	public Integer getAtualizado_por() {
		return atualizado_por;
	}
 
	public void setAtualizado_por(Integer atualizado_por) {
		this.atualizado_por = atualizado_por;
	}
 
	public Status getStatus() {
		return status;
	}
 
	public void setStatus(Status status) {
		this.status = status;
	}
 
	public Double getValor_aquisicao() {
		return valor_aquisicao;
	}
 
	public void setValor_aquisicao(Double valor_aquisicao) {
		this.valor_aquisicao = valor_aquisicao;
	}
 
	public Date getData_aquisicao() {
		return data_aquisicao;
	}
 
	public void setData_aquisicao(Date data_aquisicao) {
		this.data_aquisicao = data_aquisicao;
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
	
	@Override
	public String toString() {
	    return nome;
	}
}
 
 