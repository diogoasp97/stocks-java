package com.stocks.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocks.app.model.Stock;
import com.stocks.app.service.StockService;

@RestController
@RequestMapping("/stock/")
public class StocksController {
	
	@Autowired
	StockService stockService;
	
	@GetMapping("all")
	public List<Stock> all(){
		return stockService.all();
	}
	
	@GetMapping("getById/{id}")
	public Stock getById(@PathVariable("id") long id) {
		return stockService.getById(id);
	}
	
	@GetMapping("getByName/{name}")
	public Stock getByName(@PathVariable("name") String name) {
		return stockService.getByName(name);
	}
	
	@PostMapping("add")
	public Stock addStock(@RequestBody Stock stock) {
		return stockService.addStock(stock);
	}
	
	@PatchMapping("update")
	public Stock updateStock(@RequestBody Stock stock) {
		return stockService.updateStock(stock);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteById(@PathVariable("id") long id) {
		stockService.deleteById(id);
	}
}
