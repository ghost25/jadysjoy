package com.dabis.trimsalon.model

class Producten {
	static searchable = true
	
	String naam;
	String omschrijving;
	BigDecimal prijsExbtw;
	BigDecimal btw = 19;
	Integer voorraad;
	Integer drempel;

	static hasMany = [afspraken:Afspraak]
	
    static constraints = {
		naam(blank:false)
		omschrijving(blank:false)
		prijsExbtw(blank:false, scale:2)
		btw(blank:false)
		voorraad(min:1)
		drempel(min:1)
    }
	
	// as it will be shown in the Afspraak form
	String toString(){
		return "${naam}"
	}
} 