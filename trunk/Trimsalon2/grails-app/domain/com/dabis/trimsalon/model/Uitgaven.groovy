package com.dabis.trimsalon.model


class Uitgaven {
	static searchable = true
	
	String omschrijving;
	BigDecimal prijsExbtw;
	BigDecimal prijs;
	
    static constraints = {
		omschrijving(blank:false)
		prijsExbtw(scale:2)
		prijs(scale:2)
    }
		
	static transients = ['prijs']
	
	public String getPrijs(){
		if (prijsExbtw != null) {
			prijs = prijsExbtw * 1.19
		}
		return prijs
		}
} 