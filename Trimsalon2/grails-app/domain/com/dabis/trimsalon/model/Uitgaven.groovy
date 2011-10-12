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
	
	// as it will be shown in the Afspraak form
	String toString(){
		return "${naam}, ${prijs} euro"
	}
} 