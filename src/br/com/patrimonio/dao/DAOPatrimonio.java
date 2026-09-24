package br.com.patrimonio.dao;
 
import java.sql.SQLException;
import java.util.List;
import br.com.patrimonio.pojo.Patrimonio;

 
public class DAOPatrimonio extends Conexao implements CRUD<Patrimonio>{
 
	@Override
	public String cadastrar(Patrimonio obj) {
		String msg = "Cadastro realizado";
		try {
			if(abrir()) {
				String patrimonioInsert = "INSERT INTO patrimonios(numero_tombamento,nome,descricao,curso_id,local_id,categoria_id,criado_por,atualizado_por,status,valor_aquisicao)VALUES(?,?,?,?,?,?,?,?,?,?)";
				pst = con.prepareStatement(patrimonioInsert);
				pst.setString(1, obj.getNumero_tombamento());
				pst.setString(2, obj.getNome());
				pst.setString(3, obj.getDescricao());
				pst.setInt(4, obj.getCurso_id());
				pst.setInt(5, obj.getLocal_id());
				pst.setInt(6, obj.getCategoria_id());
				pst.setInt(7, obj.getCriado_por());
				pst.setInt(9, obj.getAtualizado_por());
				pst.setDouble(10, obj.getValor_aquisicao());
				int i = pst.executeUpdate();
				if(i<1) {
					msg = "Não foi possível cadastrar o curso";
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
	public Boolean atualizar(Patrimonio obj) {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public String deletar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public List<Patrimonio> listar() {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public Patrimonio listarID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
 
}