package com.stocks.app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocks.app.model.Opiniao;
import com.stocks.app.model.Stock;
import com.stocks.app.service.OpiniaoService;
import com.stocks.app.service.StockService;

@RestController
@RequestMapping("/stock/")
public class StocksController {
	
	@Autowired
	StockService stockService;
	
	@Autowired
	OpiniaoService opiniaoService;
	
	@GetMapping("all")
	public  ResponseEntity<List<Stock>> all(){
		List<Stock> stockList = stockService.all();
		return new ResponseEntity<List<Stock>>(stockList, HttpStatus.OK);
	}
	
	@GetMapping("getById/{id}")
	public ResponseEntity<Stock> getById(@PathVariable("id") long id) {
		Stock stock = stockService.getById(id);
		return new ResponseEntity<Stock>(stock, HttpStatus.OK);
	}
	
	@GetMapping("getByName/{name}")
	public ResponseEntity<Stock> getByName(@PathVariable("name") String name) {
		Stock stock = stockService.getByName(name);
		return new ResponseEntity<Stock>(stock, HttpStatus.OK);
	}
	
	@PostMapping("add")
	public ResponseEntity<Stock> addStock(@RequestBody Stock stock) {
		Stock stockAdded = stockService.addStock(stock);
		return new ResponseEntity<Stock>(stockAdded, HttpStatus.CREATED);
	}
	
	@PutMapping("update")
	public ResponseEntity<Stock> updateStock(@RequestBody Stock stock) {
		Stock stockUpdated = stockService.updateStock(stock);
		return new ResponseEntity<>(stockUpdated, HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") long id) {
		stockService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("insertOpiniao/{id}/{comment}/{date}")
	public ResponseEntity<Stock> insertOpiniao(@PathVariable("id") long id, @PathVariable("comment") String comment, @PathVariable("date") String date){
		Stock stockToInsertComment = stockService.getById(id);
		List<Opiniao> lista = stockToInsertComment.getOpinioes();
		Opiniao opiniao;
		if(opiniaoService.getLatestOpiniao()==null)
			opiniao = new Opiniao(1,comment, date);
		else
			opiniao = new Opiniao(opiniaoService.getLatestOpiniao() + 1,comment, date);
		
		lista.add(opiniao);
		
		stockToInsertComment.setOpinioes(lista);
		stockService.updateStock(stockToInsertComment);
		
		
		return new ResponseEntity<Stock>(stockToInsertComment, HttpStatus.OK);
	}
}
