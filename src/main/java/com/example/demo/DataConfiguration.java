package com.example.demo;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.example.repository")
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.example.service",
								"com.example.exceptions",
								"com.example.handler"})
@PropertySource("classpath:application.properties")
public class DataConfiguration {

	@Value("${spring.jpa.show-sql}")
	private String prop1;
	
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		return builder.setType(EmbeddedDatabaseType.H2).build();
	}
	
	@Bean 
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setShowSql(true);
		
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2ddl.auto", "create-drop");
		jpaProperties.put("hibernate.naming.strategy", "org.hibernate.cfg.DefaultNamingStrategy");
		jpaProperties.put("hibernate.ddl", "validate");
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		jpaProperties.put("hibernate.hbm2ddl.import_files", 
				"load_employees.sql, load_departments.sql, load_dept_emp.sql, load_dept_manager.sql");
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan("com.example.model");
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setJpaProperties(jpaProperties);
		factory.afterPropertiesSet();
		return factory.getObject();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}
}
