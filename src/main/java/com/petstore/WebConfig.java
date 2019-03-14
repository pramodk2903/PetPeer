//package com.petstore;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@PropertySource("classpath:AppConfig.properties")
//public class WebConfig implements WebMvcConfigurer {
//	
//	Logger logger = LoggerFactory.getLogger(WebConfig.class);
//	
//	@Value("${ui.app.host}")
//	private String uiHost;
//	
//	@Value("${ui.app.port}")
//	private String uiPort;
//
//	public void addCorsMappings(CorsRegistry registry) {
//		logger.info("uiHost : " + uiHost);
//		logger.info("uiPort : " + uiPort);
//		String url = "http://" + uiHost + ":" + uiPort;
//		registry.addMapping("/PetStore/**").allowedOrigins("*").allowedHeaders("*").allowedMethods("*");
////		registry.addMapping("/user").allowedOrigins(url);
//	}
//	
//}
