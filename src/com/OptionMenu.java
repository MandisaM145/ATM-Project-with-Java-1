package com;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class OptionMenu {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Account> data = new HashMap<Integer, Account>();

    public void getLogin() throws IOException {
        boolean end = false;
        int customerNumber = 0;
        int pinNumber = 0;
        while (!end) {
            try {

                data.put(952141, new Account(952141, 191904, 1000, 3000));
                data.put(123, new Account(123, 121, 20000, 50000));
                data.put(952356, new Account(952356, 191905, 1000, 5000));
                data.put(124, new Account(124, 122, 60000, 40000));

                System.out.print("\nEnter your customer number: ");
                customerNumber = menuInput.nextInt();
                System.out.print("\nEnter your PIN number: ");
                pinNumber = menuInput.nextInt();
                Iterator it = data.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    Account acc = (Account) pair.getValue();
                    if (data.containsKey(customerNumber) && pinNumber == acc.getPinNumber()) {
                        getAccountType(acc);
                        end = true;
                        break;
                    }
                }
                if (!end) {
                    System.out.println("\nWrong Customer Number or Pin Number");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Character(s). Only Numbers.");
            }
        }
    }
/* Display Account Type Menu with Selection*/

    public void getAccountType(Account acc) {

        boolean end = false;
        while (!end) {
            try {

                System.out.println("Select the Account you want to access: ");
                System.out.println("Type 1 - Checking Account");
                System.out.println("Type 2 - Savings Account");
                System.out.println("Type 3 - Exit");
                System.out.print("Choice: ");

                int selection = menuInput.nextInt();

                switch (selection) {
                    case 1:
                        getChecking(acc);
                        break;
                    case 2:
                        getSaving(acc);
                        break;
                    case 3:
                        System.out.println("Thank you for using this ATM, bye.");
                        break;

                    case 4:
                        end = true;
                        break;

                    default:
                        System.out.println("\n" + "Invalid choice: " + selection);
                        getAccountType(acc);
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                menuInput.next();
            }
        }
    }
    /* Display Account Type Menu with Selection*/
    public void getChecking(Account acc) {
        boolean end = false;
        while (!end) {
            try
            {
        System.out.println("Checking Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice: ");

       int selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("\nChecking Account Balance: " + moneyFormat.format(acc.getSavingBalance()));
                getAccountType(acc);
                break;
            case 2:
                acc.getCheckingWithdrawInput();
                getAccountType(acc);
                break;
            case 3:
                acc.getCheckingDepositInput();
                getAccountType(acc);
                break;
            case 4: System.out.println(" Thank you for using this ATM, bye.");
                break;
            case 5:
                end = true;
                break;

            default:
                System.out.println("\nInvalid choice: " + selection);
            getChecking(acc);

        }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                menuInput.next();
            }


    }
    }


    public void getSaving(Account acc) {
        System.out.println("Saving Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("Saving Account balance: " + moneyFormat.format(acc.getSavingBalance()));
                getAccountType(acc);
                break;
            case 2:
                acc.getSavingWithdrawInput();
                getAccountType(acc);
                break;
            case 3:
                acc.getSavingDepositInput();
                getAccountType(acc);
                break;
            case 4: System.out.println(" Thank you for using this ATM, bye.");
                break;

            default:
                System.out.println("\n"+"Invalid choice: " + selection);
                getSaving(acc);

        }
    }

}












