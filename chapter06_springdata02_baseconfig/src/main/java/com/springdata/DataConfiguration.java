package com.springdata;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.springdata.repository")
@EnableTransactionManagement
@ComponentScan("com.springdata")
public class DataConfiguration {

   @Bean
   public DataSource dataSource() {
      EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
      builder.setType(EmbeddedDatabaseType.H2);
      return builder.build();
   }

   @Bean
   public EntityManagerFactory entityManagerFactory() {
      HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      vendorAdapter.setGenerateDdl(true);

      Properties jpaProperties = new Properties();
      jpaProperties.put("hibernate.hbm2ddl.auto", "create-drop");
      jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
      jpaProperties.put("hibernate.hbm2ddl.import_files", "init.sql");

      LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
      factory.setDataSource(dataSource());
      factory.setPackagesToScan("com.springdata.domain");
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
