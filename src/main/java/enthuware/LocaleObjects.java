package enthuware;

import java.util.Locale;

/**
 * Different methods of {@link java.util.Locale} class
 */
public class LocaleObjects {

    private static void displayLocaleInfo() {
        Locale systemDefault = Locale.getDefault();
        Locale italian = Locale.ITALY;

        //shows how country and language are display in system-default locale
        System.out.println(systemDefault.getDisplayCountry());
        System.out.println(systemDefault.getDisplayLanguage());

        System.out.println(italian.getDisplayCountry());
        System.out.println(italian.getDisplayLanguage());

        //let's change default locale
        Locale.setDefault(Locale.ITALY);

        System.out.println(Locale.US.getDisplayCountry(Locale.FRANCE));
        System.out.println(Locale.US.getDisplayLanguage());

        System.out.println(italian.getDisplayCountry());
        System.out.println(italian.getDisplayLanguage());
    }

    private static void displayLocaleCodes() {
        Locale systemDefault = Locale.getDefault();
        System.out.println("Country code " + systemDefault.getCountry());
        System.out.println("Language code " + systemDefault.getLanguage());
        System.out.println("Variant code " + systemDefault.getLanguage());
    }

    public static void main(String[] args) {
        //displayLocaleInfo();
        displayLocaleCodes();
    }
}
