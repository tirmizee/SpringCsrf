package com.tirmizee.core.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.GET, "/resources/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("pratya").password("pratya").roles("USER");
	}
	
	@Bean
	public CsrfTokenRepository csrfTokenRepository(){
		return new GTSessionCsrfTokenRepositoryImpl();
	} 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().csrfTokenRepository(csrfTokenRepository())
			.and()
			.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/Welcome");
	}
	
}
