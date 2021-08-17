package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService service;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		LOGGER.info("Application started.........");
		service = context.getBean(CountryService.class);
		testGetAllCountries();
//		testAddCountry();
//		testUpdateCountry();
//		testDeleteCountry();
	}

	private static void testGetAllCountries() {
		LOGGER.info("Start");
		//List<Country> countryList = service.getAllCountries();
		List<Country> countryList = service.getAllCountry("ou");
		LOGGER.debug("countries={}", countryList);
//		try {
//			Country country = service.findCountryByCode("IN");
//			LOGGER.info("countries={}", country);
//		} catch (CountryNotFoundException e) {
//			LOGGER.error(e.getMessage());
//		}
		LOGGER.info("End");
	}

	public static void testAddCountry() {
		LOGGER.info("Start");
		Country country = new Country("MM", "New Country");
		service.addCountry(country);
		LOGGER.info("End");
	}

	public static void testUpdateCountry() {
		LOGGER.info("Start");
		try {
			service.updateCountry("MM", "New Country Modified");
		} catch (CountryNotFoundException e) {
			LOGGER.error(e.getMessage());
		}
		LOGGER.info("End");
	}

	public static void testDeleteCountry() {
		LOGGER.info("Start");
		service.deleteCountry("MM");
		LOGGER.info("End");
	}
}
