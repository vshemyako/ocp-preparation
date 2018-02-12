package chapter02.factorymethod;

/**
 * Alcohol factory ladies and gentlemen
 */
public class DrinkFactory {

    //factory method presents design pattern which frees a client from implementation detail and concrete
    //object type being returned - nice example of loose coupling
    public static Drink getDrink(String yourStrength) {
        switch (yourStrength) {
            case "strong":
                return new Vodka(500);
            case "weak":
                return new Beer(250);
            default:
                throw new IllegalArgumentException("Choose your destiny");
        }
    }
}
