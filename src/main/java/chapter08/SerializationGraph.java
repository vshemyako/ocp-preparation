package chapter08;

import java.io.*;

/**
 * Came across an example which clearly defines how graph serialization is performed
 */
public class SerializationGraph {

    //parent - not serializable
    private static class Animal {
        public int weight = 42;

        public Animal() {
        }
    }

    //child - serializable
    private static class Dog extends Animal implements Serializable {
        public static int count;
        public String name;

        public Dog() {
        }

        public Dog(String name, int weight) {
            this.name = name;
            this.weight = weight;
            ++count;
        }
    }

    public static void main(String[] args) {
        Dog firstDog = new Dog("Fido", 35);
        Dog secondDog = new Dog("Nike", 35);
        System.out.println("Before: name " + firstDog.name + " weight: " + firstDog.weight);
        System.out.println("Before: count " + firstDog.count);

        try {
            FileOutputStream fs = new FileOutputStream("C:\\Projects\\Certification\\OCPJP\\ocp-preparation\\src\\main\\java\\chapter08\\dog.txt");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(firstDog);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fs = new FileInputStream("C:\\Projects\\Certification\\OCPJP\\ocp-preparation\\src\\main\\java\\chapter08\\dog.txt");
            ObjectInputStream os = new ObjectInputStream(fs);
            firstDog = (Dog) os.readObject();
            os.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("After: name " + firstDog.name + " weight: " + firstDog.weight);
        System.out.println("After: count " + firstDog.count);
    }
}
