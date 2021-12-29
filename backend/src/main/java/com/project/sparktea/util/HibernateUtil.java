package com.project.sparktea.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	 private static SessionFactory sessionFactory;
	    public static SessionFactory getSessionFactory() {
	        if (sessionFactory == null) {
	            try {
	                Configuration configuration = new Configuration();
	                // Hibernate settings equivalent to hibernate.cfg.xml's properties
	                Properties settings = new Properties();
	                settings.put(Environment.DRIVER, "org.postgresql.Driver");
	                settings.put(Environment.URL, "jdbc:postgresql://javareactdb.cepklf5wvuz3.us-east-2.rds.amazonaws.com:5432/sparkteadb");
	                settings.put(Environment.USER, "social");
	                settings.put(Environment.PASS, "react");
	                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
	                settings.put(Environment.SHOW_SQL, "true");
	               settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
	                settings.put(Environment.HBM2DDL_AUTO, "update");
	                configuration.setProperties(settings);
					
	               /*
	                configuration.addAnnotatedClass(com.p1.model.Reimbursement.class);
	                configuration.addAnnotatedClass(com.p1.model.ReimbursementStatus.class);
	                configuration.addAnnotatedClass(com.p1.model.ReimbursementType.class);
	                configuration.addAnnotatedClass(com.p1.model.User.class);
	                configuration.addAnnotatedClass(com.p1.model.UserRole.class);
	                */
	                
	                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	                    .applySettings(configuration.getProperties()).build();
	                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return sessionFactory;
	    }
	}