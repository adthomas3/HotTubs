package edu.bsu.cs436.htdb;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class Main {

	 public static void main (String args [])
		       throws SQLException, IOException
		  {
		    // Load the Oracle JDBC driver
		    DriverManager.registerDriver(new oracle.jdbc.OracleDriver());

		    
		    String serverName = "csor6.bsu.edu";
		    String portNumber = "1521";
		    String sid = "or6db";
		    String url ="jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
		    
		    Connection conn =
		    	      DriverManager.getConnection (url,
		    	           "Mbennett", "5599");
		    
		    
		    
		    System.out.println ("Oracle or6db is connected.");

		    // Create a statement
		    Statement stmt = conn.createStatement ();

		    // Do the SQL 
		    ResultSet rset = stmt.executeQuery ("select sysdate from dual");
		  
		    System.out.println("System time is: ");
		    while (rset.next ())
		      System.out.println (rset.getString (1));

		    System.out.println ("Your JDBC installation is correct.");

		    // close the resultSet
		    rset.close();

		    // Close the statement
		    stmt.close();

		    // Close the connection
		    conn.close();
		  }


}
