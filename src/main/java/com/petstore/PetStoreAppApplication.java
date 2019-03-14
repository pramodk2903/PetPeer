package com.petstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class PetStoreAppApplication extends SpringBootServletInitializer //implements CommandLineRunner
{

	Logger logger = LoggerFactory.getLogger(PetStoreAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PetStoreAppApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurerAdapter() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/products").allowedOrigins("http://localhost:8080");
//			}
//		};
//	}

	//	@Autowired
	//	PetService petService;
	//	
	//	@Override
	//    public void run(String...args) throws Exception {
	//		logger.info("run");
	//		List<Pet> pet = petService.getPet("A");
	//        System.out.println(pet);
	//    }

}
