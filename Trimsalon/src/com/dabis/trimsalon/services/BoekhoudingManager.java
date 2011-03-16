/**
 * Copyright © Arrow Software 2011
 */
package com.dabis.trimsalon.services;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.dabis.trimsalon.dao.IBoekhoudingDao;
import com.dabis.trimsalon.dao.base.IGenericDao;
import com.dabis.trimsalon.beans.Boekhouding;

/**
 * @author Tom
 *
 */
public class BoekhoudingManager {

	static Logger logger = Logger.getLogger(BoekhoudingManager.class);
	@SuppressWarnings("rawtypes")
	private Map<String,IGenericDao> daos;
	
	public BoekhoudingManager() { }
	
	@SuppressWarnings("rawtypes")
	public BoekhoudingManager( Map<String, IGenericDao> daos ) {
		this.daos = daos;
	}
	
	/**
	 * Retrieve all Boekhouding from database.
	 * 
	 * @return
	 * 			List of Boekhouding objects
	 */
	@Transactional(readOnly=true)
	public List<Boekhouding> getAllBoekhoudingen() {
		logger.info("GetAllBoekhoudingen");
		List<Boekhouding> agegroups = ((IBoekhoudingDao)daos.get("BoekhoudingDao")).findAll();
		return agegroups;
	}
	
	/**
	 * Retrieve one Boekhouding from database by its id.
	 * 
	 * @param id
	 * 			the id of the Boekhouding to get
	 * @return
	 * 			the Boekhouding object from database
	 */
	@Transactional(readOnly=true)
	public Boekhouding getBoekhoudingById(long id) {
		logger.info("GetBoekhoudingById: "+id);
		Boekhouding agegroup = ((IBoekhoudingDao)daos.get("BoekhoudingDao")).read(id);
		return agegroup;
	}
	
	/**
	 * Add a new Boekhouding to the database.
	 * 
	 * @param boekhouding
	 * 			the Boekhouding object to add to the database
	 */
	@Transactional
	public long createBoekhouding(Boekhouding boekhouding) {
		logger.info("CreateBoekhouding");
		return ((IBoekhoudingDao)daos.get("BoekhoudingDao")).create(boekhouding);
	}
	
	/**
	 * Update the database with the given Boekhouding object.
	 * 
	 * @param boekhouding
	 * 			the Boekhouding object to be updated
	 */
	@Transactional
	public void updateBoekhouding (Boekhouding boekhouding) {
		logger.info("UpdateBoekhouding: Id="+boekhouding.getId());
		((IBoekhoudingDao)daos.get("BoekhoudingDao")).update(boekhouding);
	}
	
	/**
	 * Remove the given Boekhouding from the database.
	 * 
	 * @param agegroup
	 * 			the Boekhouding object to be removed
	 */
	@Transactional
	public void deleteBoekhouding (Boekhouding boekhouding) {
		logger.info("DeleteBoekhouding: name="+boekhouding.getId());
		((IBoekhoudingDao)daos.get("BoekhoudingDao")).delete(boekhouding);
	}

}
