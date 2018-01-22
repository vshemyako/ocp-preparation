package chapter05.i18nl10n;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Its also possible to implement your own property class. Below is the approach to achieve this.
 */
public class CustomPropertyClass {

    /**
     * Tests custom resource bundle
     */
    public static void main(String[] args) {
        ResourceBundle customBundle = ResourceBundle.getBundle("chapter05.i18nl10n.CustomPropertyClass$Color", Locale.US);
        System.out.println(customBundle.getString("_red"));
        //Its possible to retrieve an object
        System.out.println(customBundle.getObject("_station"));
    }

    /**
     * Custom resource bundle
     */
    public static class Color_en_US extends ListResourceBundle {
        @Override
        protected Object[][] getContents() {
            return new Object[][]{
                    {"_red", "Red"},
                    {"_yellow", "Yellow"},
                    {"_station", new ColorStation()}
            };
        }
    }

    /**
     * Just as an example that custom resource bundle can store an object as a value
     */
    public static class ColorStation {
        private static final String NAME = "Color Station";

        @Override
        public String toString() {
            return NAME;
        }
    }
}
