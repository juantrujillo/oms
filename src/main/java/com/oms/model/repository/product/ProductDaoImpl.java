package com.oms.model.repository.product;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import com.oms.model.entity.product.Productos;

/**
 * 
 * @author dianaduque
 * 
 */
public class ProductDaoImpl implements ProductDaoCustom {

	@PersistenceContext(unitName = "springappPU")
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Productos> findProductsBy(Integer idProducto, String nombre,
			String descripcion) {
		System.out.println("progando entre");
		StoredProcedureQuery spq = entityManager
				.createNamedStoredProcedureQuery("findProductsBy");
		spq.setParameter("Codigo", idProducto);
		spq.setParameter("Nombre", nombre);
		spq.setParameter("Descripcion", descripcion);
		spq.execute();

		return (List<Productos>) spq.getResultList();
	}

}
