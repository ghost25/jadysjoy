package com.dabis.trimsalon.model

class Boekhouding {
	static searchable = true
	
	// Fields
	Afspraak datum;
	Date dateCreated;
	Producten prijsExbtw;
	Producten prijs;
	Afspraak hond;
	Boolean betaald;
	
	// Relationships
	static belongsTo = [afspraak:Afspraak, producten:Producten]

	// Constraints and form sequence
	
    static constraints = {
		datum(blank:false)
		dateCreated(blank:false)
		prijsExbtw(blank:false)
		prijs(blsnk:false)
		hond(blank:false)
		betaald()
    }
}
