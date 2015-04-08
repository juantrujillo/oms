package com.oms.model.service.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oms.model.entity.product.Productos;
import com.oms.model.repository.product.ProductDao;

/**
 * 
 * @author dianaduque
 * 
 */
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Transactional(value = "transationManagerFactoryDbProduct")
	public Productos create(Productos producto) {
		return productDao.save(producto);
	}

	@Transactional(value = "transationManagerFactoryDbProduct")
	public void update(Productos producto) {
		productDao.save(producto);

	}

	@Transactional(value = "transationManagerFactoryDbProduct")
	public void delete(Integer id) {
		productDao.delete(id);
	}

	@Transactional(value = "transationManagerFactoryDbProduct")
	public List<Productos> findAll() {
		return (List<Productos>) productDao.findAll();
	}
	
	@Transactional(value = "transationManagerFactoryDbProduct")
	public List<Productos> findProductsBy(Integer idProducto, String nombre,
			String descripcion) {
		
		return (List<Productos>) productDao.findProductsBy(1,nombre,descripcion);
	}

}
