/*
* O pacote br.patrimonio.dao, armazena as classes, interfaces e enum relacionados
* a conexão com o banco de dados.
*/
 
package br.com.patrimonio.dao;
 
/*
* Importação das classes e interfaces que serão utilizadas para estabelecer a conexão
* com o banco de dados e executar os comandos de SQL.
* A interface 	Connection (Conexão) permite estabelecer a conexão com o banco de dados
* A interface DriverManager (Gerenciador de Drive) permite fazer a passagem dos dados de
* conexão, tais como: url do banco, usuário e senha, retorna a conexão estabelecida com o banco
* A classe SQLException(tratamento de erro) oermite capturar o erro gerado ao tentar
* executar um comando de SQL e exibir o erro na tela.
* A interface ResultSet(Resultado Encontrado) é usada para guardar os retornos das
* consultas SELECT.
* A interface PreparedStatement é utilizada para executar comandos de SQL que modificam
* a estrutura das tabelas, tais como: INSERT, UPDATE, DELETE.
*/
 
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
/**
* A classe Conexao é uma classe abstrata gerada para permitir a conexão com o banco de dados
* das classes que farão a seleção, inserção, atualização e deleção de dados no banco de dados.
* Nesta classes temos duas funções: abrir(), que abre a conexão com o banco de dados  e fechar()
* que fecha a conexão com o banco de dados.
*/
public abstract class Conexao {
	
	// O elemento con recebe uma conexao estabelecida com o banco de dados.
	// Portanto, ele deve ser do tipo Connection, assim estara preparado para
	// receber a conexao com o banco de dados. Iniciamos o objeto con como
	// null(nulo) para depois receber a conexão.
	public Connection con = null;
	public PreparedStatement pst = null;
	public ResultSet rs = null;		

	/*
	 * O método abrir é usado para estabelecer a conexão com o banco de dados.
	 * @return
	 * Retorna a conexão com o banco.
	 */
	public Boolean abrir() {
		Boolean abriu = true;
		
		try {
			//carregar o driver de comunicao com o banco de dados
			//mysql. Em tempo de execucão será feita uma instância
			//do Driver, que o torna um objeto
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:5030/laranchinha", "root", "123senac");
			
		}
		catch(SQLException se) {
			System.out.println("Erro ao tentar estabelecer a conexão com o banco de dados. Mensagem: "+se.getMessage());
			abriu = false;
		}
		catch(Exception ex) {
			System.out.println("Erro inesperado. Mensagem: "+ex.getMessage());
			abriu = false;
		}
		return abriu;
		
	}
	
	 /**
	 *O método fechar realiza o fechamento da conexão com o banco de dados.
	 *@return
	 *Retorna que o banco foi fechado. 
	 */
	public Boolean fechar() {
		Boolean fechou = true;
		try {
			con.close();
		}
		catch(SQLException se) {
			System.out.println("Erro ao tentar fechar o banco da dados. Mensagem: "+se.getMessage());
			fechou = false;
		}
		catch(Exception ex) {
			System.out.println("Erro inesperado. Mensagem: "+ex.getMessage());
			fechou = false;
		}
		return fechou;
	}
}
 
 