import java.util.*;

public class Checker {

    public static boolean isValid(String company_name, int[] num){
        int length = 0;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nYou chose " + company_name
                + "\nEnter the credit card number to verify: ");
        try {
            long credit_num = keyboard.nextLong();
            length = String.valueOf(credit_num).length();
        }catch (InputMismatchException e){
            System.out.println("Your number is way too long");
        }

        try{
            return  length == num[0] || length == num[1];

        } catch (ArrayIndexOutOfBoundsException e){
            return length == num[0];

        }
    }

    public static void main(String [] args){
        //initializing variables, Scanner, and Hashtable
        String firstName, lastName, company_name;
        Scanner keyboard = new Scanner(System.in);
        Hashtable<String, int[]> companies = new Hashtable<String, int[]>();

        //Most popular credit card company names and some sample credit number length values
        companies.put("visa", new int[] {16});
        companies.put("discover", new int[] {16, 19});
        companies.put("american express", new int[] {15});
        companies.put("mastercard", new int[] {16});

        List<String> companyNames = Arrays.asList("Visa", "Discover", "American Express", "Mastercard");

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
        System.out.println("\nCompanies: Visa  Discover  American Express  Mastercard" +
                "\nPlease enter the name of the credit card company from the list above: ");
        company_name = keyboard.nextLine().toLowerCase();

        boolean creditCardValid = isValid(company_name, companies.get(company_name));

        if (creditCardValid)
            System.out.println("\nYour credit card is valid");
        else
            System.out.println("\nYour credit card is invalid");

        }
    }
