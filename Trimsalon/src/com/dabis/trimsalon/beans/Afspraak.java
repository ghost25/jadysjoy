package com.dabis.trimsalon.beans;

import java.util.Date;

import org.hibernate.collection.PersistentSet;

public class Afspraak
{
	private long id;
	private Date datum;
	private PersistentSet behandelingen;
	private Klant klant;
	private Hond hond;
	private String opmerkingen;
	private boolean ophalen;
	private boolean afgehandeld;
	
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
	
	/**
	 * @return the behandeling
	 */
	public PersistentSet getBehandelingen() {
		return behandelingen;
	}
	/**
	 * @param behandeling the behandeling to set
	 */
	public void setBehandelingen(PersistentSet behandelingen) {
		this.behandelingen = behandelingen;
	}
	
	/**
	 * Add one Behandeling
	 */
	public void addBehandeling(Behandeling behandeling) {
		behandelingen.add(behandeling);
	}
	
	/**
	 * Remove one Behandeling
	 */
	public void removeBehandeling(Behandeling behandeling) {
		if( behandelingen != null ) {
			behandelingen.remove(behandeling);
		}
	}
	
	/**
	 * @return the klant
	 */
	public Klant getKlant() {
		return klant;
	}
	/**
	 * @param hond the klant to set
	 */
	public void setKlant(Klant klant) {
		this.klant = klant;
	}
	
	/**
	 * @return the hond
	 */
	public Hond getHond() {
		return hond;
	}
	/**
	 * @param hond the hond to set
	 */
	public void setHond(Hond hond) {
		this.hond = hond;
	}
	/**
	 * @return the opmerkingen
	 */
	public String getOpmerkingen() {
		return opmerkingen;
	}
	/**
	 * @param opmerkingen the opmerkingen to set
	 */
	public void setOpmerkingen(String opmerkingen) {
		this.opmerkingen = opmerkingen;
	}
	/**
	 * @return the ophalen
	 */
	public boolean isOphalen() {
		return ophalen;
	}
	/**
	 * @param ophalen the ophalen to set
	 */
	public void setOphalen(boolean ophalen) {
		this.ophalen = ophalen;
	}
	/**
	 * @return the afgehandeld
	 */
	public boolean isAfgehandeld() {
		return afgehandeld;
	}
	/**
	 * @param afgehandeld the afgehandeld to set
	 */
	public void setAfgehandeld(boolean afgehandeld) {
		this.afgehandeld = afgehandeld;
	}
	
}

