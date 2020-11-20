package com.project.zulassungssystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("blah")
			.password("blah")
			.roles("BEWERBER")
			.and()
			.withUser("zul")
			.password("zulpw")
			.roles("ZULASSUNG")
			.and()
			.withUser("supp")
			.password("supppw")
			.roles("UNTERSTUETZER");
	}


	@Bean
	public PasswordEncoder getPasswordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/zulassung").hasRole("ZULASSUNG")
			.and()
			.authorizeRequests().antMatchers("/bewerber").hasRole("BEWERBER")
			.and()
			.authorizeRequests().antMatchers("/unterstuetzer").hasRole("UNTERSTUETZER")
			.and()
			.authorizeRequests().antMatchers("/").permitAll()
			.and()
			.authorizeRequests().antMatchers("/home").permitAll()
			.and()
			.authorizeRequests().antMatchers("/hello").permitAll()
			.and()
			.formLogin();
			
	}




	/*
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}*/
}