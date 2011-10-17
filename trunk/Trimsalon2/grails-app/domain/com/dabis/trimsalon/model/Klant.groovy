package com.dabis.trimsalon.model

class Klant {
	static searchable = true
	
	// Fields
	String naam
	String adres
	String huisnummer
	String postcode
	String woonplaats
	Integer telefoon
	String email
	String opmerkingen
	Date dateCreated
	
	// Relationships
	static hasMany = [hond:Hond, afspraken:Afspraak]
	
	// Constraints and from sequence
    static constraints = {
		naam(blank:false)
		adres(blank:false)
		huisnummer(blank:false, maxlengt:4)
		postcode(blank:false, matches:/^[1-9][0-9]{3}[\s]([A-Z]|[a-z]){2}$/)
		woonplaats(blank:false)
		telefoon(blank:false, maxLength:11, minLength:10)
		email(email:true)
		opmerkingen()
		dateCreated()
    }
	
	// as it will be shown in the Hond form
	String toString(){
		return "${naam}, ${woonplaats}"
	}

}

