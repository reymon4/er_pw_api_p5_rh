package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Override
	public Producto seleccionarPorCodigoBarras(String codigoBarras) {
		// TODO Auto-generated method stub

		TypedQuery<Producto> query = this.entityManager
				.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras = :codigoBarras ", Producto.class)
				.setParameter("codigoBarras", codigoBarras);

		return query.getSingleResult();
	}

	@Override
	public void eliminarPorCodigoBarras(String codigoBarras) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.seleccionarPorCodigoBarras(codigoBarras));
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(this.seleccionarPorCodigoBarras(producto.getCodigoBarras()));
	}

	@Override
	public List<Producto> seleccionarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Producto> query = this.entityManager.createQuery("SELECT p FROM Producto p", Producto.class);

		return query.getResultList();
	}

}
