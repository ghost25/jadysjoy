package com.dabis.trimsalon.beans;

import java.util.Calendar;

public class Factuur
{
	private long id;
	private List<Boekhouding> factuurregels;
	private Calendar factuurdatum;
	private String factuurnummer;
	
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
	 * @return the factuurregels
	 */
	public List<Boekhouding> getFactuurregels() {
		return factuurregels;
	}
	/**
	 * @param factuurregels the factuurregels to set
	 */
	public void setFactuurregels(List<Boekhouding> factuurregels) {
		this.factuurregels = factuurregels;
	}
	/**
	 * @return the factuurdatum
	 */
	public Calendar getFactuurdatum() {
		return factuurdatum;
	}
	/**
	 * @param factuurdatum the factuurdatum to set
	 */
	public void setFactuurdatum(Calendar factuurdatum) {
		this.factuurdatum = factuurdatum;
	}
	/**
	 * @return the factuurnummer
	 */
	public String getFactuurnummer() {
		return factuurnummer;
	}
	/**
	 * @param factuurnummer the factuurnummer to set
	 */
	public void setFactuurnummer(String factuurnummer) {
		this.factuurnummer = factuurnummer;
	}	
}

