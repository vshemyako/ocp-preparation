package chapter02.factorymethod;

/**
 * Subclass to create from a factory method
 */
public class Beer extends Drink {

    public Beer(int amount) {
        super(amount);
    }

    @Override
    public int getAmount() {
        return amount;
    }
}
