import javax.swing.*;
import java.awt.event.*;
import java.awt.image.CropImageFilter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class CheckerGUI {
    private static final Scanner keyboard = new Scanner(System.in);
    private static String CREDIT_NUM;
    private static int[] num1;
    private static String company_name;
    protected JTextField company;
    protected JTextField creditNumber;
    protected JTextArea textArea;
    private final static String newline = "\n";

    public static boolean isValid(String titledName, String company_name, int[] num) {
        CREDIT_NUM = CREDIT_NUM.replaceAll("\\s", "");
        int length = String.valueOf(CREDIT_NUM).length();
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
            } else
                return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            if (length == num[0])
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
            else
                return false;
        }
    }

    //Implementing Luhn's algorithm
    public static boolean runLuhnAlgo(String str) {
        int[] ints = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ints[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        for (int i = ints.length - 2; i >= 0; i -= 2) {
            int j = ints[i];
            j = j * 2;
            if (j > 9) {
                j = j % /**/10 + 1;
            }
            ints[i] = j;
        }

        int sum = 0;
        for (int anInt : ints)
            sum += anInt;

        return sum % 10 == 0;
    }
    CheckerGUI(){
        JFrame f=new JFrame("Credit Card Verifier");
        //submit button
        JButton b=new JButton("Submit");
        b.setBounds(100,100,140, 40);
        //company name label
        JLabel company = new JLabel();
        company.setText("Enter name of company:");
        company.setBounds(10, 10, 100, 100);

        JLabel creditNum = new JLabel();
        company.setText("Card Number");
        company.setBounds(5, 20, 70, 100);

        //empty label which will show event after button clicked
        JLabel output = new JLabel();
        output.setBounds(10, 110, 200, 100);

        //textfield to enter name
        JTextField companyEnter= new JTextField();
        companyEnter.setBounds(110, 50, 130, 30);
        company_name =  companyEnter.getText();

        JTextField creditNumber= new JTextField();
        creditNumber.setBounds(110, 50, 130, 30);
        CREDIT_NUM =  creditNumber.getText();

        //add to frame
        f.add(output);
        f.add(companyEnter);
        f.add(company);
        f.add(creditNum);
        f.add(b);
        f.setSize(350,350);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //action listener
        b.addActionListener(arg0 -> output.setText(company_name));
    }


    public static void main(String[] args) {
        new CheckerGUI();
        //initializing variables, Scanner, and Hashtable
        String firstName, lastName, company_name;
        HashMap<String, int[]> companies = new HashMap<>();
        List<String> companyNamesTitled = Arrays.asList("Visa", "Discover", "American Express", "MasterCard");

        //Most popular credit card company names and some sample credit number length values
        companies.put("visa", new int[]{16});
        companies.put("discover", new int[]{16, 19});
        companies.put("american express", new int[]{15});
        companies.put("mastercard", new int[]{16});


        String titledName = "Mastercard";
//        if (company_name.toUpperCase().equals(companyNamesTitled.get(0).toUpperCase()))
//            titledName = "Visa";
//        else if (company_name.toUpperCase().equals(companyNamesTitled.get(1).toUpperCase()))
//            titledName = "Discover";
//        else if (company_name.toUpperCase().equals(companyNamesTitled.get(2).toUpperCase()))
//            titledName = "American Express";

//        boolean creditCardValid = isValid(titledName, company_name, companies.get(company_name));
//        if (creditCardValid) {
//
//        } else {
//
//        }
    }
}
