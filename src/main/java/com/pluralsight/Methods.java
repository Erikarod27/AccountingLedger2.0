package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;
import java.time.LocalDate;

public class Methods {

    //ArrayList of transaction objects
    static ArrayList<Transactions> list = new ArrayList<>();

    //Deposit method
    public void deposits() {
        Scanner scanner = new Scanner(System.in);
        //Prompt user for the deposit information and save it to the csv file
        // ask for date, time, description, vendor, amount
        System.out.print("Date (yyyy-mm-dd): ");
        String date = scanner.nextLine();
        System.out.print("Time (hh:mm:ss): ");
        String time = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Vendor: ");
        String vendor = scanner.nextLine();
        System.out.print("Amount: $");
        double amount = scanner.nextDouble();
        Transactions transaction = new Transactions(date, time, description, vendor, amount, true);
        list.add(transaction);
        saveTransaction(transaction);
    }

    //Make payment method
    public void payments() {
        Scanner scanner = new Scanner(System.in);
        //Prompt user for the debit information and save it to the csv file
        // ask for date, time, description, vendor, amount
        System.out.print("Date (yyyy-mm-dd): ");
        String date = scanner.nextLine();
        System.out.print("Time (hh:mm:ss): ");
        String time = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Vendor: ");
        String vendor = scanner.nextLine();
        System.out.print("Amount: $");
        double amount = scanner.nextDouble();
        amount *=-1;
        Transactions transaction = new Transactions(date, time, description, vendor, amount);
        list.add(transaction);
        saveTransaction(transaction);
    }

    //Month to date method
    public static void monthToDate() {
        System.out.println("Month To Date");
        LocalDate currentDate = LocalDate.now();
        Collections.sort(list, Collections.reverseOrder());
        for (Transactions t : list) {
            if (t.getDate().getMonthValue() == currentDate.getMonthValue()) {
                System.out.println(t);
            }
        }
    }

    //Previous month method
    public static void previousMonth() {
        System.out.println("Previous Month");
        LocalDate currentDate = LocalDate.now();
        LocalDate currentDateMinusMonth = currentDate.minusMonths(1);
        currentDateMinusMonth.getMonthValue();
        Collections.sort(list, Collections.reverseOrder());
        for (Transactions t : list) {
            if ((t.getDate().getMonthValue() == currentDateMinusMonth.getMonthValue()
            && (t.getDate().getYear() == currentDateMinusMonth.getYear()))) {
                System.out.println(t);
            }
        }
    }

    //Year to date method
    public static void yearToDate() {
        System.out.println("Year To Date");
        LocalDate currentDate = LocalDate.now();
        Collections.sort(list, Collections.reverseOrder());
        for (Transactions t : list) {
            if (t.getDate().getYear() == currentDate.getYear()) {
                System.out.println(t);
            }
        }
    }

    //Previous year method
    public static void previousYear() {
        System.out.println("Previous Year");
        LocalDate currentDate = LocalDate.now();
        LocalDate currentDateMinusYear = currentDate.minusYears(1);
        Collections.sort(list, Collections.reverseOrder());
        for (Transactions t : list) {
            if (t.getDate().getYear() == currentDateMinusYear.getYear()) {
                System.out.println(t);
            }
        }
    }

    //Search by vendor method
    public static void searchByVendor() {
        System.out.println("Search By Vendor");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Vendor Name: ");
        String vendorSearch = scanner.nextLine();
        Collections.sort(list, Collections.reverseOrder());
        for (Transactions t : list) {
            if (vendorSearch.equalsIgnoreCase(t.getVendor())) {
                System.out.println(t);
            }
        }
    }

    // Method to save transaction to CSV
    private void saveTransaction(Transactions t) {
        try {
            FileWriter fw = new FileWriter("src/main/resources/transactions.csv", true);
            fw.write("\n" + t.date + "|" + t.time + "|" + t.description + "|" + t.vendor + "|" + t.amount);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get transactions from CSV
    public static ArrayList<String> getTransactions () {
        ArrayList<String> transactions = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/transactions.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                transactions.add(line);
            }
            Collections.sort(transactions, Collections.reverseOrder());
            for (String var : transactions) {
                System.out.println(var);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    //Method to display deposits
    public void displayDeposits() {
        for (Transactions transaction : list) {
            if (transaction.isDeposit == true) {
                System.out.println(transaction);
            }
        }
    }

    //Method to display payments
    public void displayPayments() {
        for (Transactions transaction : list) {
            if (transaction.isDeposit != true) {
                System.out.println(transaction);
            }
        }
    }

    //Read file method
    public static void readFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/transactions.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                String dateString = data[0];
                String timeString = data[1];
                String description = data[2];
                String vendor = data[3];
                Double amount = Double.parseDouble(data[4]);

                if (amount > 0) {
                    Transactions transaction = new Transactions(dateString, timeString, description, vendor, amount, true);
                    list.add(transaction);
                } else {
                    Transactions transaction = new Transactions(dateString, timeString, description, vendor, amount, false);
                    list.add(transaction);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}