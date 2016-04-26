package com.ecomlogix.ecom.core.product.domain;

import java.util.Date;
import java.util.List;

public class ItemDocument {

   private String       itemName;

   private String       itemDescription;

   private String       image;

   private String       category;

   private boolean      isActive = true;

   private Date         releaseDate;

   private List<Tag>    tags;

   private List<Review> reviews;

   public String getItemName() {
      return itemName;
   }

   public void setItemName(String itemName) {
      this.itemName = itemName;
   }

   public String getItemDescription() {
      return itemDescription;
   }

   public void setItemDescription(String itemDescription) {
      this.itemDescription = itemDescription;
   }

   public String getImage() {
      return image;
   }

   public void setImage(String image) {
      this.image = image;
   }

   public String getCategory() {
      return category;
   }

   public void setCategory(String category) {
      this.category = category;
   }

   public boolean isActive() {
      return isActive;
   }

   public void setActive(boolean isActive) {
      this.isActive = isActive;
   }

   public Date getReleaseDate() {
      return releaseDate;
   }

   public void setReleaseDate(Date releaseDate) {
      this.releaseDate = releaseDate;
   }

   public List<Tag> getTags() {
      return tags;
   }

   public void setTags(List<Tag> tags) {
      this.tags = tags;
   }

   public List<Review> getReviews() {
      return reviews;
   }

   public void setReviews(List<Review> reviews) {
      this.reviews = reviews;
   }

}
