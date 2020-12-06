package com.formacionbdi.springboot.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.service.IItemService;

@RestController
public class ItemController {
	
	@Autowired
	private IItemService itemService;
	
	@GetMapping("/listarItems")
	public List<Item> listarItems(){
		return itemService.findAll();
	}
	
	@GetMapping("/detalleItem/{idProducto}/cantidad/{cantidad}")
	public Item detalleItem(@PathVariable Long idProducto, @PathVariable Integer cantidad) {
		return itemService.findById(idProducto, cantidad);
	}

}
