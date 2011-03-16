/**
 * Copyright © Arrow Software 2011
 */
package com.dabis.trimsalon.services;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.dabis.trimsalon.dao.IOpmerkingDao;
import com.dabis.trimsalon.dao.base.IGenericDao;
import com.dabis.trimsalon.beans.Opmerking;

/**
 * @author Tom
 *
 */
public class OpmerkingManager {

	static Logger logger = Logger.getLogger(OpmerkingManager.class);
	@SuppressWarnings("rawtypes")
	private Map<String,IGenericDao> daos;
	
	public OpmerkingManager() { }
	
	@SuppressWarnings("rawtypes")
	public OpmerkingManager( Map<String, IGenericDao> daos ) {
		this.daos = daos;
	}
	
	/**
	 * Retrieve all Opmerking from database.
	 * 
	 * @return
	 * 			List of Opmerking objects
	 */
	@Transactional(readOnly=true)
	public List<Opmerking> getAllOpmerkingen() {
		logger.info("GetAllOpmerkingen");
		List<Opmerking> agegroups = ((IOpmerkingDao)daos.get("OpmerkingDao")).findAll();
		return agegroups;
	}
	
	/**
	 * Retrieve one Opmerking from database by its id.
	 * 
	 * @param id
	 * 			the id of the Opmerking to get
	 * @return
	 * 			the Opmerking object from database
	 */
	@Transactional(readOnly=true)
	public Opmerking getOpmerkingById(long id) {
		logger.info("GetOpmerkingById: "+id);
		Opmerking agegroup = ((IOpmerkingDao)daos.get("OpmerkingDao")).read(id);
		return agegroup;
	}
	
	/**
	 * Add a new Opmerking to the database.
	 * 
	 * @param opmerking
	 * 			the Opmerking object to add to the database
	 */
	@Transactional
	public long createOpmerking(Opmerking opmerking) {
		logger.info("CreateOpmerking: name="+opmerking.getAdvies());
		return ((IOpmerkingDao)daos.get("OpmerkingDao")).create(opmerking);
	}
	
	/**
	 * Update the database with the given Opmerking object.
	 * 
	 * @param opmerking
	 * 			the Opmerking object to be updated
	 */
	@Transactional
	public void updateOpmerking (Opmerking opmerking) {
		logger.info("UpdateOpmerking: name="+opmerking.getId());
		((IOpmerkingDao)daos.get("OpmerkingDao")).update(opmerking);
	}
	
	/**
	 * Remove the given Opmerking from the database.
	 * 
	 * @param agegroup
	 * 			the Opmerking object to be removed
	 */
	@Transactional
	public void deleteOpmerking (Opmerking opmerking) {
		logger.info("DeleteOpmerking: name="+opmerking.getId());
		((IOpmerkingDao)daos.get("OpmerkingDao")).delete(opmerking);
	}

}
