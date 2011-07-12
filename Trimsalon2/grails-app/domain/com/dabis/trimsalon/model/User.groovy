package com.dabis.trimsalon.model

class User {
	
	static searchable = true
	
	String login
	String password
	String naam
	Date indienst
	String role = "user"
	
	static constraints = {
		login(blank:false, nullable:false, unique:true)
		password(blank:false, password:true)
		naam(blank:false)
		indienst(blank:false, nullable:true)
		role(inList:["admin", "user"])
	}
	
	static transients = ['admin']
	
	static hasMany = [afspraken:Afspraak]
	
	boolean isAdmin(){
		return role == "admin"
	}
	
	String toString(){
		login
		return "${login}"
	}
}
