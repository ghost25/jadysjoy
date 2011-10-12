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
		}
		}
}
