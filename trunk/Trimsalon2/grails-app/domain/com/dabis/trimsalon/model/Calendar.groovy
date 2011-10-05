package com.dabis.trimsalon.model

class Calendar {

    String name
    String color
    String textColor
    SortedSet events

    static hasMany = [afspraak:Afspraak]

    static constraints = {
        name()
        color()
        textColor()
    }

    public String toString(){
        name
    }
}
