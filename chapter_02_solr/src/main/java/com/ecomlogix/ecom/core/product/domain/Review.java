package com.ecomlogix.ecom.core.product.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.ecomlogix.ecom.core.base.domain.BaseEntity;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "item_id", "username" }) })
public class Review extends BaseEntity {

   private static final long serialVersionUID = 1L;

   private String            username;

   private int               stars;

   private String            comments;

   @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
   @JoinColumn(name = "item_id")
   private Item              item;

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

   public Item getItem() {
      return item;
   }

   public void setItem(Item item) {
      this.item = item;
      item.getReviews().add(this);
   }
}
