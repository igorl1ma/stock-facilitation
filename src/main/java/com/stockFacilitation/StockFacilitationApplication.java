package com.stockFacilitation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableMongoRepositories(basePackages = "com.stockFacilitation.repository")
@ComponentScan(basePackages = {"com.stockFacilitation"})
public class StockFacilitationApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockFacilitationApplication.class, args);
	}

}
