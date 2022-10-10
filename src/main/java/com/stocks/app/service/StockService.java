package com.stocks.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocks.app.model.Stock;
import com.stocks.app.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	StockRepository stockRepository;
	
	public List<Stock> all() {
		return stockRepository.findAll();
	}

	public Stock getById(long id) {
		return stockRepository.findById(id).get();
	}

	public Stock addStock(Stock stock) {
		return stockRepository.save(stock);
	}

	public Stock updateStock(Stock stock) {
		if(stockRepository.findById(stock.getStockId()).get() != null)
			return stockRepository.save(stock);
		else 
			return null;
	}

	public void deleteById(long id) {
		stockRepository.deleteById(id);
	}

	public Stock getByName(String name) {
		return stockRepository.getByName(name);
	}
	
}
