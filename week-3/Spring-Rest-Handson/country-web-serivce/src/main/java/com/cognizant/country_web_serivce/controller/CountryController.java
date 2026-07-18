package com.cognizant.country_web_serivce.controller;

import com.cognizant.country_web_serivce.bean.Country;
import com.cognizant.country_web_serivce.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/country")
    public Country getCountry() {
        return countryService.getCountry();
    }
}