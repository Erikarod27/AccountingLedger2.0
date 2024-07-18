Accounting Ledger CLI Application

Overview

The Accounting Ledger CLI Application is a Java-based tool designed for tracking financial transactions. It provides a command-line interface (CLI) for users to manage deposits, payments, and view transaction history efficiently.

Features

Transaction Management:

Add deposits with details such as date, time, description, vendor, and amount.

Record payments with similar detailed information.

Ledger Display:

View the entire transaction history.

Filter to view only deposits or payments.

Improved display for a more user-friendly experience.

Financial Reports:

Generate predefined reports for:

Month-to-date

Previous month

Year-to-date

Previous year

Error Handling:

Updated error catch mechanisms to ensure smooth and accurate transaction management.

Clear error messages to guide users in correcting issues.

Code Highlights

Comparable Interface

The implements keyword in Java allows access to an interface, such as Comparable.

Comparable Interface:

Similar to a class but contains empty methods to be defined with @Override.

The compareTo method, part of the Comparable interface, enables object comparison.

compareTo Method

The compareTo method is used for sorting Transactions objects by date.

Utilizes the compareTo method from LocalDate for date comparison.

Compares the current object's date with the next object's date:

Returns -1 if the current object's date is before the next object's date.

Returns 0 if the dates are equal.

Returns 1 if the current object's date is after the next object's date.

This method ensures that Transactions objects are sorted in chronological order.

Getting Started

Prerequisites

Java Development Kit (JDK) installed

Usage

Clone the repository.

Navigate to the project directory.

Compile and run the application.

Use the CLI to add deposits, record payments, and view the ledger.

License

This project is licensed under the MIT License.

