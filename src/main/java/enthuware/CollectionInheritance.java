package enthuware;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Testing my own answer which was considered wrong
 */
public class CollectionInheritance {

    //Ah ok, we had to use self-sorting collection
    public static void main(String[] args) {
        Set<String> holder = new LinkedHashSet<>();
        holder.add("tom");
        holder.add("dick");
        holder.add("harry");
        holder.add("tom");
        printIt(holder);
    }

    public static void printIt(Collection<String> list) {
        for(String s : list) {
            System.out.println(s);
        }
    }
}
