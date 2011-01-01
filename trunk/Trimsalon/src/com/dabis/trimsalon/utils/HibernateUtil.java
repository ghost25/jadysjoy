/**
 * Copyright(c) Arrow Software, 2010
 */

package com.dabis.trimsalon.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Settings;
import org.hibernate.connection.ConnectionProvider;


/**
 * @author Tom
 *
 */
public class HibernateUtil {
	
	private static String db = "";
    private static SessionFactory sessionFactory;
    
    private HibernateUtil() { }
    
	static {
	}

	public static SessionFactory getInstance() {
		return sessionFactory;
	}

	/**
	 * Sets the environment.
	 */
	public static void setDB(String environment) { 
		db = environment; 
		if( db.equalsIgnoreCase("TEST") )
			sessionFactory = new Configuration().configure("test-hibernate.cfg.xml").buildSessionFactory();
		else
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	/**
	 * Opens a session and will not bind it to a session context
	 * @return the session
	 */
	public Session openSession() {
		return sessionFactory.openSession();
	}

	/**
	* Returns a session from the session context. If there is no session in the context
	* it opens a session, stores it in the context and returns it.
	* This factory is intended to be used with a hibernate.cfg.xml
	* including the following property 
	* <property name="current_session_context_class">thread</property>
	* This would return the current open session or if this does not exist, 
	* will create a new session
	* 
	* @return the session
	*/
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	* closes the session factory
	*/
	public static void close(){
		if (sessionFactory != null)
			sessionFactory.close();
		sessionFactory = null;
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
