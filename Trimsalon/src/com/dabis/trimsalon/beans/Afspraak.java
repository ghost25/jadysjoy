package com.dabis.trimsalon.beans;

import java.util.Calendar;

public class Afspraak
{
	private long id;
	private Calendar begintijd;
	private Calendar eindtijd;
	private long behandeling;
	private long klant;
	private long hond;
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
	 * @return the begintijd
	 */
	public Calendar getBegintijd() {
		return begintijd;
	}
	/**
	 * @param begintijd the begintijd to set
	 */
	public void setBegintijd(Calendar begintijd) {
		this.begintijd = begintijd;
	}
	/**
	 * @return the eindtijd
	 */
	public Calendar getEindtijd() {
		return eindtijd;
	}
	/**
	 * @param eindtijd the eindtijd to set
	 */
	public void setEindtijd(Calendar eindtijd) {
		this.eindtijd = eindtijd;
	}
	/**
	 * @return the behandeling
	 */
	public long getBehandeling() {
		return behandeling;
	}
	/**
	 * @param behandeling the behandeling to set
	 */
	public void setBehandeling(long behandeling) {
		this.behandeling = behandeling;
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
	/**
	 * @return the hond
	 */
	public long getHond() {
		return hond;
	}
	/**
	 * @param hond the hond to set
	 */
	public void setHond(long hond) {
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

