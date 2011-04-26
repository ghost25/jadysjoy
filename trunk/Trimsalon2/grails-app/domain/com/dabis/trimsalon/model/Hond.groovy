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
		ras()
		geslacht(inList: ["Reu", "Teef"])
		kleur()
		gecastreerd(inList: ["Gecastreerd", "Gesteriliseerd", "Geen"])
		geboortedatum()
		klant(blank:false, unique:true)
    }
	
	// as it will be shown in the Opmerking form
		String toString(){
		return "${naam}, ${klant.postcode} ${klant.woonplaats}"
	}
}
