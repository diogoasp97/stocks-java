package com.stocks.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "stock")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private long stockId;
	
	private String name;
	private String ticker;
	private String marketCap;
	private String simMarketCap;
	private String website;
	private String logo;
	
	@OneToMany(targetEntity = Opiniao.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "opiniao_fk", referencedColumnName = "stockId")
	private List<Opiniao> opinioes;
	
	public Stock() {
		
	}

	public Stock(String name, String ticker, String marketCap, String simMarketCap, String website, String logo,
			List<Opiniao> opinioes) {
		this.name = name;
		this.ticker = ticker;
		this.marketCap = marketCap;
		this.simMarketCap = simMarketCap;
		this.website = website;
		this.logo = logo;
		this.opinioes = opinioes;
	}


	public long getStockId() {
		return stockId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(String marketCap) {
		this.marketCap = marketCap;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
	public String getSimMarketCap() {
		return simMarketCap;
	}

	public void setSimMarketCap(String simMarketCap) {
		this.simMarketCap = simMarketCap;
	}
	
	public List<Opiniao> getOpinioes() {
		return opinioes;
	}

	public void setOpinioes(List<Opiniao> opinioes) {
		this.opinioes = opinioes;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", name=" + name + ", ticker=" + ticker + ", marketCap=" + marketCap
				+ ", simMarketCap=" + simMarketCap + ", website=" + website + ", logo=" + logo + ", opinioes="
				+ opinioes + "]";
	}

}
