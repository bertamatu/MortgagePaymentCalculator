package lt.berta;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner ( System.in );

        System.out.print ( "Principal amount: " );
        int principalAmount = scanner.nextInt ();

        System.out.print ( "Annual interest rate: " );
        float annualInterestRate = scanner.nextFloat ();
        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;

        System.out.print ( "Period (years): " );
        byte loanLengthYears = scanner.nextByte ();
        int numberOfPayments = loanLengthYears * MONTHS_IN_YEAR;

        double mortgage = principalAmount
                * (monthlyInterestRate * Math.pow ( 1 + monthlyInterestRate, loanLengthYears )
                / (Math.pow ( 1 + monthlyInterestRate, numberOfPayments ) - 1));

        String mortgageCurrency = NumberFormat.getCurrencyInstance ( Locale.GERMANY ).format ( mortgage );
        System.out.println ( "Your monthly mortgage payment is: " + mortgageCurrency );
    }
}
