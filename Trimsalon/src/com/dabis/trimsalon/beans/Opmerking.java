/**
 * 
 */
package com.dabis.trimsalon.beans;

import java.util.Date;

/**
 * @author rdaalman
 *
 */
public class Opmerking {
	
	private long id;
	private String advies;
	private String gedrag;
	private String medischeKenmerken;
	private Date datum;
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the advies
	 */
	public String getAdvies() {
		return advies;
	}
	/**
	 * @param advies the advies to set
	 */
	public void setAdvies(String advies) {
		this.advies = advies;
	}
	/**
	 * @return the gedrag
	 */
	public String getGedrag() {
		return gedrag;
	}
	/**
	 * @param gedrag the gedrag to set
	 */
	public void setGedrag(String gedrag) {
		this.gedrag = gedrag;
	}
	/**
	 * @return the medischeKenmerken
	 */
	public String getMedischeKenmerken() {
		return medischeKenmerken;
	}
	/**
	 * @param medischeKenmerken the medischeKenmerken to set
	 */
	public void setMedischeKenmerken(String medischeKenmerken) {
		this.medischeKenmerken = medischeKenmerken;
	}
	/**
	 * @return the datum
	 */
	public Date getDatum() {
		return datum;
	}
	/**
	 * @param datum the datum to set
	 */
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
}
