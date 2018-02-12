package chapter01.innerclasses;

/**
 * Regular class at a member level
 */
public class StaticNestedClass {

    public static String name = "StaticNestedClass";

    public static class LikeTopLevel {
        private static String name = "LikeTopLevel";

        public static void main(String[] args) {
            System.out.println(StaticNestedClass.name);
        }
    }

    //inner interfaces are static by default
    public static interface TopLevelInterface {
    }

    //two main methods in the same file =)
    public static void main(String[] args) {
        System.out.println(LikeTopLevel.name);
        System.out.println(new LikeTopLevel().toString());
    }
}
