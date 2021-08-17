package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.StockService;

@SpringBootApplication
public class OrmLearnApplication1 {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService service;
	private static StockService stockService;
	@Autowired
	private static StockRepository stockRepository;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		LOGGER.info("Start");
		LOGGER.info("Application started.........");
		stockRepository = context.getBean(StockRepository.class);
		// List<Stock> list = stockService.getAllStock("FB", 9, 2019);
		// LOGGER.info("Stock List:{}", list);
		List<Stock> stockList = stockRepository.findStockByCodeAndMonthAndYear("FB", 9, 2019);
		// List<Stock> stockList =
		// stockRepository.findGoogleStockByNameAndPrice("GOOGL");
		// LOGGER.info("Stock List:{}", stockList);
		// List<Stock> stockList =
		// stockRepository.findStockByVolume(Sort.by("volume").descending());
		// LOGGER.info("Stock List:{}", stockList);
		// Pageable pageable = PageRequest.of(0, 3, Sort.by("volume").descending());
//		List<Stock> stockList = stockRepository.findThreeHighestVolumeStock(pageable);
		// LOGGER.info("Stock List:{}", stockList);
		LOGGER.info("End");
	}

}
