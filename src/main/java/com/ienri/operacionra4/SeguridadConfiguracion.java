package com.ienri.operacionra4;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SeguridadConfiguracion extends WebSecurityConfigurerAdapter {

	String[] staticResources = {"/css/**", "/img/**", "/fonts/**", "/scripts/**"};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(staticResources)
			.permitAll()
		.and().formLogin()
		.loginPage("/login")
			.loginProcessingUrl("/logincheck")
			.usernameParameter("correo")
			.passwordParameter("contrasena")
			.defaultSuccessUrl("/inicio")
			.permitAll()
		.and().logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login?logout")
		.and().csrf().disable();
	}
}