package com.oms.model.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.oms.config.DbOmsConfig;
import com.oms.config.DbProductConfig;
import com.oms.model.entity.oms.Categorias;
import com.oms.model.entity.product.Productos;
import com.oms.model.repository.oms.CategoriaDao;
import com.oms.model.service.product.ProductService;

/**
 * 
 * @author dianaduque
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {
		DbProductConfig.class, DbOmsConfig.class })
public class ProductServiceTest {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoriaDao categoriaDao;

	private Productos producto;

	@Test
	public void testCreateProduct() {
		short idCategoria = 1;
		producto = new Productos();
		producto.setNombre("Producto1");
		producto.setDescripcion("Desc Producto1");
		producto.setPrecioLista(new BigInteger("1"));
		producto.setImagen("ruta/ruta");
		producto.setIdCategoria(idCategoria);

		producto = productService.create(producto);
		assertNotNull(producto);

		producto.setNombre("ProductoModificado");

		producto = productService.create(producto);
		assertEquals(producto.getNombre(), "ProductoModificado");

		productService.delete(producto.getIdProducto());

	}

	@Test
	public void testGetCategoriaList() {
		List<Categorias> products = categoriaDao.getCategorysList();
		for (Categorias cat : products) {
			System.out.println(cat.getNombre());
		}
	}

	@Test
	public void testSpTraerProductos() {
		List<Productos> products = productService.findProductsBy(2, "a", "b");
		for (Productos prod : products) {
			System.out.println(prod.getNombre());
		}
	}

}
