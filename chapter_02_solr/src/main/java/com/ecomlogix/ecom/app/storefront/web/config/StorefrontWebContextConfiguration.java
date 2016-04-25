package com.ecomlogix.ecom.app.storefront.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ecomlogix.ecom.app.shop.web.controller", useDefaultFilters = false, includeFilters = @ComponentScan.Filter(Controller.class) )
public class StorefrontWebContextConfiguration extends WebMvcConfigurerAdapter {

   @Bean
   public ViewResolver viewResolver() {
      InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
      viewResolver.setViewClass(JstlView.class);
      viewResolver.setPrefix("/WEB-INF/view/");
      viewResolver.setSuffix(".jsp");
      return viewResolver;
   }
}
