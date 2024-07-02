package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;
import java.time.LocalDate;

public class TransactionsUtil {

     //ArrayList object with Transactions objects as elements in list
     static ArrayList<Transactions> list = new ArrayList<>();

    /**
     * deposits method prints prompt and assigns input to variables, stringDate and stringTime
     * get converted to LocalDate and LocalTime, amount is parsed to double
     * Transactions object is created using variables as parameters and isDeposit set to true
     */
    public void deposits() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Date (yyyy-mm-dd): ");
        String stringDate = scanner.nextLine();
        LocalDate date = Transactions.convertDate(stringDate);
        System.out.print("Time (hh:mm:ss): ");
        String stringTime = scanner.nextLine();
        LocalTime time = Transactions.convertTime(stringTime);
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

    /**
     * payments method prints prompt and assigns input to variables, stringDate and stringTime
     * are converted to LocalDate and LocalTime, amount is parsed to double
     * amount is multiplied by -1 to turn to a negative transaction
     * Transactions object is created using variables as parameters and isDeposit set to false
     */
    public void payments() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("-------------------------------------------");
        System.out.print("Date (yyyy-mm-dd): ");
        String stringDate = scanner.nextLine();
        LocalDate date = Transactions.convertDate(stringDate);
        System.out.print("-------------------------------------------");
        System.out.print("Time (hh:mm:ss): ");
        String stringTime = scanner.nextLine();
        LocalTime time = Transactions.convertTime(stringTime);
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Vendor: ");
        String vendor = scanner.nextLine();
        System.out.print("Amount: $");
        double amount = scanner.nextDouble();
        amount *=-1;
        Transactions transaction = new Transactions(date, time, description, vendor, amount, false);
        list.add(transaction);
        saveTransaction(transaction);
    }

    /**
     * monthToDate method uses LocalDate class to get current date
     * Collections class sorts list in reverse order then iterates objects in list
     * If object month and year matches currentDate object is printed
     */
    public void monthToDate() {
        System.out.println("Month To Date");
        LocalDate currentDate = LocalDate.now();
        Collections.sort(list, Collections.reverseOrder());
        for (Transactions t : list) {
            if ((t.getDate().getMonthValue() == currentDate.getMonthValue())
            && (t.getDate().getYear() == currentDate.getYear())) {
                System.out.println(t);
            }
        }
    }

    /**
     * previousMonth method uses LocalDate class to get current date and subtract month
     * Collections class sorts list in reverse order then iterates objects in list
     * If object month and year matches currentDateMinusMonth object is printed
     */
    public void previousMonth() {
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

    /**
     * yearToDate method uses LocalDate class to get current date
     * Collections class sorts list in reverse order then iterates objects in list
     * If object year matches currentDate year object is printed
     */
    public void yearToDate() {
        System.out.println("Year To Date");
        LocalDate currentDate = LocalDate.now();
        Collections.sort(list, Collections.reverseOrder());
        for (Transactions t : list) {
            if (t.getDate().getYear() == currentDate.getYear()) {
                System.out.println(t);
            }
        }
    }

    /**
     * previousYear method uses LocalDate class to get current date and subtract year
     * Collections class sorts list in reverse order then iterates objects in list
     * If object year matches currentDateMinusYear object is printed
     */
    public void previousYear() {
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

    /**
     * searchByVendor method uses collections class to sort list in reverse order
     * then iterates Transaction objects in list, comparing vendorSearch input
     * if vendorSearch equals object vendor, object is printed
     */
    public void searchByVendor() {
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

    //Implement code for customSearch method
    //User should be able to search by start date, end date,
    //description, vendor, and amount
    public void customSearch(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Start Date (yyyy-mm-dd): ");
        String startDateInput = scanner.nextLine();
        LocalDate startDate = startDateInput.isEmpty() ? null : Transactions.convertDate(startDateInput);

        System.out.print("End Date (yyyy-mm-dd): ");
        String endDateInput = scanner.nextLine();
        LocalDate endDate = endDateInput.isEmpty() ? null : Transactions.convertDate(endDateInput);

        System.out.print("Description");
        String description = scanner.nextLine();
        description = description.isEmpty() ? null : description;

        System.out.print("Vendor: ");
        String vendor = scanner.nextLine();
        vendor = vendor.isEmpty() ? null : vendor;

        System.out.print("Amount: $");
        String amountInput = scanner.nextLine();
        Double amount = amountInput.isEmpty() ? null : Double.parseDouble(amountInput);

        // Filter transactions based on input
        ArrayList<Transactions> filteredTransactions = new ArrayList<>();
        for (Transactions transaction : list) {
            boolean matches = true;

            if (startDate != null && transaction.getDate().isBefore(startDate)) {
                matches = false;
            }
            if (endDate != null && transaction.getDate().isAfter(endDate)) {
                matches = false;
            }
            if (description != null && !transaction.getDescription().equalsIgnoreCase(description)) {
                matches = false;
            }
            if (vendor != null && !transaction.getVendor().equalsIgnoreCase(vendor)) {
                matches = false;
            }
            if (amount != null && transaction.getAmount() != amount) {
                matches = false;
            }

            if (matches) {
                filteredTransactions.add(transaction);
            }
        }

        // Sort and print the filtered transactions
        Collections.sort(filteredTransactions, Collections.reverseOrder());
        for (Transactions transaction : filteredTransactions) {
            System.out.println(transaction);
        }

    }

    /**
     * saveTransaction method has Transaction object parameter
     * FileWriter appends object parameters to transactions.csv file
     * using date|time|description|vendor|amount format
     */
    private void saveTransaction(Transactions t) {
        try {
            FileWriter fw = new FileWriter("src/main/resources/transactions.csv", true);
            fw.write("\n" + t.date + "|" + t.time + "|" + t.description + "|" + t.vendor + "|" + t.amount);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * displayDeposits method iterates through Transaction objecs in list
     * if isDeposit boolean is true the object is printed
     */
    //Method to display deposits
    public void displayDeposits() {
        for (Transactions transaction : list) {
            if (transaction.isDeposit == true) {
                System.out.println(transaction);
            }
        }
    }

    /**
     * displayPayments method iterates through Transaction objects in list
     * If isDeposit boolean is false the object is printed
     */
    //Method to display payments
    public void displayPayments() {
        for (Transactions transaction : list) {
            if (transaction.isDeposit != true) {
                System.out.println(transaction);
            }
        }
    }

    /**
     * readFile method uses BufferedReader and FileReader to read transactions.csv file
     * Lines are added to line variable and While loop is used to read file until null
     * line is split into String array by | into a and values are assigned to variables
     * Amount gets parsed from string and converted to a double
     * If amount is greater than 0 Transaction object's created with isDeposit parameter set to true
     * Else amount is less than 0 and Transaction object's created with isDeposit set to false
     * Collections class sorts list in reverse order then iterates through objects in list while printing
     */
    public static void readFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/transactions.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                LocalDate date = Transactions.convertDate(data[0]);
                LocalTime time = Transactions.convertTime(data[1]);
                String description = data[2];
                String vendor = data[3];
                double amount = Double.parseDouble(data[4]);
                if (amount > 0) {
                    Transactions transaction = new Transactions(date, time, description, vendor, amount, true);
                    list.add(transaction);
                } else {
                    Transactions transaction = new Transactions(date, time, description, vendor, amount, false);
                    list.add(transaction);
                }
            }
            Collections.sort(list, Collections.reverseOrder());
            for (Transactions t : list) {
                System.out.println(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchByStartDate() {
        
    }
}