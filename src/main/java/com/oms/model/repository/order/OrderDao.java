package com.oms.model.repository.order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.oms.model.entity.order.Pedidos;

@Repository
public interface OrderDao extends CrudRepository<Pedidos, Integer> {

}
