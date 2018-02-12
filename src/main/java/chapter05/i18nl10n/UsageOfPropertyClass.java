package chapter05.i18nl10n;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * OCP requires to know how to create and use property class
 */
public class UsageOfPropertyClass {

    private static final String GREET_BUNDLE = "greet";

    /**
     * Property class was designed before Map interface and corresponding implementations and has mush in common
     * with before mentioned interface
     */
    private static void convertToPropertyFile() {
        Locale englishLocale = new Locale("en");
        ResourceBundle englishBundle = ResourceBundle.getBundle(GREET_BUNDLE, englishLocale);

        //No direct way to convert from {@code ResourceBundle} to {@code Property} object
        //So one simply should iterate over a keySet
        Properties propertiesObject = new Properties();
        englishBundle.keySet().forEach(key -> propertiesObject.put(key, englishBundle.getString(key)));

        //Get property on key
        System.out.println(propertiesObject.getProperty("_breakfast"));

        //It's possible to define default value to be retrieved if key-value pair wasn't found
        System.out.println(propertiesObject.getProperty("_lunch", "Lunch"));
    }

    /**
     * Get properties from a property object
     */
    public static void main(String[] args) {
        convertToPropertyFile();
    }
}
