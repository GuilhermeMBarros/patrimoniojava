package br.com.patrimonio.dao;

import java.util.List;

public interface IListarTipo<T> extends CRUD<T> {
	List<T> listarPorTipo(String tipo);

}
