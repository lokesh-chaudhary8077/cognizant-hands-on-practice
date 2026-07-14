package com.cognizant.spring_country.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.spring_country.model.Country;
import com.cognizant.spring_country.model.CountryList;

@Service
public class CountryService {

    @Autowired
    private CountryList countryList;

    public Country getCountry(String code) {

        List<Country> countries = countryList.getCountryList();

        for (Country country : countries) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }

        return null;
    }
}