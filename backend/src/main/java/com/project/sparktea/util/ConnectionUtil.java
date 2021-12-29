package com.project.sparktea.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

//import org.apache.log4j.Logger;

public class ConnectionUtil {
	private static final Logger loggy = Logger.getLogger(ConnectionUtil.class);
	
	
	//CONNECT TO THE DATABASE BY USING URL, USERNAME, PASSWORD
	private static final String url = "jdbc:postgresql://javareactdb.cepklf5wvuz3.us-east-2.rds.amazonaws.com:5432/sparkteadb";
	private static final String username = "social";
	private static final String password = "react";
	
	/**
	 * Driver manager is a service used for managing a set of JDBC drivers.
	 * It will attempt to establish a connect to the database by using the given 
	 * database URL, username, and password.
	 *
	 */
	public static Connection getConnection() throws SQLException{
		loggy.info("Connection established to connect to the Database.");
		return DriverManager.getConnection(url, username, password);
	} 

}
