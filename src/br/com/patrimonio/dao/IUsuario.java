package br.com.patrimonio.dao;

import java.util.List;

public interface IUsuario<T> extends CRUD<T>{
	String alterarSenha(String usuario, String nova_senha);
	T logar(String usuario, String senha);
	List<T> listaAtivos();
}
