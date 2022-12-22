package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dao.IStockPriceService;
import com.example.demo.Model.Company;
import com.example.demo.Model.StockPrice;



@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1.0/market/stock")
public class StockPriceController {
	
	@Autowired
	private IStockPriceService stockService;
	
	@PostMapping("/add/{id}")
	private ResponseEntity<?> updateStockPrice(@RequestBody StockPrice SP, @PathVariable int id) {
		if (stockService.updateStockPrice(SP, id) != null) {
			return new ResponseEntity<StockPrice>(SP, HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Company not registered", HttpStatus.CONFLICT);
	}
	@GetMapping("/getallstocks/{id}")
	public ResponseEntity<?> getAllStocks(@PathVariable int id){
	System.out.println("kishor : "+id +"- 1");
	List<StockPrice> stockList = stockService.getAllStocks(id);
	if (stockList != null) {
		System.out.println("4");
	return new ResponseEntity<List<StockPrice>>(stockList, HttpStatus.OK);
	}
	return new ResponseEntity<String>("The Stock List Is Empty", HttpStatus.CONFLICT);
	}
	
	@GetMapping("/getstocksbycompanycode/{cc}")
	public List<StockPrice> getStocksByCompanyCode(@PathVariable double cc) {
		return stockService.getStocksByCompanyCode(cc);
	}
	
	
//	@GetMapping("/getall")
//	public List<StockPrice> getAllStockDetails(){
//		
//		if(stockService.getAllStockDetails() !=null) {
//			return stockService.getAllStockDetails();
//	}
//	return null;
//	}
	
}
