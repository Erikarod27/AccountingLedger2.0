package com.pluralsight;

import java.util.Scanner;

public class Screens {

    //New method object to access methods
    TransactionsUtil t = new TransactionsUtil();

    /**
     * homeScreen method prints prompt and gets user input for switch case
     * to call appropriate method or quit program
     */

    // creating static colors for aesthetic purposes
    public static final String RED = "\u001B[31m";
    public static final String BRIGHT_WHITE = "\u001B[97m";
    public static final String BRIGHT_GREEN = "\u001B[92m";
    public static final String BOLD = "\u001B[1m";
    public static final String ANSI_RESET = "\u001B[0m";

    public void homeScreen() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.print(BRIGHT_WHITE + "------------------------------------\n");
            System.out.print("Welcome to Accounting Ledger\n" +
                    "(D) Deposit\n" +
                    "(P) Payment\n" +
                    "(L) Ledger\n" +
                    "(X) Exit\n");

            System.out.print("------------------------------------\n");
            System.out.print("Enter Choice: ");
            char choice = Character.toUpperCase(scanner.nextLine().charAt(0));
            switch (choice) {
                case 'D':
                    t.deposits();
                    break;
                case 'P':
                    t.payments();
                    break;
                case 'L':
                    ledgerScreen();
                    break;
                case 'X':
                    System.out.println(BRIGHT_WHITE + "Goodbye.");
                    running = false;
                    break;
                default:
                    System.out.println(RED + "Invalid choice");
            }
        }
        scanner.close();
    }

    /**
     * ledgerScreen method prints prompt and gets user input for switch case
     * to call appropriate method or return home
     */
    public void ledgerScreen() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.print(BRIGHT_WHITE + "----------------------------\n");
            System.out.print("Ledger\n" +
                    "(A) All\n" +
                    "(D) Deposits \n" +
                    "(P) Payments\n" +
                    "(R) Reports\n" +
                    "(S) Custom Search\n" +
                    "(H) Home\n");
            System.out.print("-------------------------------\n");
            char choice = Character.toUpperCase(scanner.nextLine().charAt(0));
            switch (choice) {
                case 'A':
                    System.out.println(BRIGHT_WHITE + "All Entries");
                    t.readFile();
                    break;
                case 'D':
                    System.out.println(BRIGHT_WHITE + "Deposits");
                    t.displayDeposits();
                    break;
                case 'P':
                    System.out.println(BRIGHT_WHITE + "Payments");
                    t.displayPayments();
                    break;
                case 'R':
                    reportsScreen();
                    break;
                case 'H':
                    running = false;
                    return;
                default:
                    System.out.println(RED + "Invalid choice");
            }
        }
        scanner.close();
    }

    /**
     * reportsScreen method prints prompt and gets input for switch case
     * to call the appropriate method or return to ledger screen
     */
    public void reportsScreen() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.print("-----------------------------------------\n");
            System.out.print("Reports\n" +
                    "(1) Month To Date\n" +
                    "(2) Previous Month\n" +
                    "(3) Year To Date\n" +
                    "(4) Previous Year\n" +
                    "(5) Search By Vendor\n" +
                    "(6) Custom Search\n" +
                    "(0) Back\n");
            System.out.print("--------------------------------------------\n");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    t.monthToDate();
                    break;
                case 2:
                    t.previousMonth();
                    break;
                case 3:
                    t.yearToDate();
                    break;
                case 4:
                    t.previousYear();
                    break;
                case 5:
                    t.searchByVendor();
                    break;
                case 6:
                    //create customSearch method
                    t.customSearch();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }
}