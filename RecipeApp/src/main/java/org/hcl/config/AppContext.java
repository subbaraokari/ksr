package org.hcl.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class AppContext {
	@Autowired
	Environment environment;
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getProperty("jdbc.url"));
		dataSource.setUsername(environment.getProperty("jdbc.username"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		return dataSource;
	}
	@Bean
	public LocalSessionFactoryBean getFactoryBean() {
		LocalSessionFactoryBean factoryBean=new LocalSessionFactoryBean();
		factoryBean.setDataSource(getDataSource());
		factoryBean.setHibernateProperties(getProperties());
		factoryBean.setPackagesToScan("org.hcl.entities");
		return factoryBean;
	}
	public Properties getProperties() {
		Properties properties=new Properties();
		properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		properties.setProperty("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
		properties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
		return properties;
	}
	@Bean
	public HibernateTransactionManager getTransactionManaget() {
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(getFactoryBean().getObject());
		return transactionManager;
	}
}
