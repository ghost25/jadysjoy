/**
 * 
 */
package com.dabis.trimsalon.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.dabis.trimsalon.beans.Klant;

/**
 * @author rdaalman
 *
 */
public class KlantManager {

	public static Logger log = Logger.getLogger(KlantManager.class);
	
	private static Map<Long, Klant> klanten = new HashMap<Long, Klant>();
	private static long currentId = 0;
	
	public static void initialize() {
		Klant k = new Klant();
		k.setId(++currentId);
		k.setNaam("Rob Daalman");
		k.setAdres("Molenstraat");
		k.setHuisnummer("207");
		k.setPostcode("5342CB");
		k.setWoonplaats("Oss");
		k.setInschrijfdatum(new Date());
		k.setTelefoon("0412630534");
		k.setMobiel("0647886423");
		k.setOphalen(false);
		k.setEmail("rob.daalman@gmail.com");
		k.setOpmerkingen("Lastige klant!");
		klanten.put(currentId, k);
		
		k = new Klant();
		k.setId(++currentId);
		k.setNaam("Tom Pijl");
		k.setAdres("Jagerspad");
		k.setHuisnummer("10");
		k.setPostcode("5343XE");
		k.setWoonplaats("Oss");
		k.setInschrijfdatum(new Date());
		k.setTelefoon("0412630534");
		k.setMobiel("0646615266");
		k.setOphalen(true);
		k.setEmail("tom.deanne.pijl@home.nl");
		k.setOpmerkingen("Geeft altijd fooi.!");
		klanten.put(currentId, k);
	}

	public static long addKlant(Klant klant) {
		klant.setId(++currentId);
		klanten.put(currentId, klant);
		return currentId;
	}
	
	public void updateKlant(Klant klant) {
		klanten.remove(klant.getId());
		klanten.put(klant.getId(), klant);
	}
	
	public void deleteKlant(Klant klant) {
		klanten.remove(klant.getId());
	}
	
	public List<Klant> getAllKlanten() {
		return (List<Klant>) klanten.values();
	}
	
	public Klant getKlantById(long id) {
		return klanten.get(id);
	}
	
}
