package com.dabis.trimsalon.model


class Uitgaven {
	static searchable = true
	
	String omschrijving;
	BigDecimal prijsExbtw; 

	
    static constraints = {
		omschrijving(blank:false)
		prijsExbtw(scale:2)
    }

	BigDecimal getprijs(){
		return prijsExbtw * 1.19
		}
			
	static transients = ['prijs']
	
} 