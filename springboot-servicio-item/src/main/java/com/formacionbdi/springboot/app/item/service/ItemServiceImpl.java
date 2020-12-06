package com.formacionbdi.springboot.app.item.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.models.Producto;

@Service
public class ItemServiceImpl implements IItemService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Item> findAll() {
		List<Producto> listaProductos = Arrays.asList(restTemplate.getForObject("http://localhost/listarProductos", Producto[].class));
		return listaProductos.stream().map(prod -> new Item(prod, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long idProducto, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("idProducto", idProducto.toString());
		Producto producto = restTemplate.getForObject("http://localhost/detalleProducto/{idProducto}", Producto.class, pathVariables);
		return new Item(producto, cantidad);
	}

}
