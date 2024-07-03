package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

import static java.util.Locale.filter;

public class Transactions implements Comparable<Transactions> {
    //Instance variables
    LocalDate date;
    LocalTime time;
    String description;
    String vendor;
    double amount;
    boolean isDeposit;

    //ArrayList object with Transactions objects as elements in list
    static ArrayList<Transactions> list = new ArrayList<>();

    //Getters and setters for instance variables
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    //Transactions constructor with 1 LocalDate, 1 LocalTime, 2 String, 1 double, and 1 boolean parameter
    public Transactions(LocalDate date, LocalTime time, String description, String vendor, double amount, boolean isDeposit) {
        this.date = convertDate(String.valueOf(date));
        this.time = convertTime(String.valueOf(time));
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
        this.isDeposit = isDeposit;
  }

    /**
     * convertDate method has string parameter and returns LocalDate
     * DateTimeFormatter formats stringDate to LocalDate then returns it
     */
    public static LocalDate convertDate(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate convertedDate = LocalDate.parse(stringDate, formatter);
            return convertedDate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * convertTime method has string parameter and returns LocalTime
     * DateTimeFormatter formats stringTime to LocalTime then returns it
     */
    public static LocalTime convertTime(String stringTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        try {
            LocalTime convertedTime = LocalTime.parse(stringTime, formatter);
            return convertedTime;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Overrides compareTo method to sort arrayList of Transactions
    @Override
    public int compareTo(Transactions o) {
        return getDate().compareTo(o.getDate());
    }

    //Override toString for custom way to display transactions object
    @Override
    public String toString() {
        return date + "|" + time + "|" + description + "|" + vendor + "|" + amount;
    }
}