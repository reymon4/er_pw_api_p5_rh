package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IProductoRepository;
import com.example.demo.repository.modelo.Producto;
import com.example.demo.service.to.ProductoLightTO;
import com.example.demo.service.to.ProductoTO;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepository iProductoRepository;

	@Override
	public void insertar(ProductoTO producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.insertar(this.convertir(producto));
	}

	@Override
	public ProductoTO buscarPorCodigoBarras(String codigoBarras) {
		// TODO Auto-generated method stub
		return this.convertirATO(this.iProductoRepository.seleccionarPorCodigoBarras(codigoBarras));
	}

	@Override
	public void eliminarPorCodigoBarras(String codigoBarras) {
		// TODO Auto-generated method stub
		this.iProductoRepository.eliminarPorCodigoBarras(codigoBarras);
	}

	@Override
	public void actualizar(ProductoTO producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.actualizar(this.convertir(producto));
	}

	@Override
	public List<ProductoLightTO> buscarTodos() {
		// TODO Auto-generated method stub
		List<Producto> list = this.iProductoRepository.seleccionarTodos();
		List<ProductoLightTO> listTO = new ArrayList<>();
		for (Producto pro : list) {
			listTO.add(this.convertirALightTO(pro));
		}
		return listTO;

	}

	@Override
	public ProductoLightTO convertirALightTO(Producto productoTO) {
		// TODO Auto-generated method stub
		ProductoLightTO pro = new ProductoLightTO();
		pro.setCodigoBarras(productoTO.getCodigoBarras());
		pro.setNombre(productoTO.getNombre());
		return pro;
	}

	@Override
	public ProductoTO convertirATO(Producto producto) {
		// TODO Auto-generated method stub
		ProductoTO pro = new ProductoTO();
		pro.setCodigoBarras(producto.getCodigoBarras());
		pro.setNombre(producto.getNombre());
		pro.setStock(producto.getStock());
		pro.setFechaCaducidad(producto.getFechaCaducidad());

		return pro;
	}

	@Override
	public Producto convertir(ProductoTO producto) {
		// TODO Auto-generated method stub
		Producto pro = new Producto();
		pro.setCodigoBarras(producto.getCodigoBarras());
		pro.setNombre(producto.getNombre());
		pro.setStock(producto.getStock());
		pro.setFechaCaducidad(producto.getFechaCaducidad());
		return pro;
	}

}
