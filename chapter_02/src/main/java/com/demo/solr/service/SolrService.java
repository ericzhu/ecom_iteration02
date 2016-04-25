package com.demo.solr.service;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;

import com.demo.solr.pojo.Product;

public class SolrService {

   HttpSolrServer httpSolrServer;
   
   public SolrService(HttpSolrServer httpSolrServer) {
      this.httpSolrServer = httpSolrServer;
   }

   public void add(Product product) throws IOException, SolrServerException {
      httpSolrServer.addBean(product);
      httpSolrServer.commit();
   }
   
   public List<Product> search(String keywords, Integer page, Integer rows) throws SolrServerException {
      SolrQuery solrQuery = new SolrQuery();
      solrQuery.setQuery("name:" + keywords);
      solrQuery.setStart((Math.max(page, 1) - 1) * rows);
      solrQuery.setRows(rows);
      
      // boolean isHighLighting = !StringUtils.equals("*", keywords) && StringUtils.isNotEmpty(keywords);
      //
      // if(isHighLighting) {
      // solrQuery.setHighlight(true);
      // solrQuery.setHighlightSimplePre("<em>");
      // solrQuery.addHighlightField("name");
      // solrQuery.setHighlightSimplePost("</em>");
      // }
      //
      QueryResponse response = httpSolrServer.query(solrQuery);
      return response.getBeans(Product.class);
   }

}
