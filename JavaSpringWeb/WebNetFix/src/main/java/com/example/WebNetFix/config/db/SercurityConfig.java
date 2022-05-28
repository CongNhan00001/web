package com.example.WebNetFix.config.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.WebNetFix.service.CustomerUserDetailService;

@Configuration
@EnableWebSecurity
public class SercurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomerUserDetailService custoUserDetailService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/fonts/**", "/images/**", "/js/**", "/scss/**");
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				/* .antMatchers("/").permitAll() sau / cho phep vao */
				.antMatchers("/css/**", "/fonts/**", "/images/**", "/js/**", "/scss/**", "/home").permitAll()
				.anyRequest().authenticated().and()
				.formLogin()
				.loginPage("/login").permitAll()
				.defaultSuccessUrl("/login?success=true")
				.failureUrl("/login?success=fail")
				.loginProcessingUrl("/j_spring_security_check");

	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		auth.userDetailsService(custoUserDetailService).passwordEncoder(passwordEncoder());
		super.configure(auth);
	}
	/*
	 * public void configure(AuthenticationManagerBuilder auth) throws Exception {
	 * 
	 * auth.userDetailsService(custoUserDetailService).passwordEncoder(
	 * passwordEncoder());
	 * 
	 * auth.inMemoryAuthentication()
	 * .withUser("user1").password(passwordEncoder().encode("123"))
	 * .authorities("ROLE_USER");
	 * 
	 * }
	 */

}
