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

/**
 *
 * @author dao
 */
public class Accessdb {
      private final String className="com.mysql.jdbc.Driver";
      private Connection connection;
      private final String url="jdbc:mysql://localhost:3306/info";
      private final String user="root";
      private final String pass="";
      private String table ="login";
      String a="admin-admin";
        
       public String Accessdb() throws ClassNotFoundException{
           try{
            Class.forName(className);
            connection = DriverManager.getConnection(url,user,pass);//Connection vào database
            System.out.println("DataBase Access!!!");
            
            
            
            ResultSet rs;
            Statement st;
            st=connection.createStatement();
            rs=st.executeQuery("select * from info.login");
            while (rs.next()){
                a=a+"/"+rs.getString(1)+"-"+rs.getString(2);
                        }
            connection.close();
            return a;//
               
               
        
        }catch(SQLException e){
            System.out.println("Error"+e.toString());
            return null;
        }
             
    }
       }
    
