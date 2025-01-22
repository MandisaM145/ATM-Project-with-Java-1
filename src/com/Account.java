package com;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$' ###,##0.00");


    public Account() {
    }

    public Account(int customerNumber, int pinNumber) {
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
    }

    public Account(int customerNumber, int pinNumber, double checkingBalance, double savingBalance) {
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
    }
    /* set the customer number */

        public int setCustomerNumber(int customerNumber) {
            this.customerNumber = customerNumber;
            return customerNumber;
    }

    /* get the customer number */
    public int getCustomerNumber() {
        return customerNumber;
    }

    /* set the PIN */
    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }
    /* get the PIN */

    public int getPinNumber() {
        return pinNumber;
    }

    /* get Checking Account Balance */
  public double getCheckingBalance() {
      return checkingBalance;
  }

    /* get Saving Account Balance */
    public double getSavingBalance() {
        return savingBalance;
    }

    /* Calculate checking Account withdrawal */

    public double calcCheckingWithdraw(double amount) {
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    /* Calculate Saving Account withdrawal */
    public double calcSavingWithdraw(double amount) {
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }


    /* Calculate checking Account Deposit */

    public double calcCheckingDeposit(double amount) {
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }

    /* Calculate Saving Account Deposit */
    public double calcSavingDeposit(double amount) {
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    /* Calculate checking Account Withdrawal Input */
     public void getCheckingWithdrawInput() {
         System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
         System.out.print("Amount you want to withdraw from checking Account: ");
         double amount = input.nextDouble();

         if ((checkingBalance - amount) >= 0) {
             calcCheckingWithdraw(amount);
             System.out.println("New checking Account Balance: " + moneyFormat.format(checkingBalance));
         } else {
             System.out.println("Balance cannot be negative." + "\n");
         }
     }

    /* Calculate saving Account Withdrawal Input */

    public void getSavingWithdrawInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount you want to withdraw from Saving Account: ");
        double amount = input.nextDouble();

        if ((savingBalance - amount) >= 0) {
            calcSavingWithdraw(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }
    /* Calculate Checking Account Deposit Input */

    public void getCheckingDepositInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Amount you want to Deposit from checking Account: ");
        double amount = input.nextDouble();

        if ((checkingBalance + amount) >= 0 && amount >= 0) {
            calcCheckingDeposit(amount);
            System.out.println("New checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }

    /* Calculate Saving Account Deposit Input */

    public void getSavingDepositInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount you want to Deposit from Saving Account: ");
        double amount = input.nextDouble();

        if ((savingBalance + amount) >= 0) {
            calcSavingDeposit(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }


    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;


}


