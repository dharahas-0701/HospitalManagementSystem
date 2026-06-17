package com.hms;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateUtil {

    private static SessionFactory sessionFactory = null;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex.getMessage());
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
