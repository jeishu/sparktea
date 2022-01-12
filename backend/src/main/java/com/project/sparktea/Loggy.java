package com.project.sparktea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Loggy {
	
	public final static Logger logger = LoggerFactory.getLogger(Loggy.class);

	public static void main(String[] args) {

		logger.info("testing");
		
	}

}

	

//	final static Logger loggy = Logger.getLogger(SparkTea.class);
//	
//	public static void info(String message) {
//		loggy.setLevel(Level.ERROR);
//		loggy.info(message);
//
//	}
//	public static void error(Exception e) {
//		loggy.setLevel(Level.ALL);
//		loggy.error(e);
//	}
//
//}
