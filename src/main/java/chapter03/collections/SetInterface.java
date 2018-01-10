package chapter03.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * Collection which doesn't allow duplicates and offers very efficient add/remove operations
 */
public class SetInterface {

    public static void main(String[] args) {

        BucketElement firstBucketElement = new BucketElement(10, "table");
        BucketElement secondBucketElement = new BucketElement(10, "chair");
        BucketElement thirdBucketElement = new BucketElement(10, "table");
        BucketElement forthBucketElement = new BucketElement(20, "table");

        Set<BucketElement> set = new HashSet<>();
        set.add(firstBucketElement);
        set.add(secondBucketElement);
        set.add(thirdBucketElement);
        set.add(forthBucketElement);
        System.out.println(set);
    }

    private static class BucketElement {

        private Integer number;
        private String name;

        public BucketElement(Integer number, String name) {
            this.number = number;
            this.name = name;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj instanceof BucketElement) {
                return this.getNumber().equals(((BucketElement) obj).getNumber())
                        && this.getName().equals(((BucketElement)obj).getName());
            }
            return false;
        }

        @Override
        public int hashCode() {
            return number;
        }
    }
}
