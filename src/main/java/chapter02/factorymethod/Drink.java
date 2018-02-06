package chapter02.factorymethod;

/**
 * Type of entity returned from a factory method
 */
public abstract class Drink {

    protected int amount;

    public Drink(int amount) {
        this.amount = amount;
    }

    public abstract int getAmount();
}
