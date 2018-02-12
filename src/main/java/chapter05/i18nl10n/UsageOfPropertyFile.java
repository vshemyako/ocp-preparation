package chapter05.i18nl10n;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * OCP requires to know how to create and use property files
 */
public class UsageOfPropertyFile {

    private static final String GREET_BUNDLE = "greet";

    /**
     * Creates language specific locale
     */
    private static void createLocale() {
        Locale englishLocale = new Locale("en");
        printGreeting(englishLocale);
        //printFarewell(englishLocale);

        //Locale russianLocale = new Locale("ru");
        //printGreeting(russianLocale);
        //printFarewell(russianLocale);
    }

    /**
     * Prints out greeting message dependent on {@code Locale} parameter
     */
    private static void printGreeting(Locale locale) {
        //Acquire locale specific bundle file
        ResourceBundle greetingBundle = ResourceBundle.getBundle(GREET_BUNDLE, locale);
        //Print out desired string
        //System.out.println(greetingBundle.getString("_hello"));
        System.out.println(greetingBundle.getString("_parent"));
    }

    /**
     * Prints out farewell message dependent on {@code Locale} parameter
     */
    private static void printFarewell(Locale locale) {
        //Acquire locale specific bundle file
        ResourceBundle greetingBundle = ResourceBundle.getBundle(GREET_BUNDLE, locale);
        //Print out desired string
        System.out.println(greetingBundle.getString("_bye"));
    }

    /**
     * Prints content of property files
     */
    private static void printPropertyFiles() {
        Locale englishLocale = new Locale("en");
        ResourceBundle enBundle = ResourceBundle.getBundle(GREET_BUNDLE, englishLocale);
        printAllKeyValuePairs(enBundle);

        Locale russianLocale = new Locale("ru");
        ResourceBundle ruBundle = ResourceBundle.getBundle(GREET_BUNDLE, russianLocale);
        printAllKeyValuePairs(ruBundle);
    }

    /**
     * Shows how to loop through all key-value pairs in a property file
     */
    private static void printAllKeyValuePairs(ResourceBundle specificBundle) {
        Set<String> bundleKeys = specificBundle.keySet();
        bundleKeys
                .stream()
                .map(key -> key + ":" + specificBundle.getString(key))
                .forEach(System.out::println);
    }

    /**
     * Run method chain
     */
    public static void main(String[] args) {
        createLocale();
        //printPropertyFiles();
    }
}
