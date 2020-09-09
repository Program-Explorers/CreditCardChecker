import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
        JPanel panel = new JPanel();
        GridLayout gl = new GridLayout(6,2);
        panel.setLayout(gl);


        JLabel company_name1 = new JLabel("Company Name");
        JTextField company_name2 = new JTextField();
        panel.add(company_name1);
        panel.add(company_name2);
        JLabel creditNum = new JLabel("Credit Card Number");
        JTextField creditNum2 = new JTextField();
        panel.add(creditNum);
        panel.add(creditNum2);
        JButton b =new JButton("Submit");
        panel.add(b);
        JLabel output = new JLabel();
        panel.add(output);

        CREDIT_NUM = creditNum2.getText();
        company_name = company_name2.getText();

        //add to frame
        panel.add(output);
        panel.add(b);
        f.add(panel);
        f.setSize(350,350);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //action listener
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                output.setText(creditNum2.getText());
            }
        });
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
//        boolean creditCardValid = isValid(titledName, company_name, companies.get(company_name));
//        if (creditCardValid) {
//
//        } else {
//
//        }
    }
}
