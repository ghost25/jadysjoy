/**
 * Copyright © Arrow Software 2011
 */
package com.dabis.trimsalon.services;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.dabis.trimsalon.dao.IHondDao;
import com.dabis.trimsalon.dao.IKlantDao;
import com.dabis.trimsalon.dao.IOpmerkingDao;
import com.dabis.trimsalon.dao.base.IGenericDao;
import com.dabis.trimsalon.beans.Hond;
import com.dabis.trimsalon.beans.Klant;
import com.dabis.trimsalon.beans.Opmerking;

/**
 * @author Tom
 *
 */
public class HondManager {

	static Logger logger = Logger.getLogger(HondManager.class);
	@SuppressWarnings("rawtypes")
	private Map<String,IGenericDao> daos;
	
	public HondManager() { }
	
	@SuppressWarnings("rawtypes")
	public HondManager( Map<String, IGenericDao> daos ) {
		this.daos = daos;
	}
	
	/**
	 * Retrieve all Hond from database.
	 * 
	 * @return
	 * 			List of Hond objects
	 */
	@Transactional(readOnly=true)
	public List<Hond> getAllHonden() {
		logger.info("GetAllHonden");
		List<Hond> agegroups = ((IHondDao)daos.get("HondDao")).findAll();
		return agegroups;
	}
	
	/**
	 * Retrieve one Hond from database by its id.
	 * 
	 * @param id
	 * 			the id of the Hond to get
	 * @return
	 * 			the Hond object from database
	 */
	@Transactional(readOnly=true)
	public Hond getHondById(long id) {
		logger.info("GetHondById: "+id);
		Hond agegroup = ((IHondDao)daos.get("HondDao")).read(id);
		return agegroup;
	}
	
	/**
	 * Add a new Hond to the database.
	 * 
	 * @param hond
	 * 			the Hond object to add to the database
	 */
	@Transactional
	public long createHond(Hond hond) {
		logger.info("CreateHond: name="+hond.getNaam());
		return ((IHondDao)daos.get("HondDao")).create(hond);
	}
	
	/**
	 * Update the database with the given Hond object.
	 * 
	 * @param hond
	 * 			the Hond object to be updated
	 */
	@Transactional
	public void updateHond (Hond hond) {
		logger.info("UpdateHond: name="+hond.getNaam());
		((IHondDao)daos.get("HondDao")).update(hond);
	}
	
	/**
	 * Remove the given Hond from the database.
	 * 
	 * @param agegroup
	 * 			the Hond object to be removed
	 */
	@Transactional
	public void deleteHond (Hond hond) {
		logger.info("DeleteHond: name="+hond.getNaam());
		((IHondDao)daos.get("HondDao")).delete(hond);
	}
	
	/**
	 * Add Opmerking
	 */
	@Transactional
	public void addOpmerkingToHond(Hond hond, Opmerking opmerking) {
		((IOpmerkingDao)daos.get("OpmerkingDao")).create(opmerking);
		hond.addOpmerking(opmerking);
		updateHond(hond);
	}
	
	/**
	 * Remove Opmerking
	 */
	@Transactional
	public void removeOpmerkingFromHond(Hond hond, Opmerking opmerking) {
		Opmerking opm = ((IOpmerkingDao)daos.get("OpmerkingDao")).read(opmerking.getId());
		hond.removeOpmerking(opmerking);
		((IOpmerkingDao)daos.get("OpmerkingDao")).delete(opm);
		updateHond(hond);
	}
	
	/**
	 * Add Klant
	 */
	@Transactional
	public void addKlantToHond(Hond hond, Klant klant) {
		Klant kl = ((IKlantDao)daos.get("KlantDao")).read(klant.getId());
		hond.setKlant(kl);
		updateHond(hond);
	}
}
