package com.ecomlogix.ecom.application.admin.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.mysql.jdbc.Driver;

@Configuration
public class EcomAdminRootApplicationContextConfig {

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(Driver.class.getCanonicalName());
		dataSource.setUrl("jdbc:mysql://localhost:3306/ecom02");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setPackagesToScan("com.ecomlogix.ecom.core.**.domain");

		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabasePlatform(MySQL5InnoDBDialect.class.getCanonicalName());
		jpaVendorAdapter.setShowSql(true);
		jpaVendorAdapter.setGenerateDdl(true);
		entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);

		Map<String, Object> properties = new HashMap<>();
		properties.put("javax.persistence.schema-generation.database.action", "none");
		entityManagerFactory.setJpaPropertyMap(properties);

		return entityManagerFactory;
	}
}
