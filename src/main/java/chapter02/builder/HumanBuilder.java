package chapter02.builder;

import chapter02.immutableobject.Human;

import java.util.Collections;
import java.util.List;

/**
 * Too many constructor arguments lead to an unmaintainable code. Builder design pattern solves this problem.
 * Though builder presented here is located in separate package it's a good approach to create it as a
 * static nested class or, at least, declare it in the same package as the class, object of which it constructs
 */
public class HumanBuilder {

    private String firstName;
    private String secondName;
    private List<String> children;

    public HumanBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public HumanBuilder setSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public HumanBuilder setChildren(List<String> children) {
        this.children = children;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public List<String> getChildren() {
        return children;
    }

    public Human build() {
        return new Human(this);
    }

    public static void main(String[] args) {
        //builder design pattern - usage example
        new HumanBuilder()
                .setFirstName("Laplas")
                .setSecondName("Greatest")
                .setChildren(Collections.singletonList("Sanchez"))
                .build();
    }
}
