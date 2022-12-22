package com.example.demo.controller;

//import java.util.Date;
import java.lang.String;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;



//import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dao.ICompanyService;
import com.example.demo.Model.Company;
//import com.example.demo.Dao.IUserService;
//import com.example.demo.Model.User;

import io.jsonwebtoken.Jwts;

//import com.example.demo.Dao.UserService;



@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1.0/market/company")
//@Configuration
public class CompanyController {
	
	@Autowired
	private ICompanyService companyService; 
	
	@GetMapping("/test")
	public String testing() {
		return "test pass";
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> addCompany(@RequestBody Company company){
		if(companyService.registerCompany(company) !=null) {
			return new ResponseEntity<Company>(company, HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Could not register comapany", HttpStatus.CONFLICT);
	}
	
	@GetMapping("/getall")
	public List<Company> getAllCompanyDetails(){
		if(companyService.getAllCompanyDetails() !=null) {
			return companyService.getAllCompanyDetails();
		}
		return companyService.getAllCompanyDetails();
	}
	
	@GetMapping("/info/{id}")
	public ResponseEntity<?> getCompanyByCode(@PathVariable int id){
		if(companyService.getCompanyByCode(id) !=null) {
			return new ResponseEntity<Company>(companyService.getCompanyByCode(id), HttpStatus.OK);
		}
		return new ResponseEntity<String>("Could not register comapany", HttpStatus.CONFLICT);
	}
	
	@PutMapping("/put/{id}")
	public ResponseEntity<?> updateCompany(@RequestBody Company company, @PathVariable int id) {
		if(companyService.updateCompany(company,id) != null) {
			return new ResponseEntity<Company>(companyService.updateCompany(company,id), HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Could not updated", HttpStatus.CONFLICT);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCompany(@PathVariable int id) {
		if(companyService.deleteCompany(id) != null) {
			return new ResponseEntity<String>("Successfully Deleted", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Company not available with this id:"+id, HttpStatus.CONFLICT);
	}
	
	
	
	



}



