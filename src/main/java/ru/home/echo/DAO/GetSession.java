package ru.home.echo.DAO;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


import java.util.Locale;

public class GetSession {

    private static SessionFactory sessionFactory=createSessionFactory();
    private static ServiceRegistry serviceRegistry;


    public static SessionFactory createSessionFactory() {
        try {

            Locale.setDefault(Locale.ENGLISH);
            Configuration configuration = new Configuration();
            configuration.configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        }

        catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }

    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
