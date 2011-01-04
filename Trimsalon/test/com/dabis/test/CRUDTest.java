/**
 * 
 */
package com.dabis.test;


import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.collection.PersistentSet;
import org.hibernate.engine.SessionImplementor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dabis.trimsalon.beans.*;
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
		// Get them again from database
		
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
		assertNotNull("There are no Opmerkingen:", honden2.get(0).getOpmerkingen());
		assertEquals("Opmerkingen:",2,honden2.get(0).getOpmerkingen().size());
		
		// Remove this Hond
		Delete(honden2.get(0));
		// Remove also Klant
		Delete(honden2.get(0).getKlant());
		
		// Get all Honden
		List<Hond> honden3 = GetAll("from Hond");
		assertNotNull("No Honden found:",honden3);
		assertEquals("There are still Honden found:",0,honden3.size());
		// See if the Opmerkingen are also gone
		List<Opmerking> opmerkingen = GetAll("from Opmerking");
		assertNotNull("No Opmerkingen found:",opmerkingen);
		assertEquals("There are still Opmerkingen found:",0,opmerkingen.size());
		// Get all Klanten. They should also be gone.
		List<Klant> klanten = GetAll("from Klant");
		assertNotNull("No Klanten found:",klanten);
		assertEquals("There are still Klanten found:",0,klanten.size());
		
	}
	
	@Test
	public void AfspraakCRUD() {
		// Since an Afspraak belongs to a Hond first add a new Hond
		// Since a Hond belongs to a Klant first add a new Klant
		Klant klant = CreateKlantPijl();
		Add(klant);
		// Now create a Hond
		Hond hond = CreateHondAiko();
		// Retrieve the Klant again and add it to the Hond
		klant = (Klant) GetAll("from Klant k where k.naam='Pijl'").get(0);
		hond.setKlant(klant);
		Add(hond);
		// Now create the Afspraak
		Afspraak afspraak = CreateAfspraak1();
		try {
			Add(afspraak);
		} catch (HibernateException e) {
			// Hond is mandatory, so an error should appear.
			if(! e.getMessage().equalsIgnoreCase("not-null property references a null or transient value: com.dabis.trimsalon.beans.Afspraak.hond") ) {
				fail("Could not add Afspraak:"+e.getMessage());
			}
		}
		
		// Now add Hond and save afspraak
		afspraak.setHond(hond);
		Add(afspraak);
		
		// Get all Afspraken and check if there is just one
		List<Afspraak> afspraken = GetAll("from Afspraak");
		assertNotNull("Add:No Afspraken found",afspraken);
		assertEquals("More than one Afspraak found:", 1, afspraken.size());
		
		// Change the retrieved Hond
		afspraak = afspraken.get(0);
		afspraak.setOphalen(false);
		Update(afspraak);
		
		// Get all afspraken and check if its still one with Ophalen=false
		List<Afspraak> afspraken1 = GetAll("from Afspraak");
		assertNotNull("Change:No afspraken found",afspraken1);
		assertEquals("More than one Afspraak found:", 1, afspraken1.size());
		assertFalse("Value of Ophalen:",afspraken1.get(0).isOphalen());
		
		//Now add two Behandelingen
		Behandeling beh1 = CreateBehandelingTrimmen();
		Add(beh1);
		Behandeling beh2 = CreateBehandelingWassen();
		Add(beh2);
		// and add them to this Afspraak
		Session session = HibernateUtil.getInstance().getCurrentSession();
		Set<Behandeling> set = new HashSet<Behandeling>();
		afspraak.setBehandelingen(new PersistentSet((SessionImplementor) session, set));
		afspraak.addBehandeling(beh1);
		afspraak.addBehandeling(beh2);
		// and save the afspraak again;
		Update(afspraak);
		// Check if all is stored
		// Get all afspraken and check if its still one
		List<Afspraak> afspraken2 = GetAll("from Afspraak");
		assertNotNull("Change:No Afspraken found",afspraken2);
		assertEquals("More than one Afspraak found:", 1, afspraken2.size());
		assertNotNull("There are no Behandelingen:", afspraken2.get(0).getBehandelingen());
		assertEquals("Behandelingen:",2,afspraken2.get(0).getBehandelingen().size());
		
		// Remove this Afspraak
		Delete(afspraken2.get(0));
		
		// Get all Afspraken and check if they are gone
		List<Afspraak> afspraken3 = GetAll("from Afspraak");
		assertNotNull("No Afspraken found:",afspraken3);
		assertEquals("There are still Afspraken found:",0,afspraken3.size());

		// See if the Behandelingen are still there
		List<Behandeling> behandelingen = GetAll("from Behandeling");
		assertNotNull("There are no Behandelingen found:",behandelingen);
		assertEquals("Behandelingen:",2,behandelingen.size());
		
		// Remove Hond and Klant
		Delete(afspraken2.get(0).getHond());
		Delete(afspraken2.get(0).getHond().getKlant());
		// Remove both behandelingen
		for (Behandeling behandeling : behandelingen) {
			Delete(behandeling);
		}
		// See if the Behandelingen are gone
		List<Behandeling> behandelingen1 = GetAll("from Behandeling");
		assertNotNull("There are no Behandelingen found:",behandelingen1);
		assertEquals("There are still Behandelingen:",0,behandelingen1.size());
		// See if the Hond is gone
		List<Behandeling> honden = GetAll("from Hond");
		assertNotNull("There are no honden found:",honden);
		assertEquals("There are still honden:",0,honden.size());
		// See if the Klant is gone
		List<Behandeling> klanten = GetAll("from Behandeling");
		assertNotNull("There are no klanten found:",klanten);
		assertEquals("There are still klanten:",0,klanten.size());
			
	}
	
	@Test
	public void BoekhoudingAndFactuurCRUD() {
		//Add two Behandelingen
		Behandeling beh1 = CreateBehandelingTrimmen();
		Add(beh1);
		Behandeling beh2 = CreateBehandelingWassen();
		Add(beh2);
		// Make  afspraak
		Klant klant1 = CreateKlantPijl();
		Add(klant1);
		// Now create a Hond
		Hond hond1 = CreateHondAiko();
		// Retrieve the Klant again and add it to the Hond
		klant1 = (Klant) GetAll("from Klant k where k.naam='Pijl'").get(0);
		hond1.setKlant(klant1);
		Add(hond1);
		// Now create the Afspraak
		Afspraak afspraak1 = CreateAfspraak1();
		afspraak1.setHond(hond1);
		// and add two behandelingen to this Afspraak
		Session session = HibernateUtil.getInstance().getCurrentSession();
		Set<Behandeling> set = new HashSet<Behandeling>();
		afspraak1.setBehandelingen(new PersistentSet((SessionImplementor) session, set));
		afspraak1.addBehandeling(beh1);
		afspraak1.addBehandeling(beh2);
		Add(afspraak1);
		// First insertion into Boekhouding
		// The Afspraak contained two Behandelingen, so two Boekhoud records should be created
		// Use a Utility-method to create the items from an Afspraak
		for( Boekhouding item : makeBoekhoudingItems(afspraak1) ) {
			Add(item);
		}
		// Check if there are two items created
		List<Boekhouding> boekhouding = GetAll("from Boekhouding");
		assertNotNull("No Afspraken found:",boekhouding);
		assertEquals("Afspraken:",2,boekhouding.size());
		
		// Now create the Factuur 
		Factuur factuur = new Factuur();
		factuur.setFactuurdatum(new Date());
		long factuurnummer = 1;
		factuur.setFactuurnummer(factuurnummer+"");
		for( Boekhouding item : boekhouding ) {
			factuur.addFactuurregel(item);
		}
		Add(factuur);
		// Check if one factuur with two regels is created
		List<Factuur> facturen = GetAll("from Factuur");
		assertNotNull("No Facturen found:",facturen);
		assertEquals("Facturen:",1,facturen.size());
		assertEquals("Factuurregels:", 2, facturen.get(0).getFactuurregels().size());
		
		// Now remove Factuur
		Delete(facturen.get(0));
		// Check if factuur has gone
		List<Factuur> facturen1 = GetAll("from Factuur");
		assertNotNull("No Facturen found:",facturen1);
		assertEquals("Facturen:",0,facturen1.size());
		// Check if Boekhouditems are still there
		List<Boekhouding> boekhouding1 = GetAll("from Boekhouding");
		assertNotNull("No Boekhouditems found:",boekhouding1);
		assertEquals("Boekhouditems:",2,boekhouding1.size());
		
		// Now cleanup
		for( Boekhouding item : boekhouding ) {
			Delete(item);
		}
		Delete(afspraak1);
		Delete(hond1);
		Delete(klant1);
		Delete(beh1);
		Delete(beh2);
		// See if afspraken are gone
		List<Afspraak> afspraken = GetAll("from Afspraak");
		assertNotNull("No Afspraken found:",afspraken);
		assertEquals("There are still Afspraken found:",0,afspraken.size());
		// See if the Behandelingen are gone
		List<Behandeling> behandelingen = GetAll("from Behandeling");
		assertNotNull("There are no Behandelingen found:",behandelingen);
		assertEquals("There are still Behandelingen:",0,behandelingen.size());
		// See if the Hond is gone
		List<Behandeling> honden = GetAll("from Hond");
		assertNotNull("There are no honden found:",honden);
		assertEquals("There are still honden:",0,honden.size());
		// See if the Klant is gone
		List<Behandeling> klanten = GetAll("from Behandeling");
		assertNotNull("There are no klanten found:",klanten);
		assertEquals("There are still klanten:",0,klanten.size());
	}
	
	//====================================================================================
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
	
	private Afspraak CreateAfspraak1() {
		Afspraak afspraak = new Afspraak();
		Date d = new Date();
		try {
			d = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse("10-01-2011 10:30");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Calendar begintijd = Calendar.getInstance();
		begintijd.setTime(d);
		afspraak.setBegintijd(begintijd);
		try {
			d = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse("10-01-2011 12:30");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Calendar eindtijd = Calendar.getInstance();
		eindtijd.setTime(d);
		afspraak.setEindtijd(eindtijd);
		afspraak.setOphalen(true);
		afspraak.setOpmerkingen("Mogelijk 5 minuten later.");
		return afspraak;
	}
	
	private Afspraak CreateAfspraak2() {
		Afspraak afspraak = new Afspraak();
		Date d = new Date();
		try {
			d = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse("11-01-2011 14:30");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Calendar begintijd = Calendar.getInstance();
		begintijd.setTime(d);
		afspraak.setBegintijd(begintijd);
		try {
			d = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse("11-01-2011 16:30");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Calendar eindtijd = Calendar.getInstance();
		eindtijd.setTime(d);
		afspraak.setEindtijd(eindtijd);
		afspraak.setOphalen(false);
		afspraak.setOpmerkingen("Bellen wanneer klaar.");
		return afspraak;
	}
	
	@SuppressWarnings("unchecked")
	private List<Boekhouding> makeBoekhoudingItems(Afspraak afspraak) {
		List<Boekhouding> items = new ArrayList<Boekhouding>();
		Date d = new Date();
		Calendar boekingsdatum = Calendar.getInstance();
		boekingsdatum.setTime(d);
		for ( Iterator<Behandeling> b = afspraak.getBehandelingen().iterator(); b.hasNext(); ) {
			Behandeling beh = b.next();
			Boekhouding item = new Boekhouding();
			item.setBoekingsdatum(boekingsdatum);
			item.setAfspraak(afspraak);
			item.setBtw(beh.getBtw());
			item.setPrijsExbtw(beh.getPrijsExbtw());
			items.add(item);
		}
		return items;
	}
}
