package chapter01.innerclasses;

/**
 * I doubt that book gives correct answer
 */
final public class Bottle {

    final private int size = 14;
    final protected class Insert {
        private final int size = 25;
        public final int getSize() {
            return Bottle.this.size;
        }
    }
    final Insert insert = new Insert();
    final public static void main(String[] feed) {
        System.out.println(new Bottle().insert.getSize());
    }
}
