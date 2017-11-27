package chapter01.innerclasses;

/**
 * Class defined within a method
 * - There is no local interfaces
 * - A variable or parameter value of which is never changed after instantiation is called 'effectively final'
 */
public class LocalClass {

    public void calculate() {

        final int aNumber;
        aNumber = 20;
        int bNumber = 30;
        int cNumber = 40;
        cNumber = 50;

        class Calc {
            private int bNumber = 10;

            public void sum() {
                System.out.println(aNumber);
                System.out.println(bNumber);

                //only access to local final (effectively final since JDK8) is allowed
                //System.out.println(cNumber);
            }
        }

        Calc calc = new Calc();
        calc.sum();
        //You cannot declare local interface
        /*
        interface Count {
        }
        */
    }

    public static void main(String[] args) {
        LocalClass localClass = new LocalClass();
        localClass.calculate();
    }
}
