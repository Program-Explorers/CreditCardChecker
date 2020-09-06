import java.util.*;

public class Checker {
    private static long CREDIT_NUM;
    private static Scanner keyboard = new Scanner(System.in);
    public static boolean isValid(String company_name, int[] num) {
        int length = 0;
        System.out.println("\nYou chose " + company_name
                + "\nEnter the credit card number to verify: ");
        try {
            CREDIT_NUM = keyboard.nextLong();
            length = String.valueOf(CREDIT_NUM).length();
        } catch (InputMismatchException e) {
            System.out.println("Your number is way too long");
        }

        try {
            return length == num[0] || length == num[1];

        } catch (ArrayIndexOutOfBoundsException e) {
            return length == num[0];

        }
    }

    public static int evenPlace(long number){
        int totalSum = 0;
        String num = number + "";
        System.out.println(num);
        for (int i = num.length() - 2; i >= 0; i -= 2)
            totalSum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);

        return totalSum;
    }
    public static int getDigit(int number) {
        if (number < 9) {
            return number;
        }
        return number / 10 + number % 10;
    }

    public static void main(String[] args) {
        //initializing variables, Scanner, and Hashtable
        String firstName, lastName, company_name;
        HashMap<String, int[]> companies = new HashMap<String, int[]>();

        //Most popular credit card company names and some sample credit number length values
        companies.put("visa", new int[]{16});
        companies.put("discover", new int[]{16, 19});
        companies.put("american express", new int[]{15});
        companies.put("mastercard", new int[]{16});

        System.out.print("Please enter your first name: ");
        firstName = keyboard.nextLine();
        while (firstName.length() < 2) {
            System.out.print("\n\nPlease enter your first name: ");
            firstName = keyboard.nextLine();
        }

        System.out.print("Please enter your last name: ");
        lastName = keyboard.nextLine();
        while (lastName.length() < 2) {
            System.out.print("\n\nPlease enter your last name: ");
            lastName = keyboard.nextLine();
        }

        System.out.println("\nHello " + firstName + " " + lastName);
        System.out.println("\nCompanies: Visa  Discover  American Express  Mastercard" +
                "\nPlease enter the name of the credit card company from the list above: ");
        company_name = keyboard.nextLine().toLowerCase();

        boolean creditCardValid = isValid(company_name, companies.get(company_name));

        if (creditCardValid) {
            System.out.print(evenPlace(CREDIT_NUM));

        }
        else {
            System.out.println("\nYour credit card is invalid");
        }

    }
}