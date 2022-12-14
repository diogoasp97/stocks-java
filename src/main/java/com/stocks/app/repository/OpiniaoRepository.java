package com.stocks.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stocks.app.model.Opiniao;

@Repository
public interface OpiniaoRepository extends JpaRepository<Opiniao, Long>{
	
	@Query(value = "SELECT max(opiniaoId) FROM opiniao")
	public Long max();
	
}
