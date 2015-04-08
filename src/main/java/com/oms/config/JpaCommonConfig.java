package com.oms.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * 
 * @author dianaduque
 *         http://gordondickens.com/wordpress/2013/02/28/database-config
 *         -spring-3-2-environment-profiles/
 */
@Configuration
public abstract class JpaCommonConfig {

	@Value("#{ environment['jdbc.driverClassName']?:'' }")
	protected String dbDriverClass;
	@Value("#{ environment['jdbc.url']?:'' }")
	protected String dbUrl;
	@Value("#{ environment['jdbc.username']?:'' }")
	protected String dbUserName;
	@Value("#{ environment['jdbc.password']?:'' }")
	protected String dbPassword;
	@Value("#{ environment['database.vendor']?:'' }")
	protected String dbVendor;

	@Autowired
	Environment environment;

	public abstract DataSource dataSource();

	public abstract LocalContainerEntityManagerFactoryBean entityManagerFactory();

	public abstract PlatformTransactionManager transactionManager();

	public abstract PersistenceExceptionTranslationPostProcessor exceptionTranslation();

}
