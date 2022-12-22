package com.example.demo.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.StockPrice;

@Repository
@Transactional
public interface StockRepository extends JpaRepository<StockPrice, Integer> {

	List<StockPrice> findByStockPrice(double cc);

}
