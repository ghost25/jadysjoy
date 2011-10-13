package com.dabis.trimsalon.model


class Uitgaven {
	static searchable = true
	
	String omschrijving;
	BigDecimal prijsExbtw;
	BigDecimal prijs;
	BigDecimal getprijs() {
		prijsExbtw * 1.19
		}
	
    static constraints = {
		omschrijving(blank:false)
		prijsExbtw(scale:2)
		prijs()
    }
		
	static transients = ['prijs']
	
} 