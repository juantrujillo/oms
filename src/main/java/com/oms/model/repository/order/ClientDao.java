package com.oms.model.repository.order;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oms.model.entity.order.Clientes;

/**
 * 
 * @author dianaduque
 * 
 */
@Repository
public interface ClientDao extends CrudRepository<Clientes, String> {
	
	@Query("SELECT c FROM Clientes c")
	public List<Clientes> getClientsList();

}
