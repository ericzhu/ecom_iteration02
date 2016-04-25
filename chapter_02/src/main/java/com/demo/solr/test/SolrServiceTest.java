package com.demo.solr.test;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.junit.Before;
import org.junit.Test;

import com.demo.solr.pojo.Product;
import com.demo.solr.service.SolrService;

public class SolrServiceTest {

   SolrService solrService;

   @Before
   public void setup() {
      String solrServerBaseUrl = "http://localhost:8983/taotao";
      HttpSolrServer httpSolrServer = new HttpSolrServer(solrServerBaseUrl);
      httpSolrServer.setParser(new XMLResponseParser());
      httpSolrServer.setConnectionTimeout(500);
      httpSolrServer.setMaxRetries(1);
      solrService = new SolrService(httpSolrServer);
   }

   @Test
   public void testAdd() throws IOException, SolrServerException {
      Product product = new Product();
      product.setProductId(System.currentTimeMillis());
      product.setName("Dell Latitude 4558");
      solrService.add(product);
   }
   
   @Test
   public void testSearch() throws SolrServerException {
      List<Product> products = solrService.search("Latitude", Integer.valueOf(1), Integer.valueOf(10));
      System.out.println(products.size());
   }
}
