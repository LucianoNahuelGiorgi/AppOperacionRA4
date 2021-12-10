package com.ienri.operacionra4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ienri.operacionra4.servicios.UsuarioServicio;

@SpringBootApplication
public class Operacionra4Application {
	@Autowired
	private UsuarioServicio administradorServicio;
	
	public static void main(String[] args) {
		SpringApplication.run(Operacionra4Application.class, args);
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth
			.userDetailsService(administradorServicio)
			.passwordEncoder(new BCryptPasswordEncoder());
	}
}
