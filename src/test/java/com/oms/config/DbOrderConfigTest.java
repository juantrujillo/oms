package com.oms.config;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.oms.model.entity.order.Clientes;
import com.oms.model.repository.order.ClientDao;

/**
 * 
 * @author dianaduque
 * 
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = DbOrderConfig.class)*/
public class DbOrderConfigTest {

	/*@Autowired
	private ClientDao clientDao;

	@Test
	public void testGetClientList() {
		List<Clientes> clientList = clientDao.getClientsList();
		for (Clientes cliente : clientList) {
			System.out.println(cliente.getNombre());
		}
	}
	
	@Test
	public void testCreateClient(){
		Clientes cliente = new Clientes();
		cliente.setNombre("Jesus");
		cliente.setApellido("apellido");
		cliente.setTelefono("123456");
		cliente.setEmail("jesus@gmail");
		cliente.setPassword("1234567");
		cliente.setTipotarjetacredito("1");
		cliente.setNumerotarjeta("563241");
		clientDao.save(cliente);
	}*/

}
