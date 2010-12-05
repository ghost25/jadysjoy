package com.dabis.trimsalon.beans;

public class Client
{
	private long Id;
	private String soort;
	private String naam;
	private String woonplaats;
	private int leeftijd;
	private int gewicht;
	/**
	 * @return the id
	 */
	public long getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		Id = id;
	}
	/**
	 * @return the soort
	 */
	public String getSoort() {
		return soort;
	}
	/**
	 * @param soort the soort to set
	 */
	public void setSoort(String soort) {
		this.soort = soort;
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
	 * @return the leeftijd
	 */
	public int getLeeftijd() {
		return leeftijd;
	}
	/**
	 * @param leeftijd the leeftijd to set
	 */
	public void setLeeftijd(int leeftijd) {
		this.leeftijd = leeftijd;
	}
	/**
	 * @return the gewicht
	 */
	public int getGewicht() {
		return gewicht;
	}
	/**
	 * @param gewicht the gewicht to set
	 */
	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}
	
	
}

