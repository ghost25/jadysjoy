/**
 * 
 */
package com.dabis.trimsalon.beans;

import java.util.Date;

/**
 * @author rdaalman
 *
 */
public class Boekhouding {
	
	private long id;
	private Date boekingsdatum;
	private Afspraak afspraak;
	private double prijsExbtw;
	private double btw;
	private boolean betaalt;
	
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
	 * @return the boekingsdatum
	 */
	public Date getBoekingsdatum() {
		return boekingsdatum;
	}
	/**
	 * @param boekingsdatum the boekingsdatum to set
	 */
	public void setBoekingsdatum(Date boekingsdatum) {
		this.boekingsdatum = boekingsdatum;
	}
	/**
	 * @return the afspraak
	 */
	public Afspraak getAfspraak() {
		return afspraak;
	}
	/**
	 * @param afspraak the afspraak to set
	 */
	public void setAfspraak(Afspraak afspraak) {
		this.afspraak = afspraak;
	}
	/**
	 * @return the prijsExbtw
	 */
	public double getPrijsExbtw() {
		return prijsExbtw;
	}
	/**
	 * @param prijsExbtw the prijsExbtw to set
	 */
	public void setPrijsExbtw(double prijsExbtw) {
		this.prijsExbtw = prijsExbtw;
	}
	/**
	 * @return the btw
	 */
	public double getBtw() {
		return btw;
	}
	/**
	 * @param btw the btw to set
	 */
	public void setBtw(double btw) {
		this.btw = btw;
	}
	/**
	 * @return the betaalt
	 */
	public boolean isBetaalt() {
		return betaalt;
	}
	/**
	 * @param betaalt the betaalt to set
	 */
	public void setBetaalt(boolean betaalt) {
		this.betaalt = betaalt;
	}
}
