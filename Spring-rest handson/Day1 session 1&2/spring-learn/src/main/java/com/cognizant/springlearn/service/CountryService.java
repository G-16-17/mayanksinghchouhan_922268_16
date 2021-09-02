package com.cognizant.springlearn.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	public Country getCountry(String code) throws CountryNotFoundException {

		String bean = code.toLowerCase();

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = (List<Country>) context.getBean("countryList");
		for (Country country : countries) {
			if (country.getCode().equalsIgnoreCase(bean)) {
				return context.getBean(bean, Country.class);
			}

		}
		throw new CountryNotFoundException();

	}
}
