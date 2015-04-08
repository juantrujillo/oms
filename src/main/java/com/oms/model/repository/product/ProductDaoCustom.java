package com.oms.model.repository.product;

import java.util.List;

import com.oms.model.entity.product.Productos;

/**
 * 
 * @author dianaduque
 * 
 */
public interface ProductDaoCustom {

	List<Productos> findProductsBy(Integer idProducto, String nombre,
			String descripcion);

}
