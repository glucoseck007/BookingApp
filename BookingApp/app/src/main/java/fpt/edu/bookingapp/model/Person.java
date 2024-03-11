package fpt.edu.bookingapp.model;

import java.util.Date;

public class Person {

    private int id;
    private String name;
    private Date date;
    private int value;

    public Person() {};
    public Person(int id, String name, Date date, int value) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
