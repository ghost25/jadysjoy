package com.dabis.trimsalon.model

class User {
	String login
	String password
	String role = "user"
	//String naam
	//Date indienst

	static constraints = {
		login(blank:false, nullable:false, unique:true)
		password(blank:false, password:true)
		//naam()
		//indienst(blank:false)
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
