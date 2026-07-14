package com.cognizant.spring_country.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.spring_country.model.CountryList;

@Configuration
public class AppConfig {

    @Bean
    public CountryList countryList() {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        return context.getBean("countryList", CountryList.class);
    }
}