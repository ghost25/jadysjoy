package com.dabis.trimsalon.model

class Factuur {
	// Fields
	Date factuurdatum
	String factuurnummer
	// Relationships
	static hasMany = [factuurregels:Boekhouding]
	// Constraints and form sequence
    static constraints = {
		factuurnummer()
		factuurdatum()
    }
}
