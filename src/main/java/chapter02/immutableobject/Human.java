package chapter02.immutableobject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Immutable object pattern requires several things to consider:
 * - Constructor initializes all fields
 * - All fields are private final
 * - No setter methods
 * - Mutable fields are never shared directly
 * - Prevent class from being inherited (methods from being overridden)
 */
public final class Human {

    //private final fields
    private final String firstName;
    private final String secondName;
    private final List<String> children;

    //fields initialized in a constructor
    public Human(String firstName, String secondName, List<String> children) {
        this.firstName = firstName;
        this.secondName = secondName;
        //don't just assign mutable object, but copy them!
        this.children = new ArrayList<>(children);
    }

    //only getters - no setters
    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    //don't share mutable object directly
    public List<String> getChildren() {
        return Collections.unmodifiableList(children);
    }
}
