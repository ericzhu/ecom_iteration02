package com.demo.solr.pojo;

import org.apache.solr.client.solrj.beans.Field;

public class Product {

   @Field("product_id")
   private Long   productId;

   @Field("name")
   private String name;

   @Field("description")
   private String description;

   public Long getProductId() {
      return productId;
   }

   public void setProductId(Long productId) {
      this.productId = productId;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }
}
