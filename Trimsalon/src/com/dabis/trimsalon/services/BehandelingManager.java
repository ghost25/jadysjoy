/**
 * Copyright © Arrow Software 2011
 */
package com.dabis.trimsalon.services;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.dabis.trimsalon.dao.IBehandelingDao;
import com.dabis.trimsalon.dao.base.IGenericDao;
import com.dabis.trimsalon.beans.Behandeling;

/**
 * @author Tom
 *
 */
public class BehandelingManager {

	static Logger logger = Logger.getLogger(BehandelingManager.class);
	@SuppressWarnings("rawtypes")
	private Map<String,IGenericDao> daos;
	
	public BehandelingManager() { }
	
	@SuppressWarnings("rawtypes")
	public BehandelingManager( Map<String, IGenericDao> daos ) {
		this.daos = daos;
	}
	
	/**
	 * Retrieve all Behandeling from database.
	 * 
	 * @return
	 * 			List of Behandeling objects
	 */
	@Transactional(readOnly=true)
	public List<Behandeling> getAllBehandelingen() {
		logger.info("GetAllBehandelingen");
		List<Behandeling> agegroups = ((IBehandelingDao)daos.get("BehandelingDao")).findAll();
		return agegroups;
	}
	
	/**
	 * Retrieve one Behandeling from database by its id.
	 * 
	 * @param id
	 * 			the id of the Behandeling to get
	 * @return
	 * 			the Behandeling object from database
	 */
	@Transactional(readOnly=true)
	public Behandeling getBehandelingById(long id) {
		logger.info("GetBehandelingById: "+id);
		Behandeling agegroup = ((IBehandelingDao)daos.get("BehandelingDao")).read(id);
		return agegroup;
	}
	
	/**
	 * Add a new Behandeling to the database.
	 * 
	 * @param behandeling
	 * 			the Behandeling object to add to the database
	 */
	@Transactional
	public long createBehandeling(Behandeling behandeling) {
		logger.info("CreateBehandling: name="+behandeling.getOmschrijving());
		return ((IBehandelingDao)daos.get("BehandelingDao")).create(behandeling);
	}
	
	/**
	 * Update the database with the given Behandeling object.
	 * 
	 * @param behandeling
	 * 			the Behandeling object to be updated
	 */
	@Transactional
	public void updateBehandeling (Behandeling behandeling) {
		logger.info("UpdateBehandeling: name="+behandeling.getOmschrijving());
		((IBehandelingDao)daos.get("BehandelingDao")).update(behandeling);
	}
	
	/**
	 * Remove the given Behandeling from the database.
	 * 
	 * @param agegroup
	 * 			the Behandeling object to be removed
	 */
	@Transactional
	public void deleteBehandeling (Behandeling behandeling) {
		logger.info("DeleteBehandeling: name="+behandeling.getOmschrijving());
		((IBehandelingDao)daos.get("BehandelingDao")).delete(behandeling);
	}

}
