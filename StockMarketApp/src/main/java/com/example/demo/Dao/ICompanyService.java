package com.example.demo.Dao;

import java.util.List;

import com.example.demo.Model.Company;


public interface ICompanyService {
	
	 public Company registerCompany(Company company);
	 
	 public Company getCompanyByCode(int companyId);
	 
	 public List<Company> getAllCompanyDetails();
	 
	 public String deleteCompany(int companyId);
	 
	 public String updateStockPrice(Company company);
	 
	 public Company updateCompany(Company company, int id);
}
