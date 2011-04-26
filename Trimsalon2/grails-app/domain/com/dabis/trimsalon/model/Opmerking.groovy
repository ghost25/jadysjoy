package com.dabis.trimsalon.model

class Opmerking {
	// Fields
	Hond hond
	String advies
	String gedrag
	String medischeKenmerken
	Date dateCreated
	
	// Relationships
	static belongsTo = [hond:Hond]
	
	// Validation and order of appearance of fields on Details form
    static constraints = {
		dateCreated()
		hond()
		advies()
		gedrag()
		medischeKenmerken()
    }
	
	// as it will be shown in the Hond form
	String toString(){
		return "${dateCreated.format('dd-MM-yyyy')}"
	}
}
