package com.ecomlogix.ecom.core.product.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Review {

   private String username;

   private int    stars;

   private String comments;

   public Review() {}

   public Review(String username, int stars, String comments) {
      this.username = username;
      this.stars = stars;
      this.comments = comments;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public int getStars() {
      return stars;
   }

   public void setStars(int stars) {
      this.stars = stars;
   }

   public String getComments() {
      return comments;
   }

   public void setComments(String comments) {
      this.comments = comments;
   }

}
