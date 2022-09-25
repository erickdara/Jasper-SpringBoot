package com.reports.jaspersoft;

import com.reports.jaspersoft.model.Product;
import com.reports.jaspersoft.model.ProductType;
import com.reports.jaspersoft.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return args -> {
			List<Product> products = List.of(
					new Product ("Samsung Galaxy", "4GB RAM", ProductType.PHONE,new BigDecimal("300"), LocalDate.now()),
					new Product ("Techno Spark", "2GB RAM", ProductType.PHONE,new BigDecimal("500"), LocalDate.now()),
					new Product ("HP Pavillion", "250GB SSD", ProductType.COMPUTER,new BigDecimal("600"), LocalDate.now().minusDays(1)),
					new Product ("Dell", "DDR4 RAM", ProductType.COMPUTER,new BigDecimal("700"), LocalDate.now().minusDays(1)),
					new Product ("Huawei", "Portatil 550GB SSD 8 GB RAM", ProductType.COMPUTER,new BigDecimal("300"), LocalDate.now().minusDays(1))

			);

					productRepository.saveAll(products);
		};
	}

	/*@Bean(initMethod="start",destroyMethod="stop")
	public org.h2.tools.Server h2WebConsoleServer () throws SQLException {
		return org.h2.tools.Server.createWebServer("-web","-webAllowOthers","-webDaemon","-webPort", "8081");
	}*/


/*	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server h2Server() throws SQLException {
		return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092", "-ifNotExists" ,"-web" ,"-webAllowOthers");
	}*/

}
