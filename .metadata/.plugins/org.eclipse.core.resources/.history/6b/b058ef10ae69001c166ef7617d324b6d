package com.project.sparktea.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Component;

import com.project.sparktea.model.MessageData;
import com.project.sparktea.util.HibernateUtil;

@Component
public class MessageDataDAO {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	private static final Logger logger = Logger.getLogger(MessageDataDAO.class);

	public List<MessageData> getAllMessages() {
		logger.info("Extracting List of Messages");
		if (sessionFactory == null) {
			try {
				// Creating registry
				registry = new StandardServiceRegistryBuilder().configure().build();
				// create metadata sources
				MetadataSources sources = new MetadataSources(registry);
				// create metadata
				Metadata metadata = sources.getMetadataBuilder().build();
				// create session Factory
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			} catch (Exception e) {
				e.printStackTrace();
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}

		}
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<MessageData> query = builder.createQuery(MessageData.class);
		Root<MessageData> root =query.from(MessageData.class);
		query.select(root);
		List<MessageData> messages = session.createQuery(query).getResultList();
		transaction.commit();
	
		
		return messages;

	}
}
