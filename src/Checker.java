import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Checker {
    private static final Scanner keyboard = new Scanner(System.in);
    private static String CREDIT_NUM;
    private static int[] num1;

    public static boolean isValid(String titledName, String company_name, int[] num) {
        int length;
        System.out.println("\nYou chose " + titledName
                + "\nEnter the credit card number to verify (NoSpaces): ");
        CREDIT_NUM = keyboard.nextLine();
        length = String.valueOf(CREDIT_NUM).length();
        try {
            if (length == num[0] || length == num[1]) {
                num1 = new int[CREDIT_NUM.length()];
                for (int i = 0; i < CREDIT_NUM.length(); i++) {
                    num1[i] = CREDIT_NUM.charAt(i) - '0';
                }
                switch (company_name) {
                    case "visa":
                        return num1[0] == 4;
                    case "discover":
                        return num1[0] == 6;
                    case "mastercard":
                        return num1[0] == 5;
                    default:
                        return num1[0] == 3 && num1[1] == 7 || num1[0] == 3 && num1[1] == 4;
                }
            } else {
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            if (length == num[0]) {
                switch (company_name) {
                    case "visa":
                        return num1.length == 16 || num1.length == 18 || num1.length == 19;
                    case "discover":
                        return num1.length == 16 || num1.length == 19;
                    case "mastercard":
                        return num1.length == 16;
                    default:
                        return num1.length == 15;
                }
            } else {
                return false;
            }

        }
    }

    public static int evenPlace(String number1) {
        long number = Long.parseLong(number1);
        int totalSum = 0;
        String num = number + "";
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

    public static boolean runLuhnAlgo(String str) {
        int[] ints = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ints[i] = Integer.parseInt(str.substring(i, i + 1));
        }
        for (int i = ints.length - 2; i >= 0; i = i - 2) {
            int j = ints[i];
            j = j * 2;
            if (j > 9) {
                j = j % 10 + 1;
            }
            ints[i] = j;
        }
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
        }
        return sum % 10 == 0;
    }

    public static void main(String[] args) {
        //initializing variables, Scanner, and Hashtable
        String firstName, lastName, company_name;
        HashMap<String, int[]> companies = new HashMap<>();

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
        List<String> companyNamesTitled = Arrays.asList("Visa", "Discover", "American Express", "MasterCard");

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
        String titledName = "Mastercard";
        if (company_name.toUpperCase().equals(companyNamesTitled.get(0).toUpperCase()))
            titledName = "Visa";
        else if (company_name.toUpperCase().equals(companyNamesTitled.get(1).toUpperCase()))
            titledName = "Discover";
        else if (company_name.toUpperCase().equals(companyNamesTitled.get(2).toUpperCase()))
            titledName = "American Express";

        boolean creditCardValid = isValid(titledName, company_name, companies.get(company_name));
        if (creditCardValid) {
            System.out.println("The sum of all the even digits = " + evenPlace(CREDIT_NUM));
            System.out.println("Your credit card is valid... for now");
            System.out.println("Your credit card number " + CREDIT_NUM + " is: " + runLuhnAlgo(CREDIT_NUM) + " according to the Luhn algo");
        } else {
            System.out.println("\nYour credit card is invalid");
        }
    }
}