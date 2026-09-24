package br.com.patrimonio.dao;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import br.com.patrimonio.pojo.Perfil;
import br.com.patrimonio.pojo.Usuarios;
 
public class DAOUsuario extends Conexao implements IUsuario<Usuarios>{
 
	@Override
	public String cadastrar(Usuarios obj) {
		String msg = "Usuário Cadastrado!";
		// Tentar abrir a conexão com o banco de dados
		try {
			if(abrir()) {
				// O processo de cadastro é usar o comando 
				// INSERT do MySQL. Nós precisamos executar
				// um comando na camada de aplicação.
				// Este comando é o PreparedStatement.

				// O comando PreparedStatement irá executar o comando INSERT
				// ecadastrar os dados na tabela usuários. Os valores
				// foram passados por parâmetro usando pontos de interrogação,
				// para cada campo da tabela há um ponto de interrogação 
				// correspondente. Esta é uma consulta parametrizada. Uma
				// das formas de evitar a injeção de SQL(SQLInjection)
				pst = con.prepareStatement("INSERT INTO usuarios(nome,email,senha_hash,perfil,ativo)VALUES(?,?,?,?,?)");
				// Abaixo, os parametros passados para cada ponto de interrogação
				// com seus respectivos valores:
				pst.setString(1, obj.getNome());
				pst.setString(2, obj.getEmail());
				pst.setString(3, obj.getSenha_hash());
				pst.setString(4, obj.getPerfil().toString());
				pst.setBoolean(5, obj.getAtivo());
				// Estamos executando a consulta e obteno o retorno dessa execução.
				// Se retornar 0 ( zero ), então não houve cadastro, caso contrário, cadastrou
				int i =pst.executeUpdate();
				if( i < 1 ) {
					msg = "Não foi possível cadastrar";
				}
			}
			else {
				msg ="Conexão Fechada";
			}
		}

		catch(SQLException se) {
			msg = "Erro ao tentar cadastrar o usuário. Mensagem: "+se.getMessage();
		}
		catch(Exception ex) {
			msg = "Erro inesperado. Mensagem: " +ex.getMessage();
		}
		finally {
			fechar();
		}

		return msg;
	}
 
	@Override
	public Boolean atualizar(Usuarios obj) {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public String deletar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public List<Usuarios> listar() {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public Usuarios listarID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public String alterarSenha(String usuario, String nova_senha) {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public Usuarios logar(String usario, String senha) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Usuarios> listaAtivos() {
		List<Usuarios> lista = new ArrayList<Usuarios>();
		try {
			//Abrir o banco de dados
			if( abrir()) {
				String sql = "SELECT * FROM usuarios WHERE ativo=1";
				// prepara a consulta para ser executada
				pst = con.prepareStatement(sql);
				// Executar a consulta com o comando executeQuery, assim teremos
				// o comando Select sendo executado. O resultado da consulta é 
				// guardado em uma vriável do tipo ResultSet(rs). Sempre que você
				// tiver uma consulta SELECT o retorno desta consulta deve ficar
				// em um ResultSet
				rs = pst.executeQuery();
				// o comando next faz o cursor se movimentar para adiante
				// dentro da tabela quando há dados. Se não houver dados
				// o cursor não se movimenta e retorna falso, indicando 
				// que os dados da tabela acabaram
				while(rs.next()) {
					// Todas as vezes que o laço while "roda", significa que 
					// o comando next() executou e assim foi para a próxima 
					// linha, trazendo os dados desta linha.
					// Para organizar e guardar os dados dos usuários, criamos 
					// um novo usuário da camada POJO e, passamos todos os 
					// dados retornados do rs para cada campo do usuário.
					// Depois adicionamos este usuário a lista de usuários
					// selecionados.
					Usuarios us = new Usuarios();
					us.setId(rs.getInt(1));
					us.setNome(rs.getString(2));
					us.setEmail(rs.getString(3));
					us.setPerfil((Perfil)rs.getObject(5));
					us.setAtivo(rs.getBoolean(6));
					us.setCriado_em(rs.getDate(7));
					us.setAtualizado_em(rs.getDate(8));
					lista.add(us);
				}
			}
			else {
				System.out.println("Erro ao tentar abrir a conexão");
			}
		}
		catch(SQLException se) {
			System.out.print("Erro ao tentar executar a consulta. Mensagem:"+se.getMessage());
		}
		catch(Exception e) {
			System.out.println("Erro inesperado. Mensagem:"+e.getMessage());
		}
		finally {
			fechar();
		}
		return lista;
	}

 
}