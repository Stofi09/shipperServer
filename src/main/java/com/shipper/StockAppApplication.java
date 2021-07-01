package com.shipper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.shipper.domain.DeliveryList;
import com.shipper.domain.Equipment;
import com.shipper.domain.Message;
import com.shipper.service.MessageValidator;


@SpringBootApplication
public class StockAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockAppApplication.class, args);
		
	}
	
}
