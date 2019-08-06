package com.example.Springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	public SpringSecurityConfig() {
		System.out.println("SpringSecurityConfig.SpringSecurityConfig()");
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("AuthenticationManagerBuilder() assign role");
		auth.userDetailsService(userDetailsService)
				.passwordEncoder(getPasswordEncoder());



		/*auth.inMemoryAuthentication()
				.withUser("user").password("{noop}password").roles("USER")
				.and()
				.withUser("shankar").password("{noop}12345678").roles("USER", "ADMIN");*/
	}

	PasswordEncoder getPasswordEncoder() {
		return new PasswordEncoder() {
			@Override
			public String encode(CharSequence charSequence) {
				return charSequence.toString();
			}

			@Override
			public boolean matches(CharSequence charSequence, String s) {
				return true;
			}
		};
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("HttpSecurity access Url privilege()");
//		http.httpBasic()
//				.and()
//				.authorizeRequests()
//				.antMatchers(HttpMethod.GET, "/books/**").hasRole("USER")
//				.antMatchers(HttpMethod.POST, "/book").hasRole("ADMIN")
//				.antMatchers(HttpMethod.PUT, "/book").hasRole("ADMIN")
//				.antMatchers(HttpMethod.DELETE, "/book/**").hasRole("ADMIN")
//				.antMatchers(HttpMethod.DELETE, "/delete/account/**").hasRole("ADMIN")
//				.and()
//				.csrf().disable()
//				.formLogin().disable();


		http.csrf().disable();
		http.authorizeRequests()
				.antMatchers("/book/**").authenticated()
				.antMatchers("/books").authenticated()
				.antMatchers("/delete/account/**").authenticated()
				.anyRequest().permitAll()
				.and()
				.formLogin().permitAll();

	}

}
