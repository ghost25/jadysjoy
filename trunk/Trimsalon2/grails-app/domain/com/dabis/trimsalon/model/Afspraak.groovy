package com.dabis.trimsalon.model

class Afspraak {
	// Fields
	Date datum
	Hond hond
	Klant klant
	String opmerkingen
	Boolean ophalen
	Boolean afgehandeld
	
	// Relationships
	static hasOne = [klant:Klant, hond:Hond, producten:Producten]
	
	// Constraints and form sequence
    static constraints = {
		datum(blank:false)
		hond(unique:true)
		klant(unique:true)
		opmerkingen()
		ophalen()
		afgehandeld()
    }
}
