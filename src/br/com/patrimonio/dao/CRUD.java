package br.com.patrimonio.dao;

import java.util.List;

public interface CRUD<T> {
	String cadastrar(T obj);
	Boolean atualizar(T obj);
	String deletar(Integer id);
	List<T> listar();
	T listarID(Integer id);
	
}
