package com.ecomlogix.ecom.core.common.repository;

import java.util.List;

import org.springframework.data.solr.core.query.SimpleQuery;

import com.ecomlogix.ecom.core.product.domain.Item;

public interface CustomSolrRepository {
   List<Item> search(SimpleQuery simpleQuery);
}
