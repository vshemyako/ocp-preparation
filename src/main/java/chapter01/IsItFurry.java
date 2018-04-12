package chapter01;

import java.util.ArrayList;

/**
 * Instance of test cases
 */
public class IsItFurry {

    static class Chipmunk {
        public static void main(String[] args) {
            Chipmunk chipmunk = new Chipmunk();
            ArrayList<Chipmunk> chipmunks = new ArrayList<>();
            Runnable runnable = new Thread();

            int result = 0;
            if (chipmunk instanceof Chipmunk) result += 1;
            //if (chipmunks instanceof Chipmunk) result += 2;
            if (runnable instanceof Chipmunk) result += 4;

            System.out.println(result);
        }
    }
}
