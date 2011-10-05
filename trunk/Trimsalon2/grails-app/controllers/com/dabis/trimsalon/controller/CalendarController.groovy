package com.dabis.trimsalon.controller
import com.dabis.trimsalon.model.Calendar

class CalendarController {

    def scaffold = com.dabis.trimsalon.model.Calendar

    def json={
        render createJSON(Long.parseLong(params.id))
    }

    private String createJSON(long id){
        def json="["
        boolean first=true
        Calendar c=Calendar.get(id)
        c.afspraak.each{
            if(first){
                first=false
                json+="{"
            }
            else {
                json+=",{"
            }
            json+="title:\""+it.omschrijving+"\","
            json+="start:'"+it.begindatum+"',"
            json+="end:'"+it.einddatum+"',"
            json+="allDay:"+it.allDay+","
            json+="url:\"${request.contextPath}/afspraak/show/"+it.id+"\","
            json+="backgroundColor:'"+c.color+"',"
            json+="textColor:'"+c.textColor+"'"
            json+="}"
        }
        json+="]"
        return json
    }


    def ical={
        render createIcal(Long.parseLong(params.id))
    }

    private String createIcal(long id){
        def df=new java.text.SimpleDateFormat("yyyyMMdd'T'HHmmss")
        Calendar c=Calendar.get(id)
        def ical='''BEGIN:VCALENDAR
X-WR-CALNAME:'''+c.name+'''
X-WR-CALDESC:GRAILS Plugin Calendar
PRODID:-//Francois-Xavier Thoorens/NONSGML Bennu 0.1//EN
VERSION:2.0
'''
        c.afspraak.each{
            ical+="BEGIN:VEVENT\n"
            ical+="UID:"+c.name+it.id+"@grails\n"
            ical+="DTSTAMP:"+df.format(new Date())+"Z\n"
            ical+="SUMMARY:"+it.omschrijving+"\n"
            ical+="DTSTART:"+df.format(it.begindatum)+"\n"
            ical+="DTEND:"+df.format(it.einddatum)+"\n"
            ical+="DESCRIPTION:"+it.hond+"\n"
            ical+="LOCATION:"+it.klant+"\n"
            ical+="END:VEVENT\n"
        }
        ical+="END:VCALENDAR\n"
        return ical
    }

}
