package com.oms.model.repository.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oms.model.entity.product.Productos;

/**
 * 
 * @author dianaduque
 *         http://docs.spring.io/spring-data/jpa/docs/current/reference/html/
 */
@Repository
public interface ProductDao extends CrudRepository<Productos, Integer>,
		ProductDaoCustom {

}
