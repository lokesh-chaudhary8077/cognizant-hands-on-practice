package com.cognizant.country_web_serivce.service;

import com.cognizant.country_web_serivce.bean.Country;

import org.springframework.stereotype.Service;

@Service
public class CountryService {

    public Country getCountry() {
        return new Country("IN", "India");
    }
}