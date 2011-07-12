package com.dabis.trimsalon.model

class Klant {
	static searchable = true
	
	// Fields
	String naam
	String adres
	String huisnummer
	String postcode
	String woonplaats
	String telefoon
	String telefoon2
	String email
	Boolean ophalen = false
	String opmerkingen
	Date dateCreated
	
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
		telefoon2()
		email(email:true)
		ophalen()
		opmerkingen()
		dateCreated()
    }
	
	// as it will be shown in the Hond form
	String toString(){
		return "${naam}, ${postcode} ${woonplaats}"
	}

}
