/**
 * Copyright © Arrow Software 2011
 */
package com.dabis.trimsalon.services;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.dabis.trimsalon.dao.IKlantDao;
import com.dabis.trimsalon.dao.base.IGenericDao;
import com.dabis.trimsalon.beans.Klant;

/**
 * @author Tom
 *
 */
public class KlantManager {

	static Logger logger = Logger.getLogger(KlantManager.class);
	@SuppressWarnings("rawtypes")
	private Map<String,IGenericDao> daos;
	
	public KlantManager() { }
	
	@SuppressWarnings("rawtypes")
	public KlantManager( Map<String, IGenericDao> daos ) {
		this.daos = daos;
	}
	
	/**
	 * Retrieve all Klant from database.
	 * 
	 * @return
	 * 			List of Klant objects
	 */
	@Transactional(readOnly=true)
	public List<Klant> getAllKlanten() {
		logger.info("GetAllKlanten");
		List<Klant> agegroups = ((IKlantDao)daos.get("KlantDao")).findAll();
		return agegroups;
	}
	
	/**
	 * Retrieve one Klant from database by its id.
	 * 
	 * @param id
	 * 			the id of the Klant to get
	 * @return
	 * 			the Klant object from database
	 */
	@Transactional(readOnly=true)
	public Klant getKlantById(long id) {
		logger.info("GetKlantById: "+id);
		Klant agegroup = ((IKlantDao)daos.get("KlantDao")).read(id);
		return agegroup;
	}
	
	/**
	 * Add a new Klant to the database.
	 * 
	 * @param klant
	 * 			the Klant object to add to the database
	 */
	@Transactional
	public long createKlant(Klant klant) {
		logger.info("CreateKlant: name="+klant.getNaam());
		return ((IKlantDao)daos.get("KlantDao")).create(klant);
	}
	
	/**
	 * Update the database with the given Klant object.
	 * 
	 * @param klant
	 * 			the Klant object to be updated
	 */
	@Transactional
	public void updateKlant (Klant klant) {
		logger.info("UpdateKlant: name="+klant.getNaam());
		((IKlantDao)daos.get("KlantDao")).update(klant);
	}
	
	/**
	 * Remove the given Klant from the database.
	 * 
	 * @param agegroup
	 * 			the Klant object to be removed
	 */
	@Transactional
	public void deleteKlant (Klant klant) {
		logger.info("DeleteKlant: name="+klant.getNaam());
		((IKlantDao)daos.get("KlantDao")).delete(klant);
	}

}
