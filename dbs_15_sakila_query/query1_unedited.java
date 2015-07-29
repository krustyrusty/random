package dbs_15_sakila_query;

import java.sql.*;

public class query1_unedited 
{
   // JDBC driver name and database URL
   //  Database credentials
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/sakila";
   
   public static void main(String[] args) throws ClassNotFoundException  
   {
	   Connection conn = null;
	   Statement stmt = null;
	   try
	   {
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");
	
	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	
	      conn = DriverManager.getConnection(DB_URL,"root","");
	      
	      
	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT * FROM actor";
	      ResultSet rs = stmt.executeQuery(sql);
	               
	
	      //STEP 5: Extract data from result set
	      while(rs.next())
	      {	
	         //Retrieve by column name 
	         String first = rs.getString("first_name");
	         String last = rs.getString("last_name");
	
	         //Display values
	        
	         System.out.println(", First: " + first);
	         System.out.println(", Last: " + last);
	      }
	      rs.close();
	      stmt.close();
	      conn.close();
	   }
	   catch(SQLException se2)
	   {
		   se2.printStackTrace();
	   }
   
  
   }
   
   
}