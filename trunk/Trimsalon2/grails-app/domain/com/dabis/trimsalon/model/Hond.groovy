package com.dabis.trimsalon.model

class Hond {
	
	static searchable = true
	
	// Fields
	String naam
	String ras
	String geslacht
	String gecastreerd
	String kleur
	Integer leeftijd
	Klant klant
		
	// Relationships
	static hasMany = [opmerkingen:Opmerking, afspraken:Afspraak]
	static belongsTo = [klant:Klant]
	
	// Validation and order of appearance of fields on Details form
    static constraints = {
		naam(blank:false)
		ras(blank:false)
		geslacht(inList: ["Reu", "Teef"])
		gecastreerd(inList: ["Gecastreerd", "Gesteriliseerd", "Geen"])
		kleur(blank:false)
		leeftijd(blank:false, maxLength:2)
		klant(blank:false)

	}
	
	// as it will be shown in the Opmerking form
		String toString(){
		return "${naam}, ${ras}"
	}	
		
}
