package com.example.mvc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//clase que gestiona la configuracion de seguridad
//anotacion que sustituye a la antigua herencia de seguridad WebSecurityConfigurerAdapter 
@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
@Bean
public SecurityFilterChain securityFilterChain (HttpSecurity http
		) throws Exception { 
	
	
	return http
			.authorizeHttpRequests(auth -> {
				
				auth.anyRequest().authenticated();
			})
			.formLogin((form) -> form.loginPage("/login").permitAll())
			.build();
		
		}

@Bean
public PasswordEncoder passwordEncoder(){
  return new BCryptPasswordEncoder();
}


//Creacion de los detalles de usuario, en este caso con nombre y pass "admin" y "employee" respectivamente

//inyeccion del servicio 

@Bean
public UserDetailsService users() {
  UserDetails admin = User.withUsername("admin")
      .password(passwordEncoder().encode("admin"))
      .roles("ADMIN", "EMPLOYEE").build();
  UserDetails employee = User.withUsername("employee")
      .password(passwordEncoder().encode("employee"))
      .roles("EMPLOYEE").build();
 
  return new InMemoryUserDetailsManager(admin, employee);
}

}