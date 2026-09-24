package br.com.patrimonio.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.patrimonio.pojo.Movimentacoes;

public class DAOMovimentacoes extends Conexao implements CRUD<Movimentacoes>{

	@Override
	public String cadastrar(Movimentacoes obj) {
		String msg = "Cadastro realizado";
		try {
			if(abrir()) {
				String movimentacoesInsert = "INSERT INTO movimentacoes(usuario_registro_id, tipo_movimentacao, responsavel_destino, documento_responsavel, data_saida, data_prevista_retorno, data_retorno_efetivo, observacoes)VALUES(?,?,?,?,?,?,?,?,?,?)";
				pst = con.prepareStatement(movimentacoesInsert);
				pst.setInt(1, obj.getUsuario_registro_id());
				pst.setInt(2, obj.getTipo_movimentacao());
				pst.setInt(3, obj.getResponsavel_destino());
				pst.setInt(4, obj.getDocumento_responsavel());
				pst.setDate(5, obj.getData_saida());
				pst.setDate(6, obj.getData_prevista_retorno());
				pst.setDate(7, obj.getData_retorno_efetivo());
				pst.setString(8, obj.getObservacoes());
				int i = pst.executeUpdate();
				if(i<1) {
					msg = "Não foi possível cadastrar";
				}
			}
			else {
				msg = " Não foi possível abrir o banco";
			}
		}
		catch (SQLException se) {
			msg = "Erro ao tentar cadastrar o curso. Mensagem:"+se.getMessage();
		}
		catch (Exception e) {
			msg = "Erro inesperado. Mensagem:"+e.getMessage();
		}
		return msg;
	}

	@Override
	public Boolean atualizar(Movimentacoes obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movimentacoes> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movimentacoes listarID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
