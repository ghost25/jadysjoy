package com.dabis.trimsalon.model

class Afspraak implements Comparable{
	
	static searchable = true
	
	// Fields
	String omschrijving
	Date begindatum
	Date einddatum
	Producten producten
	Hond hond
	String ophalen
	String opmerkingen
	boolean afgehandeld
	User user
	Boolean allDay=Boolean.FALSE
	Calendar calendar
	
	// Relationships
	static hasOne = [hond:Hond, user:User]
	static belongsTo = [calendar:Calendar]
		
	// Constraints and form sequence
    static constraints = {
		omschrijving()
		begindatum(attributes:[precision:"minute"])
		einddatum(attributes:[precision:"minute"])
		allDay()
		producten(blank:false)
		hond(blank:false)
		ophalen(inList: ["Nee", "Ja"])
		opmerkingen()
		afgehandeld()
		user()
    }

public int compareTo(Object that){
	begindatum.compareTo(that.begindatum)
}
	
	String toString(){
		return "${begindatum.format('dd-MM-yyyy')} ${hond}"
	}
}
