package com.example.therdsak.keepwalking;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Therdsak on 7/27/2016.
 */
public class Number {

    private UUID id;
    private String title;
    private Date date;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id)
    {
        this.id = id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date) {

        this.date = date;
    }

    public Number(){
        id = UUID.randomUUID();
        date = new Date();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UUID=").append(id);
        builder.append(",Title=").append(title);
        builder.append(",Date=").append(date);
        return builder.toString();
    }
}