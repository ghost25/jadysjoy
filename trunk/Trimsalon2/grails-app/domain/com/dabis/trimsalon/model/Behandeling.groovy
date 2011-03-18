package com.dabis.trimsalon.model

class Behandeling {
	String omschrijving;
	String ras;
	BigDecimal prijsExbtw;
	BigDecimal btw;

    static constraints = {
		ras()
		omschrijving()
		prijsExbtw()
		btw()
    }
}
