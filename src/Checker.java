import java.util.*;

public class Checker {
    public static void main(String [] args){
        //initializing variables, Scanner, and Hashtable
        String name, company_name;
        int credit_num;
        Scanner keyboard = new Scanner(System.in);
        Hashtable<String, Integer> companies = new Hashtable<String, Integer>();


        //Most popular credit card company names and some sample credit number length values
        companies.put("Visa", 11); 
        companies.put("Discover", 16); 
        companies.put("American Express", 15);
        companies.put("Mastercard", 16);

        System.out.print("Please enter your first and last name to begin: ");
        name = keyboard.nextLine();

        while(name.length() < 2){
            System.out.print("\n\nPlease enter your first and last name again: ");
        }
        if(name.length() > 2){
            System.out.print("\n\nCompanies: " + companies 
            +"\nPlease enter the name of the credit card company from the list above: ");
            company_name = keyboard.nextLine();

            if(company_name.equals("Visa")){
                System.out.println("\n\nYou choose " + company_name
                + "\nEnter the credit card number to verify: ");
                credit_num = keyboard.nextInt();

            } else if(company_name.equals("Discover")){
                System.out.println("\n\nYou choose " + company_name
                + "\nEnter the credit card number to verify: ");
                credit_num = keyboard.nextInt();
            } else if(company_name.equals("American Express")) {
                System.out.println("\n\nYou choose " + company_name
                + "\nEnter the credit card number to verify: ");
                credit_num = keyboard.nextInt();
            } else if(company_name.equals("Mastercard")) {
                System.out.println("\n\nYou choose " + company_name
                + "\nEnter the credit card number to verify: ");
                credit_num = keyboard.nextInt();

        }





        
    }
}
