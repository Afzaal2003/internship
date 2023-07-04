import java.util.*;

public class ATM {
    static Scanner sc;
    static int bal,i;
    static String trh[];
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        bal = 0;
        i = 0;
        trh = new String[100];
        String name, user_name, user_name_check;
        int password, password_check;
        boolean exit = true;
        System.out.println("Enter your details below:-");
        System.out.println("Enter your full name:");
        name = sc.nextLine();
        System.out.println("Enter your user name:");
        user_name = sc.nextLine();
        System.out.println("Enter your password:");
        password = sc.nextInt();
        System.out.println("Registration is successfully done.");
        System.out.println("Now to start the transaction please enter your username and passwd");
        while (true) {
            System.out.println("User Name:");
            user_name_check = sc.nextLine();
            if (user_name_check.equals(user_name)) {
                System.out.println("Password:");
                password_check = sc.nextInt();
                if (password_check == password) {
                    exit = false;
                } else
                    System.out.println("Wrong Credentials,Re enter it");
            }
            if (exit == false)
                break;
        }
        while (!exit) {
            System.out.println("Welcome to the Afzaal's Techno International ATM!");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    checkBal();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    transaction_history();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Thank you " + name);
                    break;
                default:
                    System.out.println("Enter proper choice.");
                    break;
            }
        }
    }

    static void checkBal() {
        System.out.println("Account Balance: Rs " + bal);
    }

    static void withdraw() {
        int with, bc;
        System.out.print("Enter the amount to be withdrawn: Rs ");
        with = sc.nextInt();
        System.out.println();
        bc = bal - with;
        if (bc >= 0) {
            System.out.println("The amount has been withdrawn");
            bal = bc;
            trh[i] = with + "withdrawn";// for trh
            i++;
        } else
            System.out.println("The amount cannot be withdrawn as it exceeds the balance");
    }

    static void deposit() {
        int dep;
        System.out.print("Enter the amount to be deposited: Rs ");
        dep = sc.nextInt();
        System.out.println();
        bal += dep;
        System.out.println("The amount has been deposited");
        trh[i] = dep + "deposited";// for trh
        i++;
    }

    static void transfer() {
        int trans, bc;
        System.out.print("Enter the amount to be transferred: Rs ");
        trans = sc.nextInt();
        System.out.println();
        bc = bal - trans;
        if (bc >= 0) {
            System.out.println("The amount has been transferred");
            bal = bc;
            trh[i] = trans + "transferred";// for trh
            i++;
        } else
            System.out.println("The amount cannot be transferred as it exceeds the balance");
    }

    static void transaction_history() {
        System.out.println("The transaction History is:-");
        for (int j = 0; j < i; j++)
            System.out.println(trh[j]);
    }
}