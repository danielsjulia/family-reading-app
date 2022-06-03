package com.techelevator.model;

import java.time.LocalDateTime;
import java.util.Date;

public class ReadingLog {

    private int readingLog_id;
    private int minutes;
    private String format;
    private Date date;
    private int starting_page;
    private int end_page;
    private int book_id;
    private int user_id;
    private String notes;

    public ReadingLog() {
    }

    public ReadingLog(int readingLog_id, int minutes, String format, Date date, int starting_page,
                      int end_page, int book_id, int user_id, String notes) {
        this.readingLog_id = readingLog_id;
        this.minutes = minutes;
        this.format = format;
        this.date = date;
        this.starting_page = starting_page;
        this.end_page = end_page;
        this.book_id = book_id;
        this.user_id = user_id;
        this.notes = notes;
    }

    public int getReadingLog_id() {
        return readingLog_id;
    }

    public void setReadingLog_id(int readingLog_id) {
        this.readingLog_id = readingLog_id;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStarting_page() {
        return starting_page;
    }

    public void setStarting_page(int starting_page) {
        this.starting_page = starting_page;
    }

    public int getEnd_page() {
        return end_page;
    }

    public void setEnd_page(int end_page) {
        this.end_page = end_page;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
