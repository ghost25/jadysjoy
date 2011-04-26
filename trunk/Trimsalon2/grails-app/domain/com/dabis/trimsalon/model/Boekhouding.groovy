package com.dabis.trimsalon.model

class Boekhouding {
	// Fields
	Date boekingsdatum;
	BigDecimal prijsExbtw;
	BigDecimal btw;
	Boolean betaald;
	// Relationships
	static belongsTo = [afspraak:Afspraak]
	// Constraints and form sequence
    static constraints = {
		boekingsdatum()
		prijsExbtw()
		btw()
		betaald()
    }
}
