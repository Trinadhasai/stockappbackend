package com.example.demo.Model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyCode;
	@Column(name = "company_name", length = 30)
	private String companyName;
	@Column(name = "company_ceo", length = 30)
	private String companyCeo;
	@Column(name="company_turnover")
	private double companyTurnover;
	@Column(name="company_website", length = 40)
	private String companyWebsite;
	@Column(name = "stock_exchange")
	private String stockExchange;
	
	
	
	private Double stockPrice;
	
	public Double getStockPrice() {
		return stockPrice;
	}

	@OneToMany(mappedBy = "company", cascade=CascadeType.ALL)
	@JsonIgnore
	@JsonManagedReference
	private Set<StockPrice> stockPriceHistory;
	
	//public Company() {}
	


	public void setStockPriceHistory(Set<StockPrice> stockPriceHistory) {
		this.stockPriceHistory = stockPriceHistory;
	}



	
	public String getCompanyCeo() {
		return companyCeo;
	}
	public void setCompanyCeo(String companyCeo) {
		this.companyCeo = companyCeo;
	}
	public double getCompanyTurnover() {
		return companyTurnover;
	}
	public void setCompanyTurnover(double companyTurnover) {
		this.companyTurnover = companyTurnover;
	}
	public String getCompanyWebsite() {
		return companyWebsite;
	}
	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}
	public int getCompanyCode() {
		return companyCode;
	}




	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}




	public String getCompanyName() {
		return companyName;
	}




	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}




	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public void setStockPrice(Double stockPrice) {
		this.stockPrice = stockPrice;
	}
	
	public Set<StockPrice> getStockPriceHistory() {
		return stockPriceHistory;
	}

	
	
//	@Override
//	public String toString() {
//		return "company_code : "+companyCode+",company_name : "+companyName+",ceo_name : "+ceoName+",website : "+website+",stock_price : "+stockPrice+",exchange : "+exchange;
//	}
}
