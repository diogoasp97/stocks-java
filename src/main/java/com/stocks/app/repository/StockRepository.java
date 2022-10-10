package com.stocks.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stocks.app.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

	Stock getByName(String name);

}
