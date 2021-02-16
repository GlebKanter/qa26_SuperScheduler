package com.presentation.scheduler.model;

public class Event {
    String title;
    String type;
    String range;
    int breaks;
    int wage;
    String currency;

    public String getTitle() {
        return title;
    }

    public Event withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getType() {
        return type;
    }

    public Event withType(String type) {
        this.type = type;
        return this;
    }

    public String getRange() {
        return range;
    }

    public Event withRange(String range) {
        this.range = range;
        return this;
    }

    public int getBreaks() {
        return breaks;
    }

    public Event withBreaks(int breaks) {
        this.breaks = breaks;
        return this;
    }

    public int getWage() {
        return wage;
    }

    public Event withWage(int wage) {
        this.wage = wage;
        return this;

    }

    public String getCurrency() {
        return currency;
    }

    public Event withCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}
