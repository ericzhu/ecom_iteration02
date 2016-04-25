package com.ecomlogix.ecom.core.product.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import com.ecomlogix.ecom.core.base.domain.BaseEntity;

@Entity
public class Tag extends BaseEntity {

   private static final long serialVersionUID = 1L;

   @Column
   private String            manufacturer;

   @Column
   private String            name;

   @ManyToMany(mappedBy = "tags", fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
   private Set<Item>         items;

   public Tag() {}

   public Tag(String manufacturer, String name, Set<Item> items) {
      this.manufacturer = manufacturer;
      this.name = name;
      this.items = items;
   }

   public String getManufacturer() {
      return manufacturer;
   }

   public void setManufacturer(String manufacturer) {
      this.manufacturer = manufacturer;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Set<Item> getItems() {
      return items;
   }

   public void setItems(Set<Item> items) {
      this.items = items;
   }
}