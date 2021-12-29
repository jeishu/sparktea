package com.project.sparktea;


import java.lang.module.Configuration;
import java.util.Properties;

import org.apache.catalina.Session;

public class HibernateUtil {
	public static StandardServiceRegistry registry;
	private static Session sessionFactory;
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				Properties settings = new Properties();
				settings.put(Environment.DRIVER,  "org.postgresql.Driver");
				settings.put(Environment.URL,"jdbc:postgresql://javareactdb.cpc4dznayajt.us-east-1.rds.amazonaws.com:5432");
				settings.put(Environment.USER, "postgres");
				settings.put(Environment.PASS, "b12345678");
				settings.put(Environment.DIALECT, "orghibernate.dialect.PostgreSQLDialect");
				settings.put(Environment.SHOW_SQL,"true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "update");
				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Reimbursements.class);
				configuration.addAnnotatedClass(Employee.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			}catch(Exception e) {
				e.printStackTrace();
				
				
				
			}
		}
		return sessionFactory;
		
	}
}

