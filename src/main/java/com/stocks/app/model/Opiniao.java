package com.stocks.app.model;

import java.util.Date;

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
	private String date;
	
	public Opiniao() {
		
	}
	
	public Opiniao(String textoOpiniao, String date) {
		this.date = date;
		this.textoOpiniao = textoOpiniao;
	}
	
	public Opiniao(long opiniaoId, String textoOpiniao, String date) {
		this.opiniaoId = opiniaoId;
		this.date = date;
		this.textoOpiniao = textoOpiniao;
	}

	public String getTextoOpiniao() {
		return textoOpiniao;
	}

	public void setTextoOpiniao(String textoOpiniao) {
		this.textoOpiniao = textoOpiniao;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Opiniao [opiniaoId=" + opiniaoId + ", textoOpiniao=" + textoOpiniao + ", date=" + date + "]";
	}
}
