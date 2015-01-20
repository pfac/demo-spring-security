package com.iampfac.howto.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.iampfac.howto.spring.security.core.Messenger;
import com.iampfac.howto.spring.security.core.SimpleMessenger;

@Configuration
public class AppConfiguration {

	@Bean
	public Messenger messenger() {
		return new SimpleMessenger();
	}

}
