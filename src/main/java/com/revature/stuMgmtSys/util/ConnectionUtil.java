package com.revature.stuMgmtSys.util;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/* A singleton class is a class in Java that limits the number of objects of the declared class to one.
 * A private constructor in Java ensures that only one object is created at a time. 
 * It restricts the class instances within the declared class 
 * 		so that no class instance can be created outside the declared class.
 * You can use the singleton class in networking and database connectivity concepts.
 * 
 * Here, ConnectionUtil is the Singleton Class
 * */
public class ConnectionUtil {
/*
 * Singleton Pattern
 * - It allows me to create an only one object and use it through out by app
 * - How
 * 		- Make that object privately + static
 *      - private constructor
 *      - only create when its null ( for the first time)
 * 
 */
	
	private static  Connection con = null;
	
/*
 * If a constructor is declared as private, 
 * then its objects are only accessible from within the declared class. 
 * You cannot access its objects from outside the constructor class.   
 * 	
 * The private constructor in Java is used to create a singleton class
 */
	private ConnectionUtil() {
		
	}
	
	public static Connection getConnection() throws SQLException, FileNotFoundException, IOException {
		/* I kept my url, username, password in a file - application.properites
		 * now i goona access that properties file and get the details about url, username and password
		 * 
		 */
		
		Properties prop = new Properties();
		
		prop.load(new FileReader("C:\\Users\\PorkodiVenkatesh\\eclipse-workspace\\Maven\\stuMgmtSys\\src\\main\\resources\\application.properties"));
		
		String url = prop.getProperty("url");
		String username= prop.getProperty("username");
		String password= prop.getProperty("password");
		
		
		
		
		
		if (con == null){
		con = DriverManager.getConnection(url, username, password);
	
		}
		
		System.out.println("connection object hashcode -> " + con.hashCode());
		return con;
		
	}


}
