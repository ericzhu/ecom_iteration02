package com.ecomlogix.ecom.core.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Configuration
@ComponentScan(basePackages = "com.ecomlogix.ecom.core", excludeFilters = @ComponentScan.Filter({ Controller.class, ControllerAdvice.class }) )
@EnableTransactionManagement(mode = AdviceMode.PROXY, proxyTargetClass = false, order = Ordered.LOWEST_PRECEDENCE)
public class RootContextConfiguration {

   @Bean
   public DataSource ecomDataSource() {
      BasicDataSource dataSource = new BasicDataSource();
      dataSource.setDriverClassName("com.mysql.jdbc.Driver");
      dataSource.setUrl("jdbc:mysql://localhost:3306/solr");
      dataSource.setUsername("root");
      dataSource.setPassword("root");
      return dataSource;
   }

   @Bean
   public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {

      Map<String, Object> properties = new HashMap<>();
      properties.put("javax.persistence.schema-generation.database.action", "none");

      HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
      adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
      adapter.setShowSql(true);
      adapter.setGenerateDdl(true);

      LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
      factory.setDataSource(this.ecomDataSource());
      factory.setJpaVendorAdapter(adapter);
      factory.setPackagesToScan("com.ecomlogix.ecom.core.**.domain");
      factory.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
      factory.setValidationMode(ValidationMode.NONE);
      factory.setJpaPropertyMap(properties);

      return factory;
   }

   @Bean
   public PlatformTransactionManager jpaTransactionManager() {
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
      return transactionManager;
   }
}