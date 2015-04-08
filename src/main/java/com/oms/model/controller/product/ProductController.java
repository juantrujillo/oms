package com.oms.model.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.oms.model.entity.product.Productos;
import com.oms.model.service.product.ProductService;

/**
 * 
 * @author dianaduque
 * 
 */
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ResponseBody
	Productos create(@ModelAttribute Productos producto) {
		return productService.create(producto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ResponseBody
	void update(@ModelAttribute Productos producto) {
		productService.update(producto);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody
	void delete(Integer idProduct) {
		productService.delete(idProduct);
	}

	@RequestMapping(value = "/allProducts", method = RequestMethod.GET)
	public @ResponseBody
	List<Productos> findAll() {
		return productService.findAll();
	}

	@RequestMapping(value = "/findProductsBy", method = RequestMethod.GET)
	public @ResponseBody
	List<Productos> findProductsBy(Integer idProducto, String nombre,
			String descripcion) {
		return productService.findProductsBy(idProducto, nombre, descripcion);
	}

}
