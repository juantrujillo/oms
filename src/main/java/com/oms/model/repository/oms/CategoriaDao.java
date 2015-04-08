package com.oms.model.repository.oms;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oms.model.entity.oms.Categorias;

/**
 * 
 * @author DianaD
 * 
 */
@Repository
public interface CategoriaDao extends CrudRepository<Categorias, Integer>{

	@Query("SELECT c FROM Categorias c")
	public List<Categorias> getCategorysList();

}
