package br.com.igor.challenge.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String ROLE_CONSUMER = "CONSUMER";

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/api/**").hasRole(ROLE_CONSUMER).and().httpBasic();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("bankxpto").password(passwordEncoder().encode("bankxptopassword")).roles(ROLE_CONSUMER).and()
			.withUser("appxpto").password(passwordEncoder().encode("appxptopassword")).roles(ROLE_CONSUMER).and()
			.withUser("userxpto").password(passwordEncoder().encode("userxptopassword")).roles(ROLE_CONSUMER);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}