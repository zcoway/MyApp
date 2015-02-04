package com.gangw.myapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity(debug = true)
public class MultiHttpSecurityConfig {

	public MultiHttpSecurityConfig() {
		System.out.println("MultiHttpSecurityConfig.MultiHttpSecurityConfig()");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("tom").password("123456")
				.roles("USER").and().withUser("admin").password("123456")
				.roles("USER", "ADMIN");
	}


	@Configuration
	@Order(1)
	public static class ApiWebSecurityConfigurationAdapter extends
			WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.antMatcher("/api/**").authorizeRequests().anyRequest()
					.hasRole("ADMIN").and().httpBasic();
		}

	}
	

	@Configuration
	public static class FormLoginWebSecurityConfigurerAdapter extends
			WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().anyRequest().authenticated().and()
					.formLogin().defaultSuccessUrl("/");
		}
	}

	@Configuration
	@Order(3)
	public static class AnononymousSecurityConfig extends WebSecurityConfigurerAdapter {
		@Override
		public void configure(WebSecurity web) {
		 	web.ignoring().antMatchers("/resources/**");
		}
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			//http.authorizeRequests().antMatchers("/**").hasRole("user").and();
			
		}
	}
}