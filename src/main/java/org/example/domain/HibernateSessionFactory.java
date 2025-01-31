package org.example.domain;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateSessionFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateSessionFactory.class);
    private static SessionFactory sessionFactory;

    private static SessionFactory getSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure("application.cfg.xml");
        configuration.addAnnotatedClass(org.example.domain.Book.class);
        LOGGER.info("hibernate configuration declared");
        ServiceRegistry serviceRegistry = new
                StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        LOGGER.info("Service registry is created");
        return configuration.buildSessionFactory(serviceRegistry);
    }
    public static SessionFactory getHibernateSessionFactory(){
        return sessionFactory = (sessionFactory == null)? getSessionFactory() : sessionFactory;
    }
}
