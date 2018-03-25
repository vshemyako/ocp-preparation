package chapter03.comparison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Shows usage of comparator
 */
public class UsageOfComparator {

    private static class Box implements Comparable<Box> {
        private String name;
        private int height;
        private int width;

        @Override
        public String toString() {
            return "Box{" +
                    "name='" + name + '\'' +
                    ", height=" + height +
                    ", width=" + width +
                    '}';
        }

        public Box(String name, int height, int width) {
            this.name = name;
            this.height = height;
            this.width = width;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        @Override
        public int compareTo(Box o) {
            return this.getName().compareTo(o.getName());
        }
    }

    private static List<Box> initBoxes() {
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box("Z-first", 10, 1));
        //boxes.add(null);
        boxes.add(new Box("A-second", 5, 20));
        boxes.add(new Box("A-second", 2, 20));
        //boxes.add(null);
        boxes.add(new Box("B-third", 30, 3));
        return boxes;
    }

    private static Comparator<Box> getNameComparator() {
        return Comparator.comparing(Box::getName);
    }

    private static Comparator<Box> getHeightComparator() {
        return Comparator.comparing(Box::getHeight);
    }

    private static Comparator<Box> convertComparableIntoComparator() {
        return Comparator.naturalOrder();
    }

    /**
     * Util sorting method
     */
    private static <E> void sortList(List<E> elements, Comparator<E> comparator) {
        Collections.sort(elements, comparator);
    }

    /**
     * As always, entry point
     */
    public static void main(String[] args) {
        List<Box> boxes = initBoxes();
        //very easy to chain comparators
        /*
        Comparator<Box> nameComparator =
                Comparator.nullsLast(
                        getNameComparator()
                                .thenComparing(getHeightComparator())
                                .reversed()
                );
        */
        Comparator<Box> nameComparator = convertComparableIntoComparator();
        sortList(boxes, nameComparator);
        boxes.forEach(System.out::println);
    }
}
