package com.dabis.trimsalon.model

class Hond {
	
	// Fields
	String naam
	String ras
	String geslacht
	String kleur
	String gecastreerd
	Date geboortedatum
	Klant klant
	
	// Relationships
	static hasMany = [opmerkingen:Opmerking, afspraken:Afspraak]
	static hasOne = [klant:Klant]
	
	// Validation and order of appearance of fields on Details form
    static constraints = {
		naam(blank:false)
		ras(blank:false)
		geslacht(inList: ["Reu", "Teef"])
		kleur(blank:false)
		gecastreerd(inList: ["Gecastreerd", "Gesteriliseerd", "Geen"])
		geboortedatum(blank:false, nullable:false)
		klant(blank:false)
    }
	
	// as it will be shown in the Opmerking form
		String toString(){
		return "${naam}, ${klant.naam} ${klant.woonplaats}"
	}
}
