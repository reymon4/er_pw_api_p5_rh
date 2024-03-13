package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Producto;

public interface IProductoRepository {
	
	public void insertar(Producto producto);
	public Producto seleccionarPorCodigoBarras(String codigoBarras);
	public void eliminarPorCodigoBarras(String codigoBarras);
	public void actualizar(Producto producto);
	public List<Producto> seleccionarTodos();
	
	

}
