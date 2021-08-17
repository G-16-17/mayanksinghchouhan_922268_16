package com.cognizant.ormlearn.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;

public class StockService {

	@Autowired
	private StockRepository repository;

	@Transactional
	public List<Stock> getAllStock(String stockCode, int month, int year) {
		return repository.findStockByCodeAndMonthAndYear(stockCode, month, year);
	}

}
