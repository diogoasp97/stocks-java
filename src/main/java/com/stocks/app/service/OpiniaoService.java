package com.stocks.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocks.app.model.Opiniao;
import com.stocks.app.repository.OpiniaoRepository;

@Service
public class OpiniaoService {
	
	@Autowired
	OpiniaoRepository opiniaoRepository;

	public List<Opiniao> all() {
		return opiniaoRepository.findAll();
	}

	public Opiniao addOpiniao(Opiniao opiniao) {
		return opiniaoRepository.save(opiniao);
	}
	
	public Long getLatestOpiniao() {
		return opiniaoRepository.max();
	}

}
