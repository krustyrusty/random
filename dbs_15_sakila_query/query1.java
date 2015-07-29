package dbs_15_sakila_query;

import java.sql.*;

public class query1 {
   // JDBC driver name and database URL
   //  Database credentials
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/sakila";
   
   public static void main(String[] args) throws ClassNotFoundException  {
   Connection conn = null;
   Statement stmt = null;
   Statement stmt2 = null;
   Statement stmt3 = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");

      conn = DriverManager.getConnection(DB_URL,"root","");
      
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      stmt2 = conn.createStatement();
      stmt3= conn.createStatement();

      
      String sql;
      String sql2;
      String sql3;
      sql = "SELECT * from film";
      ResultSet rs = stmt.executeQuery(sql);
     
      
      

      //STEP 5: Extract data from result set
      while(rs.next())
      {
         //Retrieve by column name
         String first = rs.getString("title");
         int film_id = rs.getInt("film_id");        
        
         System.out.println("Title: " + first);
    	 
         sql2 = "SELECT * FROM film_actor WHERE film_id = " + film_id;
    	 ResultSet rs2 = stmt2.executeQuery(sql2);
         while(rs2.next()){
        	 int actor_id = rs3.getInt("actor_id");
         	 
        	 sql3 = "SELECT * FROM actor WHERE actor_id = " + actor_id;
             ResultSet rs3 = stmt3.executeQuery(sql3);
         }
         
         
         String firstnm = "";
         String lastnm="";
         if(rs3.next())
         {
        	 firstnm = rs3.getString("first_name");
        	 lastnm = rs3.getString("last_name");
         }
        	 System.out.println("film_id: " + film_id + "actor_id: " + actor_id);
         
         rs2.close();
      }
      rs.close();
      stmt.close();
      conn.close();
   }
   catch(SQLException se2){
	   se2.printStackTrace();
   }
   
  
   }
   
   
}