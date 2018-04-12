package chapter05.i18nl10n;

import java.util.Locale;

/**
 * Shows how to apply localization and internalization process to your application.
 * First class to test to is {@link java.util.Locale}
 */
public class LocalesOCP {

    /**
     * Shows basic usage of {@link java.util.Locale} class
     */
    private static void localeInstanceCreation() {
        //Using default locale
        Locale defaultLocale = Locale.getDefault();
        System.out.println(defaultLocale); //ru_RU -> system uses russian language and is located in Russia

        //Using predefined most used locales
        Locale predefinedLanguageLocale = Locale.ITALIAN;
        System.out.println(predefinedLanguageLocale); //it
        Locale predefinedLanguageCountryLocale = Locale.ITALY;
        System.out.println(predefinedLanguageCountryLocale); //it_IT

        //Using constructor, passing strings
        //This constructor normalizes the language value to lowercase and
        //the country value to uppercase
        Locale russianLocale = new Locale("ru", "RU");
        System.out.println(russianLocale); //ru_RU

        //Using Locale.Builder
        Locale englishLocale = new Locale.Builder()
                .setLanguage("en")
                .setRegion("US")
                .build();
        System.out.println(englishLocale);

        //Its possible to substitute default locale for current java program
        Locale.setDefault(Locale.GERMANY);
    }

    public static void main(String[] args) {
        localeInstanceCreation();
    }
}
