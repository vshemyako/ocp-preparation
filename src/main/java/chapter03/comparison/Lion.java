package chapter03.comparison;

/**
 * Basic implementation of {@see java.lang.Comparable} interface.
 * It's important to be consistent with equals method, though this consistency is omitted here.
 */
public class Lion implements Comparable<Lion>{

    private int numberOfTeeth;
    private String name;

    public Lion(int numberOfTeeth, String name) {
        this.numberOfTeeth = numberOfTeeth;
        this.name = name;
    }

    public int getNumberOfTeeth() {
        return numberOfTeeth;
    }

    public void setNumberOfTeeth(int numberOfTeeth) {
        this.numberOfTeeth = numberOfTeeth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Lion o) {
        return numberOfTeeth - o.getNumberOfTeeth();
    }
}
