package com.dabis.trimsalon.beans;

public class Behandeling
{
	private long id;
	private String omschrijving;
	private String ras;
	private double prijsExbtw;
	private double btw;
	
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
	 * @return the omschrijving
	 */
	public String getOmschrijving() {
		return omschrijving;
	}
	/**
	 * @param omschrijving the omschrijving to set
	 */
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
	/**
	 * @return the ras
	 */
	public String getRas() {
		return ras;
	}
	/**
	 * @param ras the ras to set
	 */
	public void setRas(String ras) {
		this.ras = ras;
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
	
}

