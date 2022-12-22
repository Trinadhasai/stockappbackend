package com.example.demo.Dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Company;
import com.example.demo.Repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements ICompanyService {

	@Autowired
	private CompanyRepository companyRepo;
	
	@Override
	public Company registerCompany(Company company) {
		if(company != null && company.getCompanyTurnover() > 100000000) {
			return  companyRepo.save(company);
		}
	 return null;

	}

	@Override
	public Company getCompanyByCode(int code) {
		try {
			Optional<Company> company = companyRepo.findById(code);
			if(company != null) {
				return company.get();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Company> getAllCompanyDetails() {
		List<Company> companyList = companyRepo.findAll();
		if(companyList != null) {
			return companyList;
		}
		return null;
	}

	@Override
	public String deleteCompany(int id) {
		try {
			companyRepo.deleteById(id);
			return "Deleted";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Company updateCompany(Company company, int id) {
		try {
			Company oldCom;
			Optional<Company> c = companyRepo.findById(id);
			if (c != null) {
				oldCom = c.get();
				oldCom.setCompanyName(company.getCompanyName());
				oldCom.setCompanyCeo(company.getCompanyCeo());
				oldCom.setCompanyTurnover(company.getCompanyTurnover());
				oldCom.setCompanyWebsite(company.getCompanyWebsite());
				oldCom.setStockExchange(company.getStockExchange());
				companyRepo.save(oldCom);
				return oldCom;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	@Override
     public String updateStockPrice(Company company) {
		Company c = companyRepo.getById(company.getCompanyCode());
		if(c != null) {
			c.setStockPrice(company.getStockPrice());
			return "Stock price updated";
		}
		return "Stock price not updated";
	}

}
