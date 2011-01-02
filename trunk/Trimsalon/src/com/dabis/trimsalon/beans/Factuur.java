package com.dabis.trimsalon.beans;

import java.util.Date;
import org.hibernate.collection.PersistentSet;

public class Factuur
{
	private long id;
	private PersistentSet factuurregels;
	private Date factuurdatum;
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
	public PersistentSet getFactuurregels() {
		return factuurregels;
	}
	/**
	 * @param factuurregels the factuurregels to set
	 */
	public void setFactuurregels(PersistentSet factuurregels) {
		this.factuurregels = factuurregels;
	}
	/**
	 * Add one Factuurregel
	 */
	public void addFactuurregel(Boekhouding item) {
		if( factuurregels == null ) factuurregels = new PersistentSet();
		factuurregels.add(item);
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
	public Date getFactuurdatum() {
		return factuurdatum;
	}
	/**
	 * @param factuurdatum the factuurdatum to set
	 */
	public void setFactuurdatum(Date factuurdatum) {
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

