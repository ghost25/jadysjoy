package com.dabis.trimsalon.model

class Boekhouding {
	// Fields
	Date boekingsdatum;
	Afspraak afspraak;
	BigDecimal prijsExbtw;
	BigDecimal btw;
	Boolean betaald;
	// Relationships
	static hasOne = [afspraak:Afspraak]
	// Constraints and form sequence
    static constraints = {
		boekingsdatum()
		afspraak()
		prijsExbtw()
		btw()
		betaald()
    }
}
