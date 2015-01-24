package com.iampfac.howto.spring.security.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * Base test configuration for JDBC samples.
 * 
 * Builds an embedded database using three files: - schema.sql - users.sql -
 * roles.sql
 * 
 * Each specific configuration using JDBC should provide these files with the
 * expected database format and data.
 * 
 * @author Pedro Costa &lt;pedro.costa@vilt-group.com&gt;
 *
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JdbcSecurityContext extends SecurityContext {

	@Bean
	public DataSource dataSource() {
		final String prefix = "com/iampfac/howto/spring/security/";
		final String schema = prefix + "schema.sql";
		final String users = prefix + "users.sql";
		final String roles = prefix + "roles.sql";
		EmbeddedDatabase bean = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).setScriptEncoding("UTF-8").ignoreFailedDrops(true)
				.addScript(schema).addScripts(users, roles).build();
		return bean;
	}
}
