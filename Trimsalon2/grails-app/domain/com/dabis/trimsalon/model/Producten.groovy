package com.dabis.trimsalon.model


class Producten {
	static searchable = true
	
	String naam;
	String omschrijving;
	String ras;
	BigDecimal prijsExbtw;
	BigDecimal prijs;
	BigDecimal getprijs() {
		prijsExbtw * 1.19
		}
	Integer voorraad;

	static hasMany = [afspraak:Afspraak, boekhouding:Boekhouding]
	
    static constraints = {
		naam(blank:false)
		omschrijving(blank:false)
		ras()
		prijsExbtw(scale:2)
		prijs()
		voorraad(min:1)
    }
		
	static transients = ['prijs']
	
	// as it will be shown in the Afspraak form
	String toString(){
		return "${naam}, ${prijs} euro"
	}
} 