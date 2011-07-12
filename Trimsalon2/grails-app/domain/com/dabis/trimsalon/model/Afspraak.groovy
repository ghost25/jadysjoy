package com.dabis.trimsalon.model

class Afspraak {
	
	static searchable = true
	
	// Fields
	Date datum
	String begintijd
	String eindtijd
	Producten producten
	Hond hond
	Klant klant
	String opmerkingen
	Boolean ophalen
	Boolean afgehandeld
	User user
	
	// Relationships
	static hasOne = [klant:Klant, hond:Hond, producten:Producten, user:User]
	
	// Constraints and form sequence
    static constraints = {
		datum(blank:false)
		begintijd(inList: ["06:00",
							"06:30",
							"07:00",
							"07:30",
							"08:00",
							"08:30",
							"09:00",
							"09:30",
							"10:00",
							"10:30",
							"11:00",
							"11:30",
							"12:00",
							"12:30",
							"13:00",
							"13:30",
							"14:00",
							"14:30",
							"15:00",
							"15:30",
							"16:00",
							"16:30",
							"17:00",
							"17:30",
							"18:00",
							"18:30",
							"19:00",
							"19:30",
							"20:00"])
		eindtijd(inList: ["06:00",
							"06:30",
							"07:00",
							"07:30",
							"08:00",
							"08:30",
							"09:00",
							"09:30",
							"10:00",
							"10:30",
							"11:00",
							"11:30",
							"12:00",
							"12:30",
							"13:00",
							"13:30",
							"14:00",
							"14:30",
							"15:00",
							"15:30",
							"16:00",
							"16:30",
							"17:00",
							"17:30",
							"18:00",
							"18:30",
							"19:00",
							"19:30",
							"20:00"]) 
		producten(unique:true)
		hond(unique:true)
		klant(unique:true)
		opmerkingen()
		ophalen()
		afgehandeld()
		user()
    }
	
	String toString(){
		return "${datum.format('dd-MM-yyyy')} ${klant}"
	}
}
