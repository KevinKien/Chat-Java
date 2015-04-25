/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dao
 */
public class writedb {
      private final String className="com.mysql.jdbc.Driver";
      private Connection connection;
      private final String url="jdbc:mysql://localhost:3306/info";
      private final String user="root";
      private final String pass="";
      
      
         public void writedb(String code) throws ClassNotFoundException{
             
         
        try{
          
            Class.forName(className);
            Connection connection = DriverManager.getConnection(url,user,pass);
            System.out.println("Success !!!");
            Statement st;
            st=connection.createStatement();
            String sql=code;
            int rowcl = st.executeUpdate(sql);//Ghi vào db
            System.out.println("Đã thực hiện:   "+rowcl+ " lần");
            connection.close();
        }catch(SQLException e){
            System.out.println("Error write Database: "+e.toString());
        }
         }

    

   
}
