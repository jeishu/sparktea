package com.project.sparktea.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

//import org.apache.log4j.Logger;

public class ConnectionUtil {
	private static final Logger loggy = Logger.getLogger(ConnectionUtil.class);
	
	
	public static Connection getConnection() throws Exception {
		
		
		Properties props = new Properties();
		props.load(new FileInputStream("src/main/resources/Connection.properties"));
		//upload a properties file and connect to SWL 
		
		String url = (String) props.getProperty("url");
		String username = (String) props.getProperty("username");
		String password = (String) props.getProperty("password");
		
		return DriverManager.getConnection(url, username, password); //return a connection
}


	
	
	
	/*public static void main(String[] args) throws Exception {
		

	Connection conn = getConnection();
		System.out.println("yay");
	}
*/

}