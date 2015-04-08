package com.oms.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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

import com.oms.model.controller.product.ProductController;
import com.oms.model.repository.product.ProductDao;
import com.oms.model.service.product.ProductServiceImpl;

/**
 * 
 * @author dianaduque
 *         http://gordondickens.com/wordpress/2013/02/28/database-config
 *         -spring-3-2-environment-profiles/
 */
@Configuration
@PropertySource("classpath:/dbProducts.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = { ProductDao.class }, entityManagerFactoryRef = "entityManagerFactoryDbProduct", transactionManagerRef = "transationManagerFactoryDbProduct")
//@ComponentScan(basePackages = "com.oms.model")
@ComponentScan(basePackageClasses = { ProductController.class, ProductServiceImpl.class } )
public class DbProductConfig{
	
	@Value("#{ environment['products.jdbc.driverClassName']?:'' }")
	protected String dbDriverClass;
	@Value("#{ environment['products.jdbc.url']?:'' }")
	protected String dbUrl;
	@Value("#{ environment['products.jdbc.username']?:'' }")
	protected String dbUserName;
	@Value("#{ environment['products.jdbc.password']?:'' }")
	protected String dbPassword;
	@Value("#{ environment['products.database.vendor']?:'' }")
	protected String dbVendor;

	@Autowired
	Environment environment;

	@Value("#{ environment['products.entity.package'] }")
	private String entityPackage = "com.oms.model.entity.product";

	@Bean(name="dataSourceProducts")
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

	@Bean(name = "entityManagerFactoryDbProduct")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan(entityPackage);
		factory.setDataSource(dataSource());
		if (getJpaProperties() != null) {
			factory.setJpaProperties(getJpaProperties());
		}

		factory.setBeanName("entityManagerFactoryDbProduct");
		factory.setPersistenceUnitName("springappPU");
		return factory;
	}

	@Bean(name = "transationManagerFactoryDbProduct")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return txManager;
	}

	@Bean(name = "exceptionTranslationProduct")
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties getJpaProperties() {
		return new Properties() {
			{
				//setProperty("hibernate.hbm2ddl.auto", "none");
				setProperty("hibernate.dialect",
						"org.hibernate.dialect.SQLServer2008Dialect");
				setProperty("hibernate.globally_quoted_identifiers", "true");
			}
		};
	}

}
