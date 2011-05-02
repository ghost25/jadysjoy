package com.dabis.trimsalon.model

class Afspraak {
	// Fields
	Date datum
	Date begintijd
	Date eindtijd;
	Producten producten
	Hond hond
	Klant klant
	String opmerkingen
	Boolean ophalen
	Boolean afgehandeld
	User user
	
	// Relationships
	static hasOne = [klant:Klant, hond:Hond, producten:Producten, user:User]
	
	// Constraints and form sequence
    static constraints = {
		datum(blank:false)
		begintijd(blank:false)
		eindtijd()
		producten(unique:true)
		hond(unique:true)
		klant(unique:true)
		opmerkingen()
		ophalen()
		afgehandeld()
		user()
    }
	
	String toString(){
		return "${datum.format('dd-MM-yyyy')} ${klant}"
	}
}
