package com.dabis.trimsalon.beans;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Factuur
{
	private long id;
	private Set<Boekhouding> factuurregels;
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
	public Set<Boekhouding> getFactuurregels() {
		if( factuurregels == null ) factuurregels = new HashSet<Boekhouding>();
		return factuurregels;
	}
	/**
	 * @param factuurregels the factuurregels to set
	 */
	public void setFactuurregels(Set<Boekhouding> factuurregels) {
		this.factuurregels = factuurregels;
	}
	/**
	 * Add one Factuurregel
	 */
	public void addFactuurregel(Boekhouding item) {
		getFactuurregels().add(item);
	}
	/**
	 * Remove one Factuurregel
	 */
	public void removeFactuurregel(Boekhouding item) {
		if( factuurregels != null ) {
			factuurregels.remove(item);
		}
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

