package com.stocks.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocks.app.model.Opiniao;
import com.stocks.app.service.OpiniaoService;

@RestController
@RequestMapping("/opiniao/")
public class OpiniaoController {

	@Autowired
	OpiniaoService opiniaoService;
	
	@GetMapping("all")
	public ResponseEntity<List<Opiniao>> all(){
		List<Opiniao> list = opiniaoService.all();
		return new ResponseEntity<List<Opiniao>>(list, HttpStatus.OK);
	}
	
}
