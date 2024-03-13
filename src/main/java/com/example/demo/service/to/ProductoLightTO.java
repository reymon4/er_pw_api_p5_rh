package com.example.demo.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class ProductoLightTO extends RepresentationModel<ProductoLightTO>implements Serializable {

	private static final long serialVersionUID = 2L;
	
	private String nombre;

	private String codigoBarras;
	
	//get & set

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
	
}