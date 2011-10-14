package com.dabis.trimsalon.model

class Inkomsten {
	static searchable = true
	
	// Fields
	Afspraak afspraak;
	Date dateCreated;
	Boolean betaald;
	
	// Relationships
	static belongsTo = [afspraak:Afspraak]

	// Constraints and form sequence
	
    static constraints = {
		afspraak(blank:false)
		dateCreated(blank:false)
		betaald()
    }
}
