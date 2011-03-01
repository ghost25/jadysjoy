package com.dabis.trimsalon.beans;

import java.util.Date;

import org.hibernate.collection.PersistentSet;

public class Hond
{
	private long id;
	private String naam;
	private String ras;
	private boolean reu;
	private String kleur;
	private boolean gecastreerd;
	private Date geboortedatum;
	private PersistentSet opmerkingen;
	private Klant klant;
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	/**
	 * @return the naam
	 */
	public String getNaam() {
		return naam;
	}

	/**
	 * @param naam the naam to set
	 */
	public void setNaam(String naam) {
		this.naam = naam;
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
	 * @return the reu
	 */
	public boolean isReu() {
		return reu;
	}

	/**
	 * @param reu the reu to set
	 */
	public void setReu(boolean reu) {
		this.reu = reu;
	}

	/**
	 * @return the kleur
	 */
	public String getKleur() {
		return kleur;
	}

	/**
	 * @param kleur the kleur to set
	 */
	public void setKleur(String kleur) {
		this.kleur = kleur;
	}

	/**
	 * @return the gecastreerd
	 */
	public boolean isGecastreerd() {
		return gecastreerd;
	}

	/**
	 * @param gecastreerd the gecastreerd to set
	 */
	public void setGecastreerd(boolean gecastreerd) {
		this.gecastreerd = gecastreerd;
	}

	/**
	 * @return the geboortedatum
	 */
	public Date getGeboortedatum() {
		return geboortedatum;
	}

	/**
	 * @param geboortedatum the geboortedatum to set
	 */
	public void setGeboortedatum(Date geboortedatum) {
		this.geboortedatum = geboortedatum;
	}

	/**
	 * @return the opmerkingen
	 */
	public PersistentSet getOpmerkingen() { 
		return opmerkingen;
	}

	/**
	 * @param opmerkingen the opmerkingen to set
	 */
	public void setOpmerkingen(PersistentSet opmerkingen) {
		this.opmerkingen = opmerkingen;
	}

	/**
	 * Add one opmerking
	 */
	public void addOpmerking(Opmerking opmerking) {
		if( opmerkingen == null ) opmerkingen = new PersistentSet();
		opmerkingen.add(opmerking);
	}
	
	/**
	 * Remove one opmerking
	 */
	public void removeOpmerking(Opmerking opmerking) {
		if( opmerkingen != null ) {
			opmerkingen.remove(opmerking);
		}
	}
	/**
	 * @return the klant
	 */
	public Klant getKlant() {
		return klant;
	}

	/**
	 * @param klant the klant to set
	 */
	public void setKlant(Klant klant) {
		this.klant = klant;
	}
	
}