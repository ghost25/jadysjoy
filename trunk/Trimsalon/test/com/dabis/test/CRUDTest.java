/**
 * 
 */
package com.dabis.test;


import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dabis.trimsalon.beans.Behandeling;
import com.dabis.trimsalon.utils.HibernateUtil;

/**
 * @author Tom
 *
 */
public class CRUDTest {

	private static SessionFactory sessionFactory = null;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// Open Hibernate session
		sessionFactory = HibernateUtil.getSessionFactory("TEST");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// Close the Hibernate session
		sessionFactory.close();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void BehandelingCRUD() {
		Behandeling behandeling = new Behandeling();
		behandeling.setOmschrijving("Trimmen");
		behandeling.setRas("Terrier");
		behandeling.setBtw(19.0);
		behandeling.setPrijsExbtw(40.0);
		// Add this behandeling
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(behandeling);
		session.getTransaction().commit();
		
		// Get all Behandelingen
		session = sessionFactory.openSession();
		session.beginTransaction();
		List<Behandeling> behandelingen = (List<Behandeling>) session.createQuery("from Behandeling").list();
		session.getTransaction().commit();
		assertEquals("More than one Behandeling found:", 1, behandelingen.size());
	}
}
