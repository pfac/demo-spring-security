package com.iampfac.howto.spring.security.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DataConfiguration {

	@Bean
	public DataSource dataSource() {
		final String prefix = "com/iampfac/howto/spring/security/";
		EmbeddedDatabase bean = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).setScriptEncoding("UTF-8").ignoreFailedDrops(true)
				.addScript(prefix + "schema.sql").addScripts(prefix + "users.sql", prefix + "roles.sql")
				.addScripts(prefix + "custom_users.sql", prefix + "custom_roles.sql").build();
		return bean;
	}

}
