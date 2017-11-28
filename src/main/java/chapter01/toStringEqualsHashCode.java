package chapter01;

/**
 * One have to know all of the methods which are automatically
 * inherited by all of the objects in java from super class Object
 */
public class toStringEqualsHashCode {
}

class Humanoid {

    @Override
    public String toString() {
        return "";
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Humanoid;
    }
}