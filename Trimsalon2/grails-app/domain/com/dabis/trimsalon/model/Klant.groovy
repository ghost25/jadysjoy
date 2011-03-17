package com.dabis.trimsalon.model

class Klant {
	String naam
	String adres
	String huisnummer
	String postcode
	String woonplaats
	String telefoon
	String mobiel
	String email
	boolean ophalen = false
	String opmerkingen
	Date inschrijfdatum

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
