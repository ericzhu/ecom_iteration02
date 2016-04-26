package com.ecomlogix.ecom.core.product.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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
   private boolean           isActive;

   @Column
   private Date              releaseDate;

   @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
   @JoinTable(name = "item_tag", joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id") )
   private Set<Tag>          tags;

   @OneToMany(fetch = FetchType.EAGER, mappedBy = "item")
   @Fetch(FetchMode.SELECT)
   private Set<Review>       reviews;

   public Item() {}

   public Item(String name, String image, String description, String category, float price) {
      this.name = name;
      this.image = image;
      this.description = description;
      this.category = category;
      this.price = price;
      this.isActive = true;
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

   public float getPrice() {
      return price;
   }

   public void setPrice(float price) {
      this.price = price;
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

   public Set<Tag> getTags() {
      return tags;
   }

   public void setTags(Set<Tag> tags) {
      this.tags = tags;
   }

   public Set<Review> getReviews() {
      if (reviews == null) {
         reviews = new HashSet<>();
      }
      return reviews;
   }
}
