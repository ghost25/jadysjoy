package com.dabis.trimsalon.beans;

import java.util.Calendar;
import java.util.List;

public class Hond
{
	private long id;
	private String naam;
	private String ras;
	private boolean reu;
	private String kleur;
	private boolean gecastreerd;
	private Calendar geboortedatum;
	private List<Opmerking> opmerkingen;
	private long klant;
	
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
	public Calendar getGeboortedatum() {
		return geboortedatum;
	}

	/**
	 * @param geboortedatum the geboortedatum to set
	 */
	public void setGeboortedatum(Calendar geboortedatum) {
		this.geboortedatum = geboortedatum;
	}

	/**
	 * @return the opmerkingen
	 */
	public List<Opmerking> getOpmerkingen() {
		return opmerkingen;
	}

	/**
	 * @param opmerkingen the opmerkingen to set
	 */
	public void setOpmerkingen(List<Opmerking> opmerkingen) {
		this.opmerkingen = opmerkingen;
	}

	/**
	 * @return the klant
	 */
	public long getKlant() {
		return klant;
	}

	/**
	 * @param klant the klant to set
	 */
	public void setKlant(long klant) {
		this.klant = klant;
	}
	
}