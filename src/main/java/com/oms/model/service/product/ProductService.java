package com.oms.model.service.product;

import java.util.List;

import com.oms.model.entity.product.Productos;

/**
 * 
 * @author dianaduque
 * 
 */
public interface ProductService {

	public Productos create(Productos producto);

	public void update(Productos producto);

	public void delete(Integer id);

	public List<Productos> findAll();

	public List<Productos> findProductsBy(Integer idProducto, String nombre,
			String descripcion);

}
