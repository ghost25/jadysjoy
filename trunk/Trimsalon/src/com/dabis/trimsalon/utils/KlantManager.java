/**
 * 
 */
package com.dabis.trimsalon.utils;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dabis.trimsalon.beans.Klant;

/**
 * @author rdaalman
 *
 */
public class KlantManager {

public static Logger log = Logger.getLogger(KlantManager.class);

	@SuppressWarnings("unused")
	private void Add(Klant klant) throws HibernateException {
	    Transaction tx = null;
	    Session session = HibernateUtil.getCurrentSession();
	    try {
	    	tx = session.beginTransaction();
	    	session.save(klant);
	    	tx.commit();
	    } catch (RuntimeException e) {
	    	if (tx != null && tx.isActive()) {
		        try {
		        	// Second try catch as the rollback could fail as well
		        	tx.rollback();
		        } catch (HibernateException e1) {
		        	log.debug("Error rolling back transaction");
		        }
		        // throw again the first exception
		        throw e;
	    	}
	    }
	}
	
	@SuppressWarnings("unused")
	private void Update(Klant klant) throws HibernateException {
	    Transaction tx = null;
	    Session session = HibernateUtil.getCurrentSession();
	    try {
	    	tx = session.beginTransaction();
	    	session.update(klant);
	    	tx.commit();
	    } catch (RuntimeException e) {
	    	if (tx != null && tx.isActive()) {
		        try {
		        	// Second try catch as the rollback could fail as well
		        	tx.rollback();
		        } catch (HibernateException e1) {
		        	log.debug("Error rolling back transaction");
		        }
		        // throw again the first exception
		        throw e;
	    	}
	    }
	}
	
	@SuppressWarnings("unused")
	private void Delete(Klant klant) throws HibernateException {
	    Transaction tx = null;
	    Session session = HibernateUtil.getCurrentSession();
	    try {
	    	tx = session.beginTransaction();
	    	session.delete(klant);
	    	tx.commit();
	    } catch (RuntimeException e) {
	    	if (tx != null && tx.isActive()) {
		        try {
		        	// Second try catch as the rollback could fail as well
		        	tx.rollback();
		        } catch (HibernateException e1) {
		        	log.debug("Error rolling back transaction");
		        }
		        // throw again the first exception
		        throw e;
	    	}
	    }
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	private <T> List<T> GetAll(String query) throws HibernateException {
		List<T> list = null;
	    Transaction tx = null;
	    Session session = HibernateUtil.getCurrentSession();
	    try {
	    	tx = session.beginTransaction();
			list = (List<T>) session.createQuery(query).list();
	    	tx.commit();
	    } catch (RuntimeException e) {
	    	if (tx != null && tx.isActive()) {
		        try {
		        	// Second try catch as the rollback could fail as well
		        	tx.rollback();
		        } catch (HibernateException e1) {
		        	log.debug("Error rolling back transaction");
		        }
		        // throw again the first exception
		        throw e;
	    	}
	    }
		return list;
	}
	
}
