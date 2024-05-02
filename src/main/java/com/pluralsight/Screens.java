package com.pluralsight;

import java.util.Scanner;

public class Screens {

    //Method object to access methods
    static Methods m = new Methods();

    //Home screen method
    public void homeScreen() {
        Scanner scanner = new Scanner(System.in);
        //Continue to run until the user chooses to exit
        boolean running = true;
        while (running) {
            System.out.print("Welcome to Accounting Ledger\n" +
                    "(D) Add Deposit\n" +
                    "(P) Make Payment\n" +
                    "(L) Ledger\n" +
                    "(X) Exit\n");

            char choice = Character.toUpperCase(scanner.nextLine().charAt(0));

            switch (choice) {
                case 'D':
                    //Deposit method
                    m.deposits();
                    break;
                case 'P':
                    //Payment method
                    m.payments();
                    break;
                case 'L':
                    //Ledger screen method
                    ledgerScreen();
                    break;
                case 'X':
                    //Exit the application
                    System.out.println("Goodbye.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }

    //Ledger Screen method
    public static void ledgerScreen() {
        //Create scanner for user input
        Scanner scanner = new Scanner(System.in);
        //Continue to run until the user chooses to exit
        boolean running = true;
        while (running) {
            System.out.print("Ledger\n" +
                    "(A) All\n" +
                    "(D) Deposits \n" +
                    "(P) Payments\n" +
                    "(R) Reports\n" +
                    "(H) Home\n");

            char choice = Character.toUpperCase(scanner.nextLine().charAt(0));

            switch (choice) {
                case 'A':
                    //Display all entries (newest entries first)
                    System.out.println("All Entries");
                    m.getTransactions();
                    break;
                case 'D':
                    //Display only the entries that are deposits into the account
                    System.out.println("Deposits");
                    m.displayDeposits();
                    break;
                case 'P':
                    //Display only the negative entries (or payments)
                    System.out.println("Payments");
                    m.displayPayments();
                    break;
                case 'R':
                    //Display the reports screen
                    reportsScreen();
                    break;
                case 'H':
                    //Go back to the home page
                    running = false;
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    //Reports screen method
    //a new screen that allows the user to run pre-defined reports or to run a custom search
    public static void reportsScreen() {
        //Create scanner for user input
        Scanner scanner = new Scanner(System.in);
        //Continue to run until the user chooses to exit
        boolean running = true;
        while (running) {
            System.out.print("Reports\n" +
                    "(1) Month To Date\n" +
                    "(2) Previous Month\n" +
                    "(3) Year To Date\n" +
                    "(4) Previous Year\n" +
                    "(5) Search By Vendor\n" +
                    "(0) Back\n");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    //Month to date method
                    Methods.monthToDate();
                    break;
                case 2:
                    //Previous month method
                    Methods.previousMonth();
                    break;
                case 3:
                    //Year to date method
                    Methods.yearToDate();
                    break;
                case 4:
                    //Previous year method
                    Methods.previousYear();
                    break;
                case 5:
                    //Search by vendor method
                    //Prompt the user for the vendor name and display all entries for that vendor
                    Methods.searchByVendor();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}