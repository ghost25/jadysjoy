package com.dabis.trimsalon.model

class Producten {
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
		prijsExbtw(blank:false)
		btw()
		voorraad()
		drempel()
    }
	
	// as it will be shown in the Afspraak form
	String toString(){
		return "${naam}"
	}
} 