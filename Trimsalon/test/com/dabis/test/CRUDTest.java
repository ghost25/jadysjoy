/**
 * 
 */
package com.dabis.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dabis.trimsalon.beans.Behandeling;
import com.dabis.trimsalon.beans.Hond;
import com.dabis.trimsalon.beans.Klant;
import com.dabis.trimsalon.beans.Opmerking;
import com.dabis.trimsalon.utils.HibernateUtil;

/**
 * @author Tom
 *
 */
public class CRUDTest {

	final static Logger logger = LoggerFactory.getLogger(CRUDTest.class);
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// Open Hibernate session
		HibernateUtil.setDB("TEST");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// Close the Hibernate session
		HibernateUtil.close();
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
		// Add this Behandeling
		Behandeling behandeling = CreateBehandelingTrimmen();
		Add(behandeling);
		
		// Get all Behandelingen
		List<Behandeling> behandelingen = GetAll("from Behandeling");
		assertNotNull("Add:No Behandelingen found",behandelingen);
		assertEquals("More than one Behandeling found:", 1, behandelingen.size());
		
		// Change the retrieved Behandeling
		behandeling = behandelingen.get(0);
		behandeling.setOmschrijving("Wassen");
		Update(behandeling);
		
		// Get all Behandelingen
		List<Behandeling> behandelingen1 = GetAll("from Behandeling");
		assertNotNull("Change:No Behandelingen found",behandelingen1);
		assertEquals("More than one Behandeling found:", 1, behandelingen1.size());
		assertEquals("Value of Omschrijving:","Wassen",behandelingen1.get(0).getOmschrijving());
		
		// Remove this Behandeling
		Delete(behandelingen1.get(0));
		
		// Get all Behandelingen
		List<Behandeling> behandelingen2 = GetAll("from Behandeling");
		assertNotNull("No Behandelingen found:",behandelingen2);
		assertEquals("There are still Behandelingen found:",0,behandelingen2.size());
		
	}
	@Test
	public void KlantCRUD() {
		Klant klant = CreateKlantDaalman();
		// Add this Klant
		Add(klant);
		
		// Get all Klanten
		List<Klant> klanten = GetAll("from Klant");
		assertNotNull("Add:No Klanten found",klanten);
		assertEquals("More than one Klant found:", 1, klanten.size());
		
		// Change the retrieved Klant
		klant = klanten.get(0);
		klant.setNaam("Pijl");
		Update(klant);
		
		// Get all Klanten
		List<Klant> klanten1 = GetAll("from Klant");
		assertNotNull("Change:No Klanten found",klanten1);
		assertEquals("More than one Klant found:", 1, klanten1.size());
		assertEquals("Value of Naam:","Pijl",klanten1.get(0).getNaam());
		
		// Remove this Klant
		Delete(klanten1.get(0));
		
		// Get all Klanten
		List<Klant> klanten2 = GetAll("from Klant");
		assertNotNull("No Klanten found:",klanten2);
		assertEquals("There are still Klanten found:",0,klanten2.size());
		
	}
	
	@Test
	public void HondCRUD() {
		// Since a Hond belongs to a Klant first add a new Klant
		Klant klant = CreateKlantDaalman();
		Add(klant);
		// Now create a Hond
		Hond hond = CreateHondAiko();
		// Add this Hond. It containes no Klant and no Opmerkingen
		try {
			Add(hond);
		} catch (HibernateException e) {
			// Klant is mandatory, so an error should appear.
			if(! e.getMessage().equalsIgnoreCase("not-null property references a null or transient value: com.dabis.trimsalon.beans.Hond.klant") ) {
				fail("Could not add Hond:"+e.getMessage());
			}
		}
		// Retrieve it again
		klant = (Klant) GetAll("from Klant k where k.naam='Daalman'").get(0);
		hond.setKlant(klant);
		// Now add the Hond again
		try {
			Add(hond);
		} catch (HibernateException e) {
			fail("Could not add Hond:"+e.getMessage());
		}
		// Get all Honden and check if there is just one
		List<Hond> honden = GetAll("from Hond");
		assertNotNull("Add:No Honden found",honden);
		assertEquals("More than one Honden found:", 1, honden.size());
		
		// Change the retrieved Hond
		hond = honden.get(0);
		hond.setNaam("Saartje");
		Update(hond);
		
		// Get all Honden and check if its still one with Naam="Saartje"
		List<Hond> honden1 = GetAll("from Hond");
		assertNotNull("Change:No Honden found",honden1);
		assertEquals("More than one Hond found:", 1, honden1.size());
		assertEquals("Value of Naam:","Saartje",honden1.get(0).getNaam());
		
		//Now add two Opmerkingen
		Opmerking opm1 = new Opmerking();
		opm1.setDatum(new Date());
		opm1.setAdvies("Twee keer wassen");
		opm1.setGedrag("Is snapperig");
		opm1.setMedischeKenmerken("Heeft staar in beide ogen");
		Add(opm1);
		Opmerking opm2 = new Opmerking();
		opm2.setDatum(new Date());
		opm2.setGedrag("Vertoont vlucht gedrag");
		Add(opm2);
		// and add them to this Hond
		hond.addOpmerking(opm1);
		hond.addOpmerking(opm2);
		// and save the hond again;
		Update(hond);
		// Check if all is stored
		// Get all Honden and check if its still one with Naam="Saartje"
		List<Hond> honden2 = GetAll("from Hond");
		assertNotNull("Change:No Honden found",honden2);
		assertEquals("More than one Hond found:", 1, honden2.size());
		assertEquals("Value of Naam:","Saartje",honden2.get(0).getNaam());
		assertNotNull("There are no Opmerkingen:", hond.getOpmerkingen());
		assertEquals("Opmerkingen:",2,hond.getOpmerkingen().size());
		
		// Remove this Hond
		Delete(honden1.get(0));
		
		// Get all Honden
		List<Hond> honden3 = GetAll("from Hond");
		assertNotNull("No Honden found:",honden3);
		assertEquals("There are still Honden found:",0,honden3.size());
	}
	//
	//Supporting methods
	//
	private void Add(Object object) throws HibernateException {
	    Transaction tx = null;
	    Session session = HibernateUtil.getInstance().getCurrentSession();
	    try {
	    	tx = session.beginTransaction();
	    	session.save(object);
	    	tx.commit();
	    } catch (RuntimeException e) {
	    	if (tx != null && tx.isActive()) {
		        try {
		        	// Second try catch as the rollback could fail as well
		        	tx.rollback();
		        } catch (HibernateException e1) {
		        	logger.debug("Error rolling back transaction");
		        }
		        // throw again the first exception
		        throw e;
	    	}
	    }
	}
	
	private void Update(Object object) throws HibernateException {
	    Transaction tx = null;
	    Session session = HibernateUtil.getInstance().getCurrentSession();
	    try {
	    	tx = session.beginTransaction();
	    	session.update(object);
	    	tx.commit();
	    } catch (RuntimeException e) {
	    	if (tx != null && tx.isActive()) {
		        try {
		        	// Second try catch as the rollback could fail as well
		        	tx.rollback();
		        } catch (HibernateException e1) {
		        	logger.debug("Error rolling back transaction");
		        }
		        // throw again the first exception
		        throw e;
	    	}
	    }
	}
	
	private void Delete(Object object) throws HibernateException {
	    Transaction tx = null;
	    Session session = HibernateUtil.getInstance().getCurrentSession();
	    try {
	    	tx = session.beginTransaction();
	    	session.delete(object);
	    	tx.commit();
	    } catch (RuntimeException e) {
	    	if (tx != null && tx.isActive()) {
		        try {
		        	// Second try catch as the rollback could fail as well
		        	tx.rollback();
		        } catch (HibernateException e1) {
		        	logger.debug("Error rolling back transaction");
		        }
		        // throw again the first exception
		        throw e;
	    	}
	    }
	}
	
	@SuppressWarnings("unchecked")
	private <T> List<T> GetAll(String query) throws HibernateException {
		List<T> list = null;
	    Transaction tx = null;
	    Session session = HibernateUtil.getInstance().getCurrentSession();
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
		        	logger.debug("Error rolling back transaction");
		        }
		        // throw again the first exception
		        throw e;
	    	}
	    }
		return list;
	}
	
	private Behandeling CreateBehandelingTrimmen() {
		Behandeling behandeling = new Behandeling();
		behandeling.setOmschrijving("Trimmen");
		behandeling.setRas("Terrier");
		behandeling.setBtw(19.0);
		behandeling.setPrijsExbtw(40.0);
		return behandeling;
	}
	
	private Behandeling CreateBehandelingWassen() {
		Behandeling behandeling = new Behandeling();
		behandeling.setOmschrijving("Wassen");
		behandeling.setRas("Terrier");
		behandeling.setBtw(19.0);
		behandeling.setPrijsExbtw(7.5);
		return behandeling;
	}
	
	private Klant CreateKlantDaalman() {
		Klant klant = new Klant();
		klant.setNaam("Daalman");
		klant.setAdres("Molenstraat");
		klant.setHuisnummer("207");
		klant.setPostcode("5343XE");
		klant.setWoonplaats("Oss");
		klant.setMobiel("0647886423");
		try {
			klant.setInschrijfdatum(new SimpleDateFormat("dd-MM-yyyy").parse("13-09-2010"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		klant.setOpmerkingen("hele aardige mensen, maar ze betalen laat !");
		return klant;
	}
	
	private Klant CreateKlantPijl() {
		Klant klant = new Klant();
		klant.setNaam("Pijl");
		klant.setAdres("Jagerspad");
		klant.setHuisnummer("10");
		klant.setPostcode("5342CB");
		klant.setWoonplaats("Oss");
		klant.setTelefoon("0412630434");
		klant.setMobiel("0646615266");
		try {
			klant.setInschrijfdatum(new SimpleDateFormat("dd-MM-yyyy").parse("25-12-2010"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return klant;
	}
	
	private Hond CreateHondAiko() {
		Hond hond = new Hond();
		hond.setNaam("Aiko");
		hond.setRas("Cairn Terrier");
		hond.setKleur("Donker Grijs");
		try {
			hond.setGeboortedatum(new SimpleDateFormat("dd-MM-yyyy").parse("03-03-2000"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hond.setGecastreerd(true);
		hond.setReu(true);
		return hond;
	}
	
	private Hond CreateHondJudy() {
		Hond hond = new Hond();
		hond.setNaam("Judy");
		hond.setRas("Labrador");
		hond.setKleur("Donker Bruin");
		try {
			hond.setGeboortedatum(new SimpleDateFormat("dd-MM-yyyy").parse("26-04-2005"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hond.setGecastreerd(false);
		hond.setReu(false);
		return hond;
	}
}
