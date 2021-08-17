package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	@Autowired
	private CountryRepository repository;

	@Transactional
	public List<Country> getAllCountries() {
		List<Country> countrieList = repository.findAll();
		return countrieList;
	}

	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
		Optional<Country> result = repository.findById(countryCode);
		if (!result.isPresent()) {
			throw new CountryNotFoundException("Invlid Country Code");
		}
		Country country = result.get();
		return country;
	}

	@Transactional
	public void addCountry(Country country) {
		repository.save(country);
	}

	@Transactional
	public void updateCountry(String code, String name) throws CountryNotFoundException {
		Optional<Country> result = repository.findById(code);
		if (!result.isPresent()) {
			throw new CountryNotFoundException("Invlid Country Code");
		}
		Country country = result.get();
		country.setName(name);
		repository.save(country);
	}

	@Transactional
	public void deleteCountry(String code) {
		repository.deleteById(code);
	}

	public List<Country> getAllCountry(String str) {
		List<Country> countryList = repository.findCountryNmeContain(str);
		return countryList;
	}

}
