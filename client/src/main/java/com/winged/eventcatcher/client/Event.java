package com.winged.eventcatcher.client;


import java.util.Date;


public class Event {

    private Date date;

    private String description;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
