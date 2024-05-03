package com.pluralsight;

import java.util.Scanner;

public class Screens {

    //New method object to access methods
    TransactionsUtil t = new TransactionsUtil();

    /**
     * homeScreen method prints prompt and gets user input for switch case
     * to call appropriate method or quit program
     */
    public void homeScreen() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.print("Welcome to Accounting Ledger\n" +
                    "(D) Deposit\n" +
                    "(P) Payment\n" +
                    "(L) Ledger\n" +
                    "(X) Exit\n");
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
                    System.out.println("Goodbye.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
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
            System.out.print("Ledger\n" +
                    "(A) All\n" +
                    "(D) Deposits \n" +
                    "(P) Payments\n" +
                    "(R) Reports\n" +
                    "(H) Home\n");
            char choice = Character.toUpperCase(scanner.nextLine().charAt(0));
            switch (choice) {
                case 'A':
                    System.out.println("All Entries");
                    t.readFile();
                    break;
                case 'D':
                    System.out.println("Deposits");
                    t.displayDeposits();
                    break;
                case 'P':
                    System.out.println("Payments");
                    t.displayPayments();
                    break;
                case 'R':
                    reportsScreen();
                    break;
                case 'H':
                    running = false;
                    return;
                default:
                    System.out.println("Invalid choice");
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
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }
}