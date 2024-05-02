package com.pluralsight;

public class Main {

    //Main method
    public static void main(String[] args) throws NumberFormatException {
    //Get transactions from file
        Methods.readFile();

        Screens s = new Screens();
        s.homeScreen();
    }
}