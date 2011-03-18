package com.dabis.trimsalon.model

class Hond {
	// Fields
	String naam
	String ras
	Boolean reu = false
	String kleur
	Boolean gecastreerd = false
	Date geboortedatum
	Klant klant
// Relationships
	static hasMany = [opmerkingen:Opmerking, afspraken:Afspraak]
	static hasOne = [klant:Klant]
	// Validation and order of appearance of fields on Details form
    static constraints = {
		naam(blank:false)
		ras()
		reu()
		kleur()
		gecastreerd()
		geboortedatum()
		klant(blank:false, unique:true)
    }
	// as it will be shown in the Opmerking form
	String toString(){
		return "${naam}, ${klant.postcode} ${klant.woonplaats}"
	}
}
