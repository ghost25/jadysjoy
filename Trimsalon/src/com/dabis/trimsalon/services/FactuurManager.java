/**
 * Copyright © Arrow Software 2011
 */
package com.dabis.trimsalon.services;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.dabis.trimsalon.dao.IFactuurDao;
import com.dabis.trimsalon.dao.base.IGenericDao;
import com.dabis.trimsalon.beans.Factuur;

/**
 * @author Tom
 *
 */
public class FactuurManager {

	static Logger logger = Logger.getLogger(FactuurManager.class);
	@SuppressWarnings("rawtypes")
	private Map<String,IGenericDao> daos;
	
	public FactuurManager() { }
	
	@SuppressWarnings("rawtypes")
	public FactuurManager( Map<String, IGenericDao> daos ) {
		this.daos = daos;
	}
	
	/**
	 * Retrieve all Factuur from database.
	 * 
	 * @return
	 * 			List of Factuur objects
	 */
	@Transactional(readOnly=true)
	public List<Factuur> getAllFacturen() {
		logger.info("GetAllFactuuren");
		List<Factuur> agegroups = ((IFactuurDao)daos.get("FactuurDao")).findAll();
		return agegroups;
	}
	
	/**
	 * Retrieve one Factuur from database by its id.
	 * 
	 * @param id
	 * 			the id of the Factuur to get
	 * @return
	 * 			the Factuur object from database
	 */
	@Transactional(readOnly=true)
	public Factuur getFactuurById(long id) {
		logger.info("GetFactuurById: "+id);
		Factuur agegroup = ((IFactuurDao)daos.get("FactuurDao")).read(id);
		return agegroup;
	}
	
	/**
	 * Add a new Factuur to the database.
	 * 
	 * @param factuur
	 * 			the Factuur object to add to the database
	 */
	@Transactional
	public long createFactuur(Factuur factuur) {
		logger.info("CreateFactuur: name="+factuur.getFactuurnummer());
		return ((IFactuurDao)daos.get("FactuurDao")).create(factuur);
	}
	
	/**
	 * Update the database with the given Factuur object.
	 * 
	 * @param factuur
	 * 			the Factuur object to be updated
	 */
	@Transactional
	public void updateFactuur (Factuur factuur) {
		logger.info("UpdateFactuur: name="+factuur.getFactuurnummer());
		((IFactuurDao)daos.get("FactuurDao")).update(factuur);
	}
	
	/**
	 * Remove the given Factuur from the database.
	 * 
	 * @param agegroup
	 * 			the Factuur object to be removed
	 */
	@Transactional
	public void deleteFactuur (Factuur factuur) {
		logger.info("DeleteFactuur: name="+factuur.getFactuurnummer());
		((IFactuurDao)daos.get("FactuurDao")).delete(factuur);
	}

}
