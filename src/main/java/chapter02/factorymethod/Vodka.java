package chapter02.factorymethod;

/**
 * Subclass to create from a factory method
 */
public class Vodka extends Drink {

    public Vodka(int amount) {
        super(amount);
    }

    @Override
    public int getAmount() {
        return amount;
    }
}
