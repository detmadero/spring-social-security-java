package com.mcnc.spring.social.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.session.jdbc.config.annotation.web.http.JdbcHttpSessionConfiguration;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

@Configuration
@ComponentScan("org.springframework.session.config.annotation.web.http")
@EnableJdbcHttpSession
@PropertySource("classpath:session-cfg.properties")
public class JdbcHttpSessionConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public CookieSerializer cookieSerializer() {
		final DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName(env.getProperty("cookieName"));
        serializer.setCookiePath(env.getProperty("cookiePath"));
        serializer.setDomainNamePattern(env.getProperty("domainNamePattern"));
        return serializer;
	}
	
	@Bean
	public JdbcHttpSessionConfiguration configuration() {
		JdbcHttpSessionConfiguration jdbcHttpSessionConfiguration = new JdbcHttpSessionConfiguration();
		jdbcHttpSessionConfiguration.setMaxInactiveIntervalInSeconds(Integer.parseInt(env.getProperty("maxInactiveIntervalInSeconds")));
		jdbcHttpSessionConfiguration.setCookieSerializer(this.cookieSerializer());
		return jdbcHttpSessionConfiguration;
	}
	
}
