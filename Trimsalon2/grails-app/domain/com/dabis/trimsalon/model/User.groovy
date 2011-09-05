package com.dabis.trimsalon.model

class User {
	
	static searchable = true
	
	String login
	String password
	String naam
	String role = "user"
	
	static constraints = {
		login(blank:false, nullable:false, unique:true)
		password(blank:false, password:true, size: 4..8)
		naam(blank:false)
		role(inList:["admin", "user"])
	}
	
	static transients = ['admin']
	
	static hasMany = [afspraken:Afspraak]
	
	boolean isAdmin(){
		return role == "admin"
	}
	
	String toString(){
		return "${login}"
	}
}
