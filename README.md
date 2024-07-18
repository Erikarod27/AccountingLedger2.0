# Accounting Ledger CLI Application

## Overview

The Accounting Ledger CLI Application is a Java-based tool designed for tracking financial transactions. It provides a command-line interface (CLI) for users to manage deposits, payments, and view transaction history efficiently.

## Features

### Transaction Management:  

- Add deposits with details such as date, time, description, vendor, and amount.

- Record payments with similar detailed information.

### Ledger Display:

- View the entire transaction history.

- Filter to view only deposits or payments.

- Improved display for a more user-friendly experience.

### Financial Reports:

- Generate predefined reports for:

  - Month-to-date

  - Previous month

  - Year-to-date

  - Previous year

### Error Handling:

- Updated error catch mechanisms to ensure smooth and accurate transaction management.

- Clear error messages to guide users in correcting issues.

## Code Highlights

### Comparable Interface

The implements keyword in Java allows access to an interface, such as Comparable.

- Comparable Interface:

- Similar to a class but contains empty methods to be defined with @Override.

- The compareTo method, part of the Comparable interface, enables object comparison.

### compareTo Method

The compareTo method is used for sorting Transactions objects by date.

- Utilizes the compareTo method from LocalDate for date comparison.

- Compares the current object's date with the next object's date:

  - Returns -1 if the current object's date is before the next object's date.

  - Returns 0 if the dates are equal.

  - Returns 1 if the current object's date is after the next object's date.

This method ensures that Transactions objects are sorted in chronological order.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed

### Usage

1. Clone the repository.

2. Navigate to the project directory.

3. Compile and run the application.

4. Use the CLI to add deposits, record payments, and view the ledger.

### License

This project is licensed under the MIT License.


<img width="234" alt="UpdatedLedgerDisplay" src="https://github.com/user-attachments/assets/1d5f968b-ccdb-4105-a7e0-09d97c5eee39"><br>
<img width="369" alt="Reports" src="https://github.com/user-attachments/assets/40317be1-df56-4a52-8604-c086eafaebc8"><br>
<img width="243" alt="Payment" src="https://github.com/user-attachments/assets/1c0ef06f-dda7-41a0-b482-bac9e2163661"><br>
<img width="345" alt="Ledger" src="https://github.com/user-attachments/assets/3e29506d-c616-4d87-b61a-634ebab03667"><br>
<img width="235" alt="Goodbye" src="https://github.com/user-attachments/assets/e46d6cb4-7a56-4b2a-8eeb-87371c30b10c"><br>
<img width="629" alt="AccountLedgerError" src="https://github.com/user-attachments/assets/88fee69f-0dea-4959-a32c-79640555d91d"><br>
