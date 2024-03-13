package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Producto;
import com.example.demo.service.to.ProductoLightTO;
import com.example.demo.service.to.ProductoTO;

public interface IProductoService {
	
	public void insertar(ProductoTO producto);
	public ProductoTO buscarPorCodigoBarras(String codigoBarras);
	public void eliminarPorCodigoBarras(String codigoBarras);
	public void actualizar(ProductoTO producto);
	public List<ProductoLightTO> buscarTodos();
	
	public ProductoLightTO convertirALightTO(Producto productoTO);
	
	public ProductoTO convertirATO(Producto producto);
	
	public Producto convertir(ProductoTO producto);
	

}
