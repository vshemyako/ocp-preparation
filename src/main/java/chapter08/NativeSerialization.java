package chapter08;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Serialization of object using JDK's object streams
 */
public class NativeSerialization {

    /**
     * Serializes objects
     */
    private static void serializeHumans(List<Human> humans, File destination) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(destination)))) {
            for (Human human : humans) {
                outputStream.writeObject(human);
            }
        } catch (IOException e) {
            //handle exception
        }
    }

    private static List<Human> deserializeHumans(File source) {
        List<Human> humans = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(source)))) {
            Object human = inputStream.readObject();
            if (human instanceof Human) {
                humans.add((Human) human);
            }
        } catch (IOException | ClassNotFoundException e) {
            //handle exception
        }
        return humans;
    }

    public static void main(String[] args) {
        List<Human> humans = new ArrayList<>();

        Human man = new Human();
        man.setFirstName("Johhny");
        man.setLastName("Depp");
        man.setAge(54);
        man.setSex(true);
        humans.add(man);

        Human woman = new Human();
        woman.setFirstName("Christina");
        woman.setLastName("Aguilera");
        woman.setAge(37);
        woman.setSex(false);
        humans.add(woman);

        File destination = new File("C:\\Projects\\Certification\\OCPJP\\ocp-preparation\\src\\main\\java\\chapter08\\humans.txt");
        serializeHumans(humans, destination);

        List<Human> deserializedHumans = deserializeHumans(destination);
        System.out.println(deserializedHumans);
    }
}

/**
 * Class for tests
 */
class Human implements Serializable {
    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private int age;
    private boolean sex;

    public Human() {
    }

    public Human(String firstName, String lastName, int age, boolean sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
