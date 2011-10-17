package com.dabis.trimsalon.model


class Producten {
	static searchable = true
	
	String naam;
	String omschrijving;
	String ras;
	BigDecimal prijsExbtw;
	Integer voorraad;

	static hasMany = [afspraak:Afspraak, boekhouding:Inkomsten]
	
    static constraints = {
		naam(blank:false)
		omschrijving(blank:false)
		ras()
		prijsExbtw(scale:2)
		voorraad(min:1)
    }
	
	BigDecimal getprijs(){		
		return prijsExbtw * 1.19
		}
		
	static transients = ['prijs']
	
	// as it will be shown in the Afspraak form
	String toString(){
		return "${naam}"
	}
} 