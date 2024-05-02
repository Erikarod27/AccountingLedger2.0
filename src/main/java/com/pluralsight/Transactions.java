package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Transactions implements Comparable<Transactions> {

    LocalDate date;
    LocalTime time;
    String description;
    String vendor;
    double amount;
    boolean isDeposit;

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

    //Transactions constructor
    public Transactions(String stringDate, String stringTime, String description, String vendor, double amount, boolean isDeposit) {
        this.date = convertDate(stringDate);
        this.time = convertTime(stringTime);
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
        this.isDeposit = isDeposit;
  }

    //Overloading Transactions constructor
    public Transactions(String stringDate, String stringTime, String description, String vendor, double amount) {
        this.date = convertDate(stringDate);
        this.time = convertTime(stringTime);
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
        this.isDeposit = false;
    }

    //Convert date method
    private LocalDate convertDate(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate convertedDate = LocalDate.parse(stringDate, formatter);
            return convertedDate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Convert time method
    private LocalTime convertTime(String stringTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        try {
            LocalTime convertedTime = LocalTime.parse(stringTime, formatter);
            return convertedTime;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Overrides compare method to sort arrayList of Transactions
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