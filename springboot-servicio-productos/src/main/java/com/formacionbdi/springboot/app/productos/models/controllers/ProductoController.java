package com.formacionbdi.springboot.app.productos.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.IProductoService;

@RestController
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/listarProductos")
	public List<Producto> listAll(){
		return productoService.findAll();
	}
	
	@GetMapping("/detalleProducto/{idProducto}")
	public Producto detalleProducto(@PathVariable Long idProducto) {
		return productoService.findById(idProducto);
	}

}
