/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.numberaddition;
    
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author stefanos.zisidis
 */

public class DBConnection {
private Connection conn = null;
private Statement stmt;
private ResultSet rs;    

       /** 
     * Connect to a sample database 
     */  
    private Connection connect() {  
        //Connection conn = null;  
        try {  
            // db parameters  
         // DB Full path   String url = "jdbc:sqlite:C:/sqlite/JTP.db";  
         // DB relative path:
         String url = "jdbc:sqlite:./databases/users.db";    //jdbc:sqlite:sqlite_database_file_path
         // create a connection to the database  
         conn = DriverManager.getConnection(url);  
              
         System.out.println("Connection to SQLite has been established.");  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } finally {  
            try {  
                if (conn != null) {  
                    conn.close();  
                }  
            } catch (SQLException ex) {  
                System.out.println(ex.getMessage());  
            }  
        }  
        
        return conn; 
    }  
    
    
      /**
     * select all rows in the warehouses table
     */
    public void selectAll(){
        
           try {
             System.out.println("Connecting to database...");
             conn = this.connect();
             String sql = "SELECT * FROM users";
             System.out.println(sql);
             
             
             System.out.println("Creating statement...");
             stmt  = conn.createStatement();
             System.out.println ("statements is ");
             System.out.println (stmt);
             
             rs = stmt.executeQuery(sql);
             
             System.out.println("Connection and SELECT ALL is running 2");
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("username") + "\t" +
                                   rs.getString("Password"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    /** 
     * @param args the command line arguments 
     */  
    public static void main(String[] args) {  
        DBConnection app = new DBConnection();
//        app.selectAll();
          
        try (Connection conn = app.connect();
             Statement stmt = conn.createStatement();
                ){
//             System.out.println("Connecting to database...");
          
//             String sql = "SELECT * FROM users";
//             System.out.println(sql);
             
//             System.out.println("Creating statement...");
//             
                System.out.println ("statements is ");
//                System.out.println (stmt);
                
                ResultSet rs = stmt.executeQuery("SELECT * FROM users");
                
                System.out.println("Connection and SELECT ALL is running 2");
                // loop through the result set
                while (rs.next()) {
                    System.out.println(rs.getInt("id") +  "\t" +
                            rs.getString("username") + "\t" +
                            rs.getString("Password"));
                }
              
            }
         
         catch (SQLException e) {
            System.out.println(e.getMessage());
        }




    }  
}  
    
    

