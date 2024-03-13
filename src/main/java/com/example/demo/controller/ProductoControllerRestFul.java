package com.example.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IProductoService;
import com.example.demo.service.to.ProductoLightTO;
import com.example.demo.service.to.ProductoTO;


@RestController
@RequestMapping(path = "/productos")
@CrossOrigin
public class ProductoControllerRestFul {

	@Autowired
	private IProductoService iProductoService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody ProductoTO producto) {
		this.iProductoService.insertar(producto);
	}

	@GetMapping(path = "/{codigoBarras}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductoTO> buscar(@PathVariable() String codigoBarras) {

		return ResponseEntity.status(HttpStatus.OK).body(this.iProductoService.buscarPorCodigoBarras(codigoBarras));
	}



	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductoLightTO>> buscarTodos() {
		List<ProductoLightTO> list = this.iProductoService.buscarTodos();
		for (ProductoLightTO pro : list) {
			Link link = linkTo(methodOn(ProductoControllerRestFul.class).buscar(pro.getCodigoBarras())).withSelfRel();
			pro.add(link);
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	@DeleteMapping(path = "/{codigoBarras}")
	public void eliminar(@PathVariable String codigoBarras) {
		this.iProductoService.eliminarPorCodigoBarras(codigoBarras);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@RequestBody ProductoTO producto) {
		this.iProductoService.actualizar(producto);
	}
}
