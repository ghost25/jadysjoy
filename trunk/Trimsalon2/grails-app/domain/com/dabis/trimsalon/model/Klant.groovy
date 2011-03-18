package com.dabis.trimsalon.model

class Klant {
	// Fields
	String naam
	String adres
	String huisnummer
	String postcode
	String woonplaats
	String telefoon
	String mobiel
	String email
	Boolean ophalen = false
	String opmerkingen
	Date inschrijfdatum
	// Relationships
	static hasMany = [honden:Hond, afspraken:Afspraak]
	// Constraints and from sequence
    static constraints = {
		naam(blank:false)
		adres(blank:false)
		huisnummer(blank:false)
		postcode(blank:false)
		woonplaats(blank:false)
		telefoon(blank:false)
		mobiel()
		email(email:true)
		ophalen()
		opmerkingen()
		inschrijfdatum(blank:false)
    }
	// as it will be shown in the Hond form
	String toString(){
		return "${naam}, ${postcode} ${woonplaats}"
	}

}
