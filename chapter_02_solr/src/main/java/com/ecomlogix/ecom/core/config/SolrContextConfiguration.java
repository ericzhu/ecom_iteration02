package com.ecomlogix.ecom.core.config;

import javax.inject.Inject;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@EnableSolrRepositories("")
public class SolrContextConfiguration {
   
   @Inject
   Environment environment;

   @Bean
   public SolrClient solrClient() {
      return new HttpSolrClient("");
   }

   @Bean
   public SolrTemplate solrTemplate(SolrClient solrClient) {
      return new SolrTemplate(solrClient);
   }

}
