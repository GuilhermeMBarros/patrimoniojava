package br.com.patrimonio.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.patrimonio.pojo.Cursos;

public class DAOCursos extends Conexao implements CRUD<Cursos> {

	@Override
	public String cadastrar(Cursos obj) {
		String msg = "Cadastro realizado";
		try {
			if(abrir()) {
				String cursoInsert = "INSERT INTO cursos(nome,sigla,criado_por)VALUES(?,?,?)";
				pst = con.prepareStatement(cursoInsert);
				pst.setString(1, obj.getNome());
				pst.setString(2, obj.getSigla());
				pst.setInt(3, obj.getCriado_por());
				
				int i = pst.executeUpdate();
				if(i < 1) {
					msg = "Não foi possível cadastrar o curso";
				}
				
			}
			else {
				msg = "Não foi possível abrir o banco";
			}
		}
		catch(SQLException se) {
			msg = "Erro ao tentar cadastrar o curso. Mensagem:"+se.getMessage();
		}
		catch (Exception e) {
			msg = "Erro inesperado. Mensagem:"+e.getMessage();
		}
		return msg;
	}

	@Override
	public Boolean atualizar(Cursos obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cursos> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Cursos listarID(Integer ID) {
		Cursos lista = new Cursos();
		try {
			if (abrir()) {
				String sql = "SELECT * FROM cursos WHERE id = " + ID;
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();

				while(rs.next()) {
					Cursos cursos = new Cursos();
					cursos.setId(rs.getInt(1));
					cursos.setNome(rs.getString(2));
					cursos.setSigla(rs.getString(3));
					cursos.setCriado_por(rs.getInt(4));
					cursos.setCriado_em(rs.getDate(5));
					lista=cursos;
				}
			}
			else {
				System.out.println("Erro ao tentar abrir a conexão");
			}
		}
		catch(SQLException se) {
			System.out.print("Erro ao tentar executar a consulta. Mensagem:" + se.getMessage());
		}
		catch(Exception e) {
			System.out.println("Erro inesperado, Mensagem:" + e.getMessage());
		}
		finally {
			fechar();
		}
		return lista;
	}
	@Override
	public List<Cursos> listarAtivos() {
		List<Cursos> lista = new ArrayList<Cursos>();
		try {
			if (abrir()) {
				String sql = "SELECT * FROM cursos";
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();

				while(rs.next()) {
					Cursos cursos = new Cursos();
					cursos.setId(rs.getInt(1));
					cursos.setNome(rs.getString(2));
					cursos.setSigla(rs.getString(3));
					cursos.setCriado_por(rs.getInt(4));
					cursos.setCriado_em(rs.getDate(5));
					lista.add(cursos);
				}
			}
			else {
				System.out.println("Erro ao tentar abrir a conexão");
			}
		}
		catch(SQLException se) {
			System.out.print("Erro ao tentar executar a consulta. Mensagem:" + se.getMessage());
		}
		catch(Exception e) {
			System.out.println("Erro inesperado, Mensagem:" + e.getMessage());
		}
		finally {
			fechar();
		}
		return lista;
	}
 
}