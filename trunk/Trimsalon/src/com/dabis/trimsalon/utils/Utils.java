/**
 * 
 */
package com.dabis.trimsalon.utils;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.collection.PersistentSet;
import org.hibernate.engine.SessionImplementor;

/**
 * @author Tom
 *
 */
public class Utils {
	
	public static <T> PersistentSet emptyPersistentSet(T arg1) {
		Session session = HibernateUtil.getCurrentSession();
		Set<T> set = new HashSet<T>();
		return new PersistentSet((SessionImplementor) session, set);
	}

}
