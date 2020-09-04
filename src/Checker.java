import java.util.Hashtable;
import java.util.Scanner;

public class Checker {

    public static boolean isValid(String company_name, int num){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nYou chose " + company_name
                + "\nEnter the credit card number to verify: ");
        long credit_num = keyboard.nextLong();
        int length = String.valueOf(credit_num).length();
        return  length == num;

    }

    public static void main(String [] args){
        //initializing variables, Scanner, and Hashtable
        String firstName, lastName, company_name;
        Scanner keyboard = new Scanner(System.in);
        Hashtable<String, Integer> companies = new Hashtable<String, Integer>();


        //Most popular credit card company names and some sample credit number length values
        companies.put("visa", 11);
        companies.put("discover", 16);
        companies.put("american express", 15);
        companies.put("mastercard", 16);

        System.out.print("Please enter your first name: ");
        firstName = keyboard.nextLine();
        while(firstName.length() < 2){
            System.out.print("\n\nPlease enter your first name: ");
            firstName = keyboard.nextLine();
        }

        System.out.print("Please enter your last name: ");
        lastName = keyboard.nextLine();
        while(lastName.length() < 2){
            System.out.print("\n\nPlease enter your last name: ");
            lastName = keyboard.nextLine();
        }
        System.out.println("\nHello " + firstName + " " + lastName);
        System.out.println("\nCompanies: " + companies
                + "\nPlease enter the name of the credit card company from the list above: ");
        company_name = keyboard.nextLine().toLowerCase();

        boolean creditCardValid = isValid(company_name, companies.get(company_name));

        if (creditCardValid)
            System.out.println("\nYour credit card is valid");
        else
            System.out.println("\nYour credit card is invalid");

        }
    }
