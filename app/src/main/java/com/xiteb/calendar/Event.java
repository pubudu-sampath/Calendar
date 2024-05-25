package com.xiteb.calendar;

public class Event {

    String title;
    String note;
    String date;

    public Event(String title, String note, String date) {
        this.title = title;
        this.note = note;
        this.date = date;
    }

    public Event(String title, String note) {
        this.title = title;
        this.note = note;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
