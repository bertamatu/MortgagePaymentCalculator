package lt.berta;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        public int principalAmount = 0;
        public float annualInterestRate = 0;
        public float monthlyInterestRate = 0;
        public byte loanLengthYears = 0;
        public int numberOfPayments = 0;

        Scanner scanner = new Scanner ( System.in );

        while (true) {
            System.out.print ( "Principal amount: " );
            principalAmount = scanner.nextInt ();
            if (principalAmount >= 1_000 && principalAmount <= 1_000_000)
                break;
            System.out.println ( "Enter a value between 1.000 and 1.000.000" );
        }

        while (true) {
            System.out.print ( "Annual interest rate: " );
            annualInterestRate = scanner.nextFloat ();
            if (annualInterestRate >= 2 && annualInterestRate <= 11) {
                monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println ( "Enter annual interest rate value between 2 and 11" );
        }

        while (true) {
            System.out.print ( "Period (years): " );
            loanLengthYears = scanner.nextByte ();
            if (loanLengthYears >= 1 && loanLengthYears <= 30) {
                numberOfPayments = loanLengthYears * MONTHS_IN_YEAR;
                break;
            }
            System.out.println ( "Enter a value between 1 and 30" );
        }
        double mortgage = principalAmount
                * (monthlyInterestRate * Math.pow ( 1 + monthlyInterestRate, loanLengthYears )
                / (Math.pow ( 1 + monthlyInterestRate, numberOfPayments ) - 1));

        String mortgageCurrency = NumberFormat.getCurrencyInstance ( Locale.GERMANY ).format ( mortgage );
        System.out.println ( "Your monthly mortgage payment is: " + mortgageCurrency );
    }
}
