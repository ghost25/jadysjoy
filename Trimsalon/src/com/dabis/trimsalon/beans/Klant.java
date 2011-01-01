package com.dabis.trimsalon.beans;

import java.util.Date;



public class Klant
{
	private long id;
	private String naam;
	private String adres;
	private String huisnummer;
	private String postcode;
	private String woonplaats;
	private String telefoon;
	private String mobiel;
	private String email;
	private boolean ophalen;
	private String opmerkingen;
	private Date inschrijfdatum;
	
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
	 * @return the adres
	 */
	public String getAdres() {
		return adres;
	}
	/**
	 * @param adres the adres to set
	 */
	public void setAdres(String adres) {
		this.adres = adres;
	}
	/**
	 * @return the huisnummer
	 */
	public String getHuisnummer() {
		return huisnummer;
	}
	/**
	 * @param huisnummer the huisnummer to set
	 */
	public void setHuisnummer(String huisnummer) {
		this.huisnummer = huisnummer;
	}
	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}
	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	/**
	 * @return the woonplaats
	 */
	public String getWoonplaats() {
		return woonplaats;
	}
	/**
	 * @param woonplaats the woonplaats to set
	 */
	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}
	/**
	 * @return the telefoon
	 */
	public String getTelefoon() {
		return telefoon;
	}
	/**
	 * @param telefoon the telefoon to set
	 */
	public void setTelefoon(String telefoon) {
		this.telefoon = telefoon;
	}
	/**
	 * @return the mobiel
	 */
	public String getMobiel() {
		return mobiel;
	}
	/**
	 * @param mobiel the mobiel to set
	 */
	public void setMobiel(String mobiel) {
		this.mobiel = mobiel;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @return the inschrijfdatum
	 */
	public Date getInschrijfdatum() {
		return inschrijfdatum;
	}
	/**
	 * @param inschrijfdatum the inschrijfdatum to set
	 */
	public void setInschrijfdatum(Date inschrijfdatum) {
		this.inschrijfdatum = inschrijfdatum;
	}	
}

