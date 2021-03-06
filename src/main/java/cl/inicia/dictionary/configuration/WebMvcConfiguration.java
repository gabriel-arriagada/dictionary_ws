package cl.inicia.dictionary.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cl.inicia.dictionary.service.translater.TokenGenerator;

@Configuration
@ComponentScan("cl.inicia.dictionary.controller")
@EnableWebMvc
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public TokenGenerator tokenGenerator() {
		return new TokenGenerator();
	}

}
