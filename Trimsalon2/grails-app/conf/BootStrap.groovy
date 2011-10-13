import com.dabis.trimsalon.model.Hond
import com.dabis.trimsalon.model.Klant
import com.dabis.trimsalon.model.Producten
import com.dabis.trimsalon.model.User
import com.dabis.trimsalon.model.Calendar
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
			
		def kalender = new Calendar( 
		name:"Kalender",
        color:"Wit",
        textColor:"Zwart") 
		
		kalender.save()
		if(kalender.hasErrors()){
			println kalender.errors
		}
		
		def klant = new Klant(
			naam:"Klant",
			adres:"straat",
			huisnummer:"1",
			postcode:"5342 kk",
			woonplaats:"oss",
			telefoon:"123456789",
			email:"test@test.nl",
			ophalen:"Ja",
			opmerkingen:"Geen")
			
			klant.save()
			if(klant.hasErrors()){
				println klant.errors
			}				
			
		def product = new Producten(
			naam:"Knippen",
			omschrijving:"grote hond knippen",
			ras:"Labrador",
			prijsExbtw:"10",
			voorraad:"1")
			
			product.save()
			if(product.hasErrors()){
			println product.errors
		}
		
	}
	}
}
