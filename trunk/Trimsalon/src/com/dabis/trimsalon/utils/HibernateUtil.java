/**
 * Copyright(c) Arrow Software, 2010
 */

package com.dabis.trimsalon.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Settings;
import org.hibernate.connection.ConnectionProvider;


/**
 * @author Tom
 *
 */
public class HibernateUtil {
	
    private static SessionFactory sessionFactory;
    private static SessionFactory testSessionFactory;

    public static SessionFactory getSessionFactory(String db) {
    	if( db.equalsIgnoreCase("TEST") ) {
    		if( testSessionFactory == null ) {
                try {
                    // Create the SessionFactory from test-hibernate.cfg.xml
                    testSessionFactory = new Configuration().configure("test-hibernate.cfg.xml").buildSessionFactory();
                } catch (Throwable ex) {
                    // Make sure you log the exception, as it might be swallowed
                    System.err.println("Initial SessionFactory creation failed." + ex);
                    throw new ExceptionInInitializerError(ex);
                }
    		}
    		return testSessionFactory;
    	} else {
    		if( sessionFactory == null ) {
    	        try {
    	            // Create the SessionFactory from hibernate.cfg.xml
    	            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	        } catch (Throwable ex) {
    	            // Make sure you log the exception, as it might be swallowed
    	            System.err.println("Initial SessionFactory creation failed." + ex);
    	            throw new ExceptionInInitializerError(ex);
    	        }

    		}
    		return sessionFactory;
    	}
    }

    public static Connection getDBConnection(String db) {
    	Connection con = null;
    	
    	Configuration cf = new Configuration();
    	if( db.equalsIgnoreCase("TEST") )
    		cf.configure("test-hibernate.cfg.xml");
    	else
    		cf.configure("hibernate.cfg.xml");
    	Settings settings = cf.buildSettings();
    	ConnectionProvider conprov = settings.getConnectionProvider();
    	try {
			con = conprov.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	return con;
    }
}
