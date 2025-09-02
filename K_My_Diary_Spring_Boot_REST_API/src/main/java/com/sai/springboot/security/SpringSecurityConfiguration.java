package com.sai.springboot.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {

	// Authentication From Data base
	@Bean
	protected UserDetailsManager getUserDetailsFromDataBase(DataSource dataSource) {
		UserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
		return userDetailsManager;
	}

	// Authorization with HTTP Security

	@Bean
	protected SecurityFilterChain authorizeHttpRequests(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(
				authorize -> {

					authorize.requestMatchers(HttpMethod.DELETE, "/entries/**").hasAuthority("ROLE_ADMIN")
							.requestMatchers(HttpMethod.PUT, "/entries/**").hasAnyAuthority("ROLE_MANAGER")
							.anyRequest()
							.authenticated();
				}
		)
		.httpBasic(Customizer.withDefaults())
		.csrf(csrf -> csrf.disable());

		return http.build();
	}

	// Authentication from In Memory
	// @Bean
	InMemoryUserDetailsManager getUserDetailsFromInMemory() {

		UserDetails user1;
		UserDetails user2;
		UserDetails user3;

		user1 = User.builder().username("sai").password("{noop}1234").roles("ADMIN").build();
		user2 = User.builder().username("sss").password("{noop}1234").roles("MANAGER", "EMPLOYEE").build();
		user3 = User.builder().username("sri").password("{noop}1234").roles("EMPLOYEE").build();

		InMemoryUserDetailsManager userDetails = new InMemoryUserDetailsManager(user1, user2, user3);
		return userDetails;
	}

}