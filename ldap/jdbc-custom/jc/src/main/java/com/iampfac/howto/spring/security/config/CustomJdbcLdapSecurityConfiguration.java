package com.iampfac.howto.spring.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.support.BaseLdapPathContextSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.server.ApacheDSContainer;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;

import com.iampfac.howto.spring.security.CustomJdbcLdapAuthoritiesPopulator;
import com.iampfac.howto.spring.security.CustomLdapJdbcUserDetailsService;
import com.iampfac.howto.spring.security.CustomLdapTemplate;
import com.iampfac.howto.spring.security.ICustomLdapTemplate;
import com.iampfac.howto.spring.security.JdbcUserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CustomJdbcLdapSecurityConfiguration extends GlobalMethodSecurityConfiguration {

	private LdapAuthoritiesPopulator ldapAuthoritiesPopulator;

	private BaseLdapPathContextSource contextSource;

	@Bean(name = "org.springframework.security.apacheDirectoryServerContainer")
	public ApacheDSContainer embeddedLdapServer() throws Exception {
		ApacheDSContainer bean = new ApacheDSContainer("dc=example,dc=com", "classpath:com/iampfac/howto/spring/security/server.ldif");
		bean.setPort(33389);
		return bean;
	}

	@Bean
	public BaseLdapPathContextSource contextSource() throws Exception {
		DefaultSpringSecurityContextSource bean = new DefaultSpringSecurityContextSource("ldap://127.0.0.1:33389/dc=example,dc=com");
		bean.setAnonymousReadOnly(true);
		return bean;
	}

	@Bean
	public ICustomLdapTemplate ldapTemplate(ContextSource contextSource) {
		CustomLdapTemplate bean = new CustomLdapTemplate(contextSource);
		return bean;
	}

	@Bean
	public DataSource dataSource() {
		final String prefix = "com/iampfac/howto/spring/security/";
		final String schema = prefix + "schema.sql";
		final String authorities = prefix + "authorities.sql";
		final String roles = prefix + "roles.sql";
		EmbeddedDatabase bean = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).setScriptEncoding("UTF-8").ignoreFailedDrops(true)
				.addScript(schema).addScripts(roles, authorities).build();
		return bean;
	}

	@Bean
	public JdbcUserDetailsService userDetailsService(DataSource dataSource) {
		CustomLdapJdbcUserDetailsService bean = new CustomLdapJdbcUserDetailsService();
		bean.setDataSource(dataSource);
		return bean;
	}
	
	@Bean
	public LdapAuthoritiesPopulator ldapAuthoritiesPopulator(ICustomLdapTemplate ldapTemplate, JdbcUserDetailsService userDetailsService) {
		CustomJdbcLdapAuthoritiesPopulator bean = new CustomJdbcLdapAuthoritiesPopulator(ldapTemplate, userDetailsService);
		return bean;
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.ldapAuthentication().ldapAuthoritiesPopulator(ldapAuthoritiesPopulator).userDnPatterns("uid={0},ou=users").contextSource(contextSource);
	}

	@Autowired
	public void setContextSource(BaseLdapPathContextSource contextSource) {
		this.contextSource = contextSource;
	}

	@Autowired
	public void setLdapAuthoritiesPopulator(LdapAuthoritiesPopulator ldapAuthoritiesPopulator) {
		this.ldapAuthoritiesPopulator = ldapAuthoritiesPopulator;
	}
}
