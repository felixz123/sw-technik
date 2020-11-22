package com.project.zulassungssystem;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	/*
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
	}*/


	@Autowired
	UserDetailsService userDetailsService;



	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService);
	}







	@Bean
	public PasswordEncoder getPasswordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/zulassung").hasRole("ZULASSUNG")
			.antMatchers("/changestatus").hasRole("ZULASSUNG")
			.antMatchers("/datatable").hasRole("ZULASSUNG")
			.antMatchers("/bewerber").hasRole("BEWERBER")
			.antMatchers("/unterstuetzer").hasRole("UNTERSTUETZER")
			.antMatchers("/").permitAll()
			.antMatchers("/home").permitAll()
			.antMatchers("/hello").permitAll()
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