package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

// SpringBootガイドのConsuming a RESTful Web Serviceで実装。今回は不要な為コメントアウト。
// import org.springframework.boot.web.client.RestTemplateBuilder;
// import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication {

	// ============================================================================================================
	// SpringBootガイドのConsuming a RESTful Web Serviceで実装。今回は不要な為コメントアウト。
	// ============================================================================================================
	// private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	// @Bean
	// public RestTemplate RestTemplate(RestTemplateBuilder builder) {
	// 	return builder.build();
	// }

	// @Bean
	// public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
	// 	return args -> {
	// 		Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
	// 		log.info(quote.toString());
	// 	};
	// }


	// SpringBootガイドのAccessing Data with JPAで実装。
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
  public CommandLineRunner demo(CustomerRepository repository) {
    return (args) -> {
      // save a few customers
      repository.save(new Customer("Jack", "Bauer"));
      repository.save(new Customer("Chloe", "O'Brian"));
      repository.save(new Customer("Kim", "Bauer"));
      repository.save(new Customer("David", "Palmer"));
      repository.save(new Customer("Michelle", "Dessler"));

      // fetch all customers
      log.info("findAll()で見つかった顧客:");
      log.info("-------------------------------");
      for (Customer customer : repository.findAll()) {
        log.info(customer.toString());
			}
			log.info("-------------------------------");
      log.info("");

      // fetch an individual customer by ID
      Customer customer = repository.findById(1L);
      log.info("findById(1L)で見つかった顧客:");
      log.info("--------------------------------");
			log.info(customer.toString());
			log.info("-------------------------------");
      log.info("");

      // fetch customers by last name
      log.info("findByLastName('Bauer')で見つかった顧客:");
      log.info("--------------------------------------------");
      repository.findByLastName("Bauer").forEach(bauer -> {
        log.info(bauer.toString());
      });
      // for (Customer bauer : repository.findByLastName("Bauer")) {
      //  log.info(bauer.toString());
      // }
      log.info("");
    };
  }

}