package com.example.demo.Dao;

import java.util.List;

import com.example.demo.Model.StockPrice;

public interface IStockPriceService {
	public StockPrice updateStockPrice(StockPrice stockPrice, int id);
	public List<StockPrice> getAllStocks(int id);
	//public List<StockPrice> getAllStockDetails();
	public List<StockPrice> getStocksByCompanyCode(double cc);


}
