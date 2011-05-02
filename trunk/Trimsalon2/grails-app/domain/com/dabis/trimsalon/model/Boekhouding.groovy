package com.dabis.trimsalon.model

class Boekhouding {
	// Fields
	Integer factuurnr;
	Date boekingsdatum;
	Date factuurdatum
	BigDecimal prijsExbtw;
	BigDecimal btw;
	Boolean betaald;
	// Relationships
	static belongsTo = [afspraak:Afspraak]
	// Constraints and form sequence
    static constraints = {
		factuurnr()
		boekingsdatum()
		factuurdatum()
		prijsExbtw()
		btw()
		betaald()
    }
}
