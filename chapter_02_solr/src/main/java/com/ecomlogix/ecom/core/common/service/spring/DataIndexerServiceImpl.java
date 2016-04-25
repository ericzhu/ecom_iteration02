package com.ecomlogix.ecom.core.common.service.spring;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import com.ecomlogix.ecom.core.common.service.DataIndexerService;
import com.ecomlogix.ecom.core.product.domain.ItemDocument;

@Service
public class DataIndexerServiceImpl implements DataIndexerService {

   private static final String sqlItem     = "";
   private static final String sqlItemTags = "";

   @Inject
   private DataSource          dataSource;

   @Override
   public void fullBuild() {

   }

   public List<ItemDocument> retrieveData() {

      Connection connection = null;

      ResultSet resultSet = null;

      try {
         connection = dataSource.getConnection();
         Statement stmt = connection.createStatement();
         resultSet = stmt.executeQuery(sqlItem);
         while (resultSet.next()) {

         }

      }
      catch (Exception e) {

      }
      finally {
         try {
            connection.close();
         }
         catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }

      return null;
   }

   // private ItemDocument ItemDocument() {
   //
   // }
   //
   // private List<Tag> getItemTags(final Connection connection, final Long itemId) {
   // PreparedStatement preparedStatement = null;
   // ResultSet resultSet = null;
   //
   // List<Tag> itemTags = new ArrayList<>();
   //
   // return itemTags;
   // }

}
