package chapter01;

import java.util.ArrayList;
import java.util.List;

/**
 * Basic concepts of instance of operator
 */
public class InstanceOf {
    public static void main(String[] args) {
        BigCat bigCat = new BigCat();
        RedCat redCat = new RedCat();
        GreenCat greenCat = new GreenCat();
        YellowCat yellowCat = new YellowCat();

        RedCat[] redCats = {new RedCat()};
        boolean value = redCats instanceof BigCat[];
        System.out.println(value);

        List<RedCat> redCatList = new ArrayList<>();
        //boolean anotherValue = redCatList instanceof List<BigCat>;

        //instance of a class is always instance of that class =)
        System.out.println("bigCat instanceof BigCat: " + (bigCat instanceof BigCat));

        //subclass of a superclass => true
        System.out.println("redCat instanceof BigCat: " + (redCat instanceof BigCat));

        //superclass instance is not always real subclass instance
        System.out.println("bigCat instanceof GreenCat: " + (bigCat instanceof GreenCat));

        //we can apply this check to class implementing an interface
        System.out.println("yellowCat instance of Jump: " + (yellowCat instanceof Jump));

        //some not so obvious examples
        System.out.println("null instance of Object: " + (null instanceof Object));

        //if there's no possibility that an object is an instance of a class : compile time error occurs
        //Error: GreenCat cannot be converted to YellowCat
        //System.out.println("greenCat instance of YellowCat: " + (greenCat instanceof YellowCat));

        //though it's possible to apply this check upon an interface, because a subclass could implement it
        System.out.println("greenCat instance of Jump: " + (greenCat instanceof Jump));
    }
}

class BigCat {
}

interface Jump {
}

class RedCat extends BigCat {
}

class GreenCat extends BigCat {
}

class YellowCat extends BigCat implements Jump {
}