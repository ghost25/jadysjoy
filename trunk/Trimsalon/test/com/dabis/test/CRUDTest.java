/**
 * 
 */
package com.dabis.test;


import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dabis.trimsalon.beans.Afspraak;
import com.dabis.trimsalon.beans.Behandeling;
import com.dabis.trimsalon.beans.Boekhouding;
import com.dabis.trimsalon.beans.Factuur;
import com.dabis.trimsalon.beans.Hond;
import com.dabis.trimsalon.beans.Klant;
import com.dabis.trimsalon.beans.Opmerking;
import com.dabis.trimsalon.services.AfspraakManager;
import com.dabis.trimsalon.services.BehandelingManager;
import com.dabis.trimsalon.services.BoekhoudingManager;
import com.dabis.trimsalon.services.FactuurManager;
import com.dabis.trimsalon.services.HondManager;
import com.dabis.trimsalon.services.KlantManager;
import com.dabis.trimsalon.services.OpmerkingManager;

/**
 * @author Tom
 * @param <T>
 *
 */
public class CRUDTest {

	final static Logger logger = LoggerFactory.getLogger(CRUDTest.class);
	private static ApplicationContext context;
	private static AfspraakManager afspraakManager;
	private static BehandelingManager behandelingManager;
	private static BoekhoudingManager boekhoudingManager;
	private static FactuurManager factuurManager;
	private static HondManager hondManager;
	private static KlantManager klantManager;
	private static OpmerkingManager opmerkingManager;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext("test-applicationContext.xml");
		afspraakManager = (AfspraakManager) context.getBean("afspraakManager");
		behandelingManager = (BehandelingManager) context.getBean("behandelingManager");
		boekhoudingManager = (BoekhoudingManager) context.getBean("boekhoudingManager");
		factuurManager = (FactuurManager) context.getBean("factuurManager");
		hondManager = (HondManager) context.getBean("hondManager");
		klantManager = (KlantManager) context.getBean("klantManager");
		opmerkingManager = (OpmerkingManager) context.getBean("opmerkingManager");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
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
		behandelingManager.createBehandeling(behandeling);
		
		// Get all Behandelingen
		List<Behandeling> behandelingen = behandelingManager.getAllBehandelingen();
		assertNotNull("Add:No Behandelingen found",behandelingen);
		assertEquals("More than one Behandeling found:", 1, behandelingen.size());
		
		// Change the retrieved Behandeling
		behandeling = behandelingen.get(0);
		behandeling.setOmschrijving("Wassen");
		behandelingManager.updateBehandeling(behandeling);
		
		// Get all Behandelingen
		List<Behandeling> behandelingen1 = behandelingManager.getAllBehandelingen();
		assertNotNull("Change:No Behandelingen found",behandelingen1);
		assertEquals("More than one Behandeling found:", 1, behandelingen1.size());
		assertEquals("Value of Omschrijving:","Wassen",behandelingen1.get(0).getOmschrijving());
		
		// Remove this Behandeling
		behandelingManager.deleteBehandeling(behandelingen1.get(0));
		
		// Get all Behandelingen
		List<Behandeling> behandelingen2 =  behandelingManager.getAllBehandelingen();
		assertNotNull("No Behandelingen found:",behandelingen2);
		assertEquals("There are still Behandelingen found:",0,behandelingen2.size());
		
	}
	@Test
	public void KlantCRUD() {
		Klant klant = CreateKlantDaalman();
		// Add this Klant
		klantManager.createKlant(klant);
		
		// Get all Klanten
		List<Klant> klanten = klantManager.getAllKlanten();
		assertNotNull("Add:No Klanten found",klanten);
		assertEquals("More than one Klant found:", 1, klanten.size());
		
		// Change the retrieved Klant
		klant = klanten.get(0);
		klant.setNaam("Pijl");
		klantManager.updateKlant(klant);
		
		// Get all Klanten
		List<Klant> klanten1 = klantManager.getAllKlanten();
		assertNotNull("Change:No Klanten found",klanten1);
		assertEquals("More than one Klant found:", 1, klanten1.size());
		assertEquals("Value of Naam:","Pijl",klanten1.get(0).getNaam());
		
		// Remove this Klant
		klantManager.deleteKlant(klanten1.get(0));
		
		// Get all Klanten
		List<Klant> klanten2 = klantManager.getAllKlanten();
		assertNotNull("No Klanten found:",klanten2);
		assertEquals("There are still Klanten found:",0,klanten2.size());
		
	}
	
	@Test
	public void HondCRUD() {
		// Since a Hond belongs to a Klant first add a new Klant
		Klant klant = CreateKlantDaalman();
		long klantId = klantManager.createKlant(klant);
		assertEquals("No or wrong Klant id:",klant.getId(),klantId);
		// Now create a Hond
		Hond hond = CreateHondAiko();
		// Add this Hond. It containes no Klant and no Opmerkingen
		try {
			hondManager.createHond(hond);
		} catch (Exception e) {
			if( !e.getMessage().equalsIgnoreCase("not-null property references a null or transient value: com.dabis.trimsalon.beans.Hond.klant")) {
				fail(e.getMessage());
			}
		}
		// Retrieve the  klant again
		//klant = klantManager.getKlantById(klantId);
		hond.setKlant(klant);
		// Now create the Hond again
		hondManager.createHond(hond);
		// Get all Honden and check if there is just one
		List<Hond> honden = hondManager.getAllHonden();
		assertNotNull("Add:No Honden found",honden);
		assertEquals("More than one Honden found:", 1, honden.size());
		assertEquals("Daalman", honden.get(0).getKlant().getNaam());
		
		// Change the retrieved Hond
		hond = honden.get(0);
		hond.setNaam("Saartje");
		hondManager.updateHond(hond);
		
		// Get all Honden and check if its still one with Naam="Saartje"
		List<Hond> honden1 = hondManager.getAllHonden();
		assertNotNull("Change:No Honden found",honden1);
		assertEquals("More than one Hond found:", 1, honden1.size());
		assertEquals("Value of Naam:","Saartje",honden1.get(0).getNaam());
		
		//Now add two Opmerkingen
		Opmerking opm1 = new Opmerking();
		Calendar datum = Calendar.getInstance();
		opm1.setDatum(datum);
		opm1.setAdvies("Twee keer wassen");
		opm1.setGedrag("Is snapperig");
		opm1.setMedischeKenmerken("Heeft staar in beide ogen");
		opmerkingManager.createOpmerking(opm1);
		Opmerking opm2 = new Opmerking();
		opm2.setDatum(datum);
		opm2.setGedrag("Vertoont vlucht gedrag");
		opmerkingManager.createOpmerking(opm2);
		// Get them again from database
		
		// and add them to this Hond
		hond.addOpmerking(opm1);
		hond.addOpmerking(opm2);
		// and save the hond again;
		hondManager.updateHond(hond);
		// Check if all is stored
		// Get all Honden and check if its still one with Naam="Saartje"
		List<Hond> honden2 = hondManager.getAllHonden();
		assertNotNull("Change:No Honden found",honden2);
		assertEquals("More than one Hond found:", 1, honden2.size());
		assertEquals("Value of Naam:","Saartje",honden2.get(0).getNaam());
		assertNotNull("There are no Opmerkingen:", honden2.get(0).getOpmerkingen());
		assertEquals("Opmerkingen:",2,honden2.get(0).getOpmerkingen().size());
		
		// Remove this Hond
		hondManager.deleteHond(honden2.get(0));
		// Remove also Klant
		klantManager.deleteKlant(honden2.get(0).getKlant());
		
		// Get all Honden
		List<Hond> honden3 = hondManager.getAllHonden();
		assertNotNull("No Honden found:",honden3);
		assertEquals("There are still Honden found:",0,honden3.size());
		// See if the Opmerkingen are also gone
		List<Opmerking> opmerkingen = opmerkingManager.getAllOpmerkingen();
		assertNotNull("No Opmerkingen found:",opmerkingen);
		assertEquals("There are still Opmerkingen found:",0,opmerkingen.size());
		// Get all Klanten. They should also be gone.
		List<Klant> klanten = klantManager.getAllKlanten();
		assertNotNull("No Klanten found:",klanten);
		assertEquals("There are still Klanten found:",0,klanten.size());
		
	}
	
	@Test
	public void AfspraakCRUD() {
		// Since an Afspraak belongs to a Hond first add a new Hond
		// Since a Hond belongs to a Klant first add a new Klant
		Klant klant = CreateKlantPijl();
		klantManager.createKlant(klant);
		// Now create a Hond
		Hond hond = CreateHondAiko();
		hond.setKlant(klant);
		hondManager.createHond(hond);
		// Now create the Afspraak
		Afspraak afspraak = CreateAfspraak1();
		try {
			afspraakManager.createAfspraak(afspraak);
		} catch (Exception e) {
			if( !e.getMessage().equalsIgnoreCase("not-null property references a null or transient value: com.dabis.trimsalon.beans.Afspraak.hond")) {
				fail(e.getMessage());
			}
		}
		// Now add Hond and save afspraak
		afspraak.setHond(hond);
		afspraakManager.createAfspraak(afspraak);
		
		// Get all Afspraken and check if there is just one
		List<Afspraak> afspraken = afspraakManager.getAllAfspraken();
		assertNotNull("Add:No Afspraken found",afspraken);
		assertEquals("More than one Afspraak found:", 1, afspraken.size());
		
		// Change the retrieved afspraak
		afspraak = afspraken.get(0);
		afspraak.setOphalen(false);
		afspraakManager.updateAfspraak(afspraak);
		
		// Get all afspraken and check if its still one with Ophalen=false
		List<Afspraak> afspraken1 = afspraakManager.getAllAfspraken();
		assertNotNull("Change:No afspraken found",afspraken1);
		assertEquals("More than one Afspraak found:", 1, afspraken1.size());
		assertFalse("Value of Ophalen:",afspraken1.get(0).isOphalen());
		
		//Now add two Behandelingen
		Behandeling beh1 = CreateBehandelingTrimmen();
		behandelingManager.createBehandeling(beh1);
		Behandeling beh2 = CreateBehandelingWassen();
		behandelingManager.createBehandeling(beh2);
		// and add them to this Afspraak
		afspraak.addBehandeling(beh1);
		afspraak.addBehandeling(beh2);
		// and save the afspraak again;
		afspraakManager.updateAfspraak(afspraak);
		// Check if all is stored
		// Get all afspraken and check if its still one
		List<Afspraak> afspraken2 = afspraakManager.getAllAfspraken();
		assertNotNull("Change:No Afspraken found",afspraken2);
		assertEquals("More than one Afspraak found:", 1, afspraken2.size());
		assertNotNull("There are no Behandelingen:", afspraken2.get(0).getBehandelingen());
		assertEquals("Behandelingen:",2,afspraken2.get(0).getBehandelingen().size());
		
		// Get the hond from this Afspraak
		afspraak = afspraken2.get(0);
		hond = hondManager.getHondById(afspraak.getHond().getId());
		
		// Remove this Afspraak
		afspraakManager.deleteAfspraak(afspraak);
		
		// Get all Afspraken and check if they are gone
		List<Afspraak> afspraken3 = afspraakManager.getAllAfspraken();
		assertNotNull("Delete:No Afspraken found",afspraken3);
		assertEquals("There are still Afspraken found:",0,afspraken3.size());

		// See if the Behandelingen are still there
		List<Behandeling> behandelingen = behandelingManager.getAllBehandelingen();
		assertNotNull("There are no Behandelingen found:",behandelingen);
		assertEquals("Behandelingen:",2,behandelingen.size());
		
		// Remove Hond and Klant
		hondManager.deleteHond(hond);
		klantManager.deleteKlant(hond.getKlant());
		// Remove both behandelingen
		for (Behandeling behandeling : behandelingen) {
			behandelingManager.deleteBehandeling(behandeling);
		}
		// See if the Behandelingen are gone
		List<Behandeling> behandelingen1 = behandelingManager.getAllBehandelingen();
		assertNotNull("There are no Behandelingen found:",behandelingen1);
		assertEquals("There are still Behandelingen:",0,behandelingen1.size());
		// See if the Hond is gone
		List<Hond> honden = hondManager.getAllHonden();
		assertNotNull("There are no honden found:",honden);
		assertEquals("There are still honden:",0,honden.size());
		// See if the Klant is gone
		List<Klant> klanten = klantManager.getAllKlanten();
		assertNotNull("There are no klanten found:",klanten);
		assertEquals("There are still klanten:",0,klanten.size());
			
	}
	
	@Test
	public void BoekhoudingAndFactuurCRUD() {
		//Add two Behandelingen
		Behandeling beh1 = CreateBehandelingTrimmen();
		behandelingManager.createBehandeling(beh1);
		Behandeling beh2 = CreateBehandelingWassen();
		behandelingManager.createBehandeling(beh2);
		// Make  afspraak
		Klant klant1 = CreateKlantPijl();
		klantManager.createKlant(klant1);
		// Now create a Hond
		Hond hond1 = CreateHondAiko();
		// Retrieve the Klant again and add it to the Hond
		hond1.setKlant(klant1);
		hondManager.createHond(hond1);
		// Now create the Afspraak
		Afspraak afspraak1 = CreateAfspraak1();
		afspraak1.setHond(hond1);
		// and add two behandelingen to this Afspraak
		afspraak1.addBehandeling(beh1);
		afspraak1.addBehandeling(beh2);
		afspraakManager.createAfspraak(afspraak1);
		// First insertion into Boekhouding
		// The Afspraak contained two Behandelingen, so two Boekhoud records should be created
		// Use a Utility-method to create the items from an Afspraak
		for( Boekhouding item : makeBoekhoudingItems(afspraak1.getId()) ) {
			boekhoudingManager.createBoekhouding(item);
		}
		// Check if there are two items created
		List<Boekhouding> boekhouding = boekhoudingManager.getAllBoekhoudingen();
		assertNotNull("No Afspraken found:",boekhouding);
		assertEquals("Afspraken:",2,boekhouding.size());
		
		// Now create the Factuur 
		Factuur factuur = new Factuur();
		Calendar datum = Calendar.getInstance();
		factuur.setFactuurdatum(datum);
		long factuurnummer = 1;
		factuur.setFactuurnummer(factuurnummer+"");
		for( Boekhouding item : boekhouding ) {
			factuur.addFactuurregel(item);
		}
		factuurManager.createFactuur(factuur);
		// Check if one factuur with two regels is created
		List<Factuur> facturen = factuurManager.getAllFacturen();
		assertNotNull("No Facturen found:",facturen);
		assertEquals("Facturen:",1,facturen.size());
		assertEquals("Factuurregels:", 2, facturen.get(0).getFactuurregels().size());
		
		// Now remove Factuur
		factuurManager.deleteFactuur(facturen.get(0));
		// Check if factuur has gone
		List<Factuur> facturen1 = factuurManager.getAllFacturen();
		assertNotNull("No Facturen found:",facturen1);
		assertEquals("Facturen:",0,facturen1.size());
		// Check if Boekhouditems are still there
		List<Boekhouding> boekhouding1 = boekhoudingManager.getAllBoekhoudingen();
		assertNotNull("No Boekhouditems found:",boekhouding1);
		assertEquals("Boekhouditems:",2,boekhouding1.size());
		
		// Now cleanup
		for( Boekhouding item : boekhouding1 ) {
			boekhoudingManager.deleteBoekhouding(item);
		}
		afspraakManager.deleteAfspraak(afspraak1);
		hondManager.deleteHond(hond1);
		klantManager.deleteKlant(klant1);
		behandelingManager.deleteBehandeling(beh1);
		behandelingManager.deleteBehandeling(beh2);
		// See if afspraken are gone
		List<Afspraak> afspraken = afspraakManager.getAllAfspraken();
		assertNotNull("No Afspraken found:",afspraken);
		assertEquals("There are still Afspraken found:",0,afspraken.size());
		// See if the Behandelingen are gone
		List<Behandeling> behandelingen = behandelingManager.getAllBehandelingen();
		assertNotNull("There are no Behandelingen found:",behandelingen);
		assertEquals("There are still Behandelingen:",0,behandelingen.size());
		// See if the Hond is gone
		List<Hond> honden = hondManager.getAllHonden();
		assertNotNull("There are no honden found:",honden);
		assertEquals("There are still honden:",0,honden.size());
		// See if the Klant is gone
		List<Klant> klanten = klantManager.getAllKlanten();
		assertNotNull("There are no klanten found:",klanten);
		assertEquals("There are still klanten:",0,klanten.size());
	}
	
	//====================================================================================
	//Supporting methods
	//
	
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
			Calendar datum = Calendar.getInstance();
			datum.setTime(new SimpleDateFormat("dd-MM-yyyy").parse("13-09-2010"));
			klant.setInschrijfdatum(datum);
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
			Calendar datum = Calendar.getInstance();
			datum.setTime(new SimpleDateFormat("dd-MM-yyyy").parse("25-12-2010"));
			klant.setInschrijfdatum(datum);
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
			Calendar datum = Calendar.getInstance();
			datum.setTime(new SimpleDateFormat("dd-MM-yyyy").parse("03-03-2000"));
			hond.setGeboortedatum(datum);
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
			Calendar datum = Calendar.getInstance();
			datum.setTime(new SimpleDateFormat("dd-MM-yyyy").parse("26-04-2005"));
			hond.setGeboortedatum(datum);
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
		Calendar datum = Calendar.getInstance();
		datum.setTime(d);
		afspraak.setDatum(datum);
		try {
			d = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse("10-01-2011 12:30");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		Calendar datum = Calendar.getInstance();
		datum.setTime(d);
		afspraak.setDatum(datum);
		try {
			d = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse("11-01-2011 16:30");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		afspraak.setOphalen(false);
		afspraak.setOpmerkingen("Bellen wanneer klaar.");
		return afspraak;
	}
	
	private List<Boekhouding> makeBoekhoudingItems(long afspraakId) {
		List<Boekhouding> items = new ArrayList<Boekhouding>();
		Date d = new Date();
		Calendar boekingsdatum = Calendar.getInstance();
		boekingsdatum.setTime(d);
		Afspraak afspraak = afspraakManager.getAfspraakById(afspraakId);
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
