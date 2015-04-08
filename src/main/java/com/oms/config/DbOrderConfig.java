package com.oms.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.oms.model.repository.order.ClientDao;

/**
 * 
 * @author dianaduque
 * 
 */
@Configuration
@PropertySource("classpath:/dbOrder.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = { ClientDao.class }, entityManagerFactoryRef = "entityManagerFactoryDbOrder", transactionManagerRef = "transationManagerFactoryDbOrder")
// @ComponentScan(basePackageClasses = { ProductController.class,
// ProductServiceImpl.class })
public class DbOrderConfig {

	@Value("#{ environment['order.oracle.driverClassName']?:'' }")
	protected String dbDriverClass;
	@Value("#{ environment['order.oracle.url']?:'' }")
	protected String dbUrl;
	@Value("#{ environment['order.oracle.username']?:'' }")
	protected String dbUserName;
	@Value("#{ environment['order.oracle.password']?:'' }")
	protected String dbPassword;
	@Value("#{ environment['order.database.vendor']?:'' }")
	protected String dbVendor;

	@Autowired
	Environment environment;

	@Value("#{ environment['oms.entity.package'] }")
	private String entityPackage = "com.oms.model.entity.order";

	@Bean(name = "dataSourceOrder")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(dbDriverClass);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUserName);
		dataSource.setPassword(dbPassword);
		dataSource.setTestOnBorrow(true);
		dataSource.setTestOnReturn(true);
		dataSource.setTestWhileIdle(true);
		dataSource.setTimeBetweenEvictionRunsMillis(1800000);
		dataSource.setNumTestsPerEvictionRun(3);
		dataSource.setMinEvictableIdleTimeMillis(1800000);
		return dataSource;
	}

	@Bean(name = "entityManagerFactoryDbOrder")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan(entityPackage);
		factory.setDataSource(dataSource());
		if (getJpaProperties() != null) {
			factory.setJpaProperties(getJpaProperties());
		}

		factory.setBeanName("entityManagerFactoryDbOrder");
		factory.setPersistenceUnitName("springappOrderPU");
		return factory;
	}

	@Bean(name = "transationManagerFactoryDbOrder")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return txManager;
	}

	@Bean(name = "exceptionTranslationOrder")
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties getJpaProperties() {
		return new Properties() {
			{
				// setProperty("hibernate.hbm2ddl.auto", "none");
				setProperty("hibernate.dialect",
						"org.hibernate.dialect.Oracle10gDialect");
				setProperty("hibernate.globally_quoted_identifiers", "true");
			}
		};
	}

}
