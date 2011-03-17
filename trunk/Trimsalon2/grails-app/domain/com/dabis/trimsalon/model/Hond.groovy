package com.dabis.trimsalon.model

class Hond {
	// Fields
	String naam
	String ras
	boolean reu = false
	String kleur
	boolean gecastreerd = false
	Date geboortedatum
	Klant klant
	// Relationships
	static hasMany = [opmerkingen:Opmerking]
	static belongsTo = [klant:Klant]
	// Validation and order of appearance of fields on Details form
    static constraints = {
		naam(blank:false)
		ras()
		reu()
		kleur()
		gecastreerd()
		geboortedatum()
    }
	// as it will be shown in the Opmerking form
	String toString(){
		return "${naam}, ${klant.postcode} ${klant.woonplaats}"
	}
}
