package com.oms.config;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.oms.model.entity.oms.Categorias;
import com.oms.model.repository.oms.CategoriaDao;

/**
 * 
 * @author dianaduque
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = DbOmsConfig.class)
public class DbOmsConfigTest {
	@Autowired
	private CategoriaDao categoriaDao;

	@Test
	public void testGetCategoriaList() {
		List<Categorias> products = categoriaDao.getCategorysList();
		for (Categorias cat : products) {
			System.out.println(cat.getNombre());
		}
		assertEquals(products.size(), 3);
	}

}
