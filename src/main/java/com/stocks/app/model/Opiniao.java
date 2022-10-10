package com.stocks.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "opiniao")
public class Opiniao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private long opiniaoId;
	private String textoOpiniao;
	
	public Opiniao() {
	}
	
	public Opiniao(String textoOpiniao) {
		this.textoOpiniao = textoOpiniao;
	}

	public String getTextoOpiniao() {
		return textoOpiniao;
	}

	public void setTextoOpiniao(String textoOpiniao) {
		this.textoOpiniao = textoOpiniao;
	}

	@Override
	public String toString() {
		return "Opiniao [opiniaoId=" + opiniaoId + ", textoOpiniao=" + textoOpiniao + "]";
	}
}
