/**
 * Copyright © Arrow Software 2011
 */
package com.dabis.trimsalon.services;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.dabis.trimsalon.dao.IAfspraakDao;
import com.dabis.trimsalon.dao.base.IGenericDao;
import com.dabis.trimsalon.beans.Afspraak;

/**
 * @author Tom
 *
 */
public class AfspraakManager {

	static Logger logger = Logger.getLogger(AfspraakManager.class);
	@SuppressWarnings("rawtypes")
	private Map<String,IGenericDao> daos;
	
	public AfspraakManager() { }
	
	@SuppressWarnings("rawtypes")
	public AfspraakManager( Map<String, IGenericDao> daos ) {
		this.daos = daos;
	}
	
	/**
	 * Retrieve all Afspraak from database.
	 * 
	 * @return
	 * 			List of Afspraak objects
	 */
	@Transactional(readOnly=true)
	public List<Afspraak> getAllAfspraken() {
		logger.info("GetAllAfspraaken");
		List<Afspraak> agegroups = ((IAfspraakDao)daos.get("AfspraakDao")).findAll();
		return agegroups;
	}
	
	/**
	 * Retrieve one Afspraak from database by its id.
	 * 
	 * @param id
	 * 			the id of the Afspraak to get
	 * @return
	 * 			the Afspraak object from database
	 */
	@Transactional(readOnly=true)
	public Afspraak getAfspraakById(long id) {
		logger.info("GetAfspraakById: "+id);
		Afspraak agegroup = ((IAfspraakDao)daos.get("AfspraakDao")).read(id);
		return agegroup;
	}
	
	/**
	 * Add a new Afspraak to the database.
	 * 
	 * @param afspraak
	 * 			the Afspraak object to add to the database
	 */
	@Transactional
	public long createAfspraak(Afspraak afspraak) {
		logger.info("CreateAfspraak");
		return ((IAfspraakDao)daos.get("AfspraakDao")).create(afspraak);
	}
	
	/**
	 * Update the database with the given Afspraak object.
	 * 
	 * @param afspraak
	 * 			the Afspraak object to be updated
	 */
	@Transactional
	public void updateAfspraak (Afspraak afspraak) {
		logger.info("UpdateAfspraak: id="+afspraak.getId());
		((IAfspraakDao)daos.get("AfspraakDao")).update(afspraak);
	}
	
	/**
	 * Remove the given Afspraak from the database.
	 * 
	 * @param agegroup
	 * 			the Afspraak object to be removed
	 */
	@Transactional
	public void deleteAfspraak (Afspraak afspraak) {
		logger.info("DeleteAfspraak: id="+afspraak.getId());
		((IAfspraakDao)daos.get("AfspraakDao")).delete(afspraak);
	}

}
