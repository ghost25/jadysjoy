package com.dabis.trimsalon.model

class Boekhouding {
	static searchable = true
	
	// Fields
	Integer factuurnr;
	Date boekingsdatum;
	Date factuurdatum
	BigDecimal prijsExbtw;
	BigDecimal btw = 19;
	String betaald;
	// Relationships
	static belongsTo = [afspraak:Afspraak]
	// Constraints and form sequence
	
    static constraints = {
		factuurnr(min:90000)
		boekingsdatum(blank:false)
		factuurdatum(blank:false)
		prijsExbtw(blank:false)
		btw(blank:false)
		betaald(inList: ["Nee", "Ja"])
    }
}
