package chapter05.format;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * i18n, l10n topics on OCP contain also section about formatting numbers
 */
public class NumbersFormatting {

    /**
     * Shows OCP required factory methods
     */
    private static void numberFormattingInstanceCreation() {
        //General purpose formatter for default locale
        NumberFormat generalPurpose = NumberFormat.getInstance();

        //The same general purpose formatter for default locale
        NumberFormat alsoGeneralPurpose = NumberFormat.getNumberInstance();

        //For formatting money
        NumberFormat moneyPurpose = NumberFormat.getCurrencyInstance();

        //For formatting percentages
        NumberFormat percentPurpose = NumberFormat.getPercentInstance();

        //For rounding decimal numbers
        NumberFormat roundingDecimalsPurpose = NumberFormat.getIntegerInstance();
    }

    /**
     * A good example is showing formatting for big numbers
     */
    private static void showDifferencesBetweenLocales() {
        //Number we are gonna to test
        int bigNumber = 100_000_000;

        //Usa locale
        Locale usaLocale = Locale.US;
        NumberFormat usFormatter = NumberFormat.getInstance(usaLocale);
        System.out.println(usFormatter.format(bigNumber)); //100,000,000

        //Usa locale
        Locale germanyLocale = Locale.GERMANY;
        NumberFormat germanFormatter = NumberFormat.getInstance(germanyLocale);
        System.out.println(germanFormatter.format(bigNumber)); //100.000.000


        //France locale
        Locale franceLocale = Locale.FRANCE;
        NumberFormat frenchFormatter = NumberFormat.getInstance(franceLocale);
        System.out.println(frenchFormatter.format(bigNumber)); //100 000 000
    }

    /**
     * Starts the program
     */
    public static void main(String[] args) {
        showDifferencesBetweenLocales();
    }
}
