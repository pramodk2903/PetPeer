package com.petstore.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
   protected void configure(HttpSecurity http) throws Exception {
//       http.authorizeRequests()
//           .antMatchers("/h2/**").permitAll()
//           .anyRequest().authenticated()
//           .and().httpBasic();
    	
    	http.authorizeRequests().antMatchers("/h2/**").permitAll();
    	http.authorizeRequests().antMatchers("/**").permitAll();
//    	http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
        http.cors();
        
   }

}
