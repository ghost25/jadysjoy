package com.dabis.trimsalon.model

class Producten {
	String omschrijving;
	String ras;
	BigDecimal prijsExbtw;
	BigDecimal btw;

	static hasMany = [afspraken:Afspraak]
	
    static constraints = {
		ras()
		omschrijving()
		prijsExbtw()
		btw()
    }
}
