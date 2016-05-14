package com.ecomlogix.ecom.core.common.domain;

import java.util.List;

import org.apache.solr.client.solrj.beans.Field;

public class Book {

   @Field
   private String         id;

   @Field
   private String         name;

   @Field
   private String         description;

   @Field("categories_txt")
   private List<Category> categories;

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
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

   public List<Category> getCategories() {
      return categories;
   }

   public void setCategories(List<Category> categories) {
      this.categories = categories;
   }

   public enum Category {
      EDUCATION,
      HISTORY,
      HUMOR,
      TECHNOLOGY,
      ROMANCE,
      ADVENTURE
   }
}
