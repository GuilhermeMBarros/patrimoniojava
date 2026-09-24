package br.com.patrimonio.pojo;

import java.sql.Date;

public class Baixas_Patrimonios {

	public Integer Usuario;
	public Integer Selecione_Patrimonio;
	public Integer Tipo_Movimentacao;
	public Integer Responsavel_Destino;
	public Date Data_Prevista_Retorno;
	public Date Data_Eletiva_Retorno;
	public Integer Observacoes;
	
	public Baixas_Patrimonios(Integer usuario, Integer selecione_Patrimonio, Integer tipo_Movimentacao,
			Integer responsavel_Destino, Date data_Prevista_Retorno, Date data_Eletiva_Retorno, Integer observacoes) {
		super();
		this.Usuario = usuario;
		this.Selecione_Patrimonio = selecione_Patrimonio;
		this.Tipo_Movimentacao = tipo_Movimentacao;
		this.Responsavel_Destino = responsavel_Destino;
		this.Data_Prevista_Retorno = data_Prevista_Retorno;
		this.Data_Eletiva_Retorno = data_Eletiva_Retorno;
		this.Observacoes = observacoes;
	}

	public Baixas_Patrimonios() {
		super();
	}
	
}
