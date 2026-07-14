package com.cognizant.springCoreHandson4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCoreHandson4Application {

	public static void main(String[] args) {
		displayCountry();
	}

	public static void displayCountry() {

		ApplicationContext context =
				new ClassPathXmlApplicationContext("country.xml");

		Country country =
				context.getBean("country", Country.class);

		System.out.println("Country : " + country);

		((ClassPathXmlApplicationContext) context).close();
	}
}