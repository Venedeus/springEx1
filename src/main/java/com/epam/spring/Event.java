package com.epam.spring;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Evgeniy_Shvetsov on 2/1/2018.
 */
public class Event {
    private int id;
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df) {
        id = new SecureRandom().nextInt(100);
        this.date = date;
        this.df = df;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event #" + id + ": [" + df.format(date) + "] - " + msg;
    }
}
