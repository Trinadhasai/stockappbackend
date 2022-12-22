package com.example.demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Company;
import com.example.demo.Model.StockPrice;
import com.example.demo.Repository.CompanyRepository;
import com.example.demo.Repository.StockRepository;

import ch.qos.logback.classic.Logger;


@Service
public class StockPriceImpl implements IStockPriceService {
	@Autowired
	public StockRepository stockRepo;
	@Autowired
	public CompanyRepository companyRepo;

	@Override
	public StockPrice updateStockPrice(StockPrice stockPrice, int id) {
		try {
		Company c = companyRepo.findById(id).get();
		System.out.println(c);
		if (c !=null) {
			stockPrice.setCompany(c);
			stockRepo.save(stockPrice);
			c.setStockPrice(stockPrice.getStockPrice());
			companyRepo.save(c);
			return stockPrice;
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//	public StockPrice updateStockPrice(StockPrice stockPrice, int id) {
//		try {
//			Company c = companyRepo.getById(id);
////			System.out.println(c);
//			if (c != null) {
////				System.out.println("1" + c);
//				stockRepo.save(stockPrice);
//				stockPrice.setCompany(c);
////				System.out.println(stockPrice);
//				return stockPrice;
//				}
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//			return null;
//	}
//	 @Query( "SELECT pg FROM Book bk join bk.pages pg WHERE bk.bookId = :bookId")
//	 List<Page> findPagesByBookId(@Param("bookId") String bookId);
	@Override
	@Query("SELECT * FROM company cm join cm.stock_price sp WHERE cm.company_code = id")
	
	public List<StockPrice> getAllStocks(int id) {
	List<StockPrice> st = stockRepo.findAll();
	if (st != null) {
		return st;
	}else {
		return null;
	}
	}
	@Override
	public List<StockPrice> getStocksByCompanyCode(double cc) {
		return stockRepo.findByStockPrice(cc);
	}

	
	
}


