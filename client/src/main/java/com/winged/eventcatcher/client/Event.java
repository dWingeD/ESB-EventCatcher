package com.winged.eventcatcher.client;


import java.io.Serializable;
import java.util.Date;


public class Event implements Serializable {

    private Date date;

    private String description;

    private String email;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
