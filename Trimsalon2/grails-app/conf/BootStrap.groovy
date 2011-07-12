import com.dabis.trimsalon.model.Hond
import com.dabis.trimsalon.model.Klant
import com.dabis.trimsalon.model.User
import grails.util.GrailsUtil
	
class BootStrap {

		def init = { servletContext ->
				switch(GrailsUtil.environment){
					case "development":
					def admin = new User(login:"admin",
		password:"wordpass",
		role:"admin",
		naam:"Test admin"
			)
					admin.save()
		if(admin.hasErrors()){
			println admin.errors
	}
		def jdoe = new User(login:"jdoe",
			password:"password",
			role:"user",
			naam:"Test gebruiker"
			)
		jdoe.save()
			if(jdoe.hasErrors()){
				println jdoe.errors
	}
			
			def klant1 = new Klant(
				naam:"Jan janssen",
				adres:"molenstraat",
				huisnummer:"207",
				postcode:"5342CB",
				woonplaats:"Oss",
				telefoon:"0412481966",
				telefoon2:"000000",
				email:"test@test.nl",
				ophalen:"yes",
				opmerkingen:"test",
				dateCReated:"2010/01/10")
			
			klant1.save()
			if(klant1.hasErrors()){
				println klant1.errors
	}
			
			def hond1 = new Hond(
				naam:"Kees",
				ras:"Labrador",
				geslacht:"Reu",
				kleur:"zwart",
				gecastreerd:"Gecastreerd",
				geboortedatum:"2001/01/01",
				klant:"Janssen, 5342CB Oss")
			
			hond1.save()
			if(hond1.hasErrors()){
				println hond1.errors
	}

		}
		}
}
