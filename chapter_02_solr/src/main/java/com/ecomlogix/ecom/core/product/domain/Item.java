package com.ecomlogix.ecom.core.product.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.ecomlogix.ecom.core.base.domain.BaseEntity;

@Entity
public class Item extends BaseEntity {

   private static final long serialVersionUID = 1L;

   @Column
   private String            name;

   @Column(length = 1000)
   private String            description;

   @Column
   private String            category;

   @Column
   private String            image;

   @Column
   private float             price;

   @Column
   private boolean           active;

   @Column
   private Date              releaseDate;

   @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
   @JoinTable(name = "item_tag", joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id") )
   private Set<Tag>          tags;

   @ElementCollection(fetch = FetchType.EAGER)
   @CollectionTable(name = "review", joinColumns = @JoinColumn(name = "id", referencedColumnName = "id") )
   @Fetch(FetchMode.SELECT)
   private Set<Review>       customerReviews;

   public Item() {}

   public Item(String name, String image, String description, String category, float price) {
      this.name = name;
      this.image = image;
      this.description = description;
      this.category = category;
      this.price = price;
      this.active = true;
      this.releaseDate = new Date();
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

   public String getCategory() {
      return category;
   }

   public void setCategory(String category) {
      this.category = category;
   }

   public String getImage() {
      return image;
   }

   public void setImage(String image) {
      this.image = image;
   }

   public Set<Tag> getTags() {
      return tags;
   }

   public void setSupportedDevices(Set<Tag> tags) {
      this.tags = tags;
   }

   public boolean isActive() {
      return active;
   }

   public void setActive(boolean active) {
      this.active = active;
   }

   public Set<Review> getCustomerReviews() {
      return customerReviews;
   }

   public void setCustomerReviews(Set<Review> customerReviews) {
      this.customerReviews = customerReviews;
   }

   public Date getReleaseDate() {
      return releaseDate;
   }

   public void setReleaseDate(Date releaseDate) {
      this.releaseDate = releaseDate;
   }

   public float getPrice() {
      return price;
   }

   public void setPrice(float price) {
      this.price = price;
   }
}
