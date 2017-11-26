package chapter01.innerclasses;

/**
 * It's far from obvious how to access outer/inner members of the nested classes
 * <p>
 * Note: static methods and fields cannot be declared in inner classes
 */
public class InnerClassMembers {

    private String name = "Furtado";
    private static int number = 00000_00000;

    public void fromTheOuter() {
        tellMeName();
        this.tellMeName();

        //accessing from outer class to inner members differs from access to outer member from inner class
        //see code below
        InnerClassMembers members = new InnerClassMembers();
        //fully qualified type is required here
        FirstInner firstInner = members.new FirstInner();
        FirstInner.SecondInner secondInner = firstInner.new SecondInner();
        FirstInner.SecondInner.ThirdInner thirdInner = secondInner.new ThirdInner();
    }

    public void tellMeName() {
        FirstInner firstInner = new FirstInner();
        System.out.println(firstInner.name);
        System.out.println(firstInner.new SecondInner().name);
    }

    public class FirstInner {
        private String name = "John";

        public void tellMeName() {
        }
        //Error: inner classes cannot have static declarations
        /*
        static String name = "Hello";

        static void print() {
            System.out.println("Print");
        }
        */

        public class SecondInner {
            private String name = "Ron";

            public void tellMeName() {
            }

            public class ThirdInner {
                private String name = "Nelly";

                public void tellMeName() {
                }

                public void accessOuterFields() {
                    //it's possible to access everything within the same class
                    System.out.println(ThirdInner.this.name);
                    System.out.println(SecondInner.this.name);
                    System.out.println(FirstInner.this.name);
                    System.out.println(InnerClassMembers.this.name);

                    this.tellMeName();
                    tellMeName();
                    //insane syntax
                    //it turns out that outer class needs an instance to access inner members while
                    //inner members do not have to access outer members via instance
                    ThirdInner.this.tellMeName();
                    SecondInner.this.tellMeName();
                    FirstInner.this.tellMeName();
                    InnerClassMembers.this.tellMeName();

                    //or even this way
                    InnerClassMembers.FirstInner.SecondInner.ThirdInner.this.tellMeName();
                    FirstInner.SecondInner.ThirdInner.this.tellMeName();
                    SecondInner.ThirdInner.this.tellMeName();
                    ThirdInner.this.tellMeName();
                    this.tellMeName();
                    tellMeName();

                    //accessing via instance
                    InnerClassMembers members = new InnerClassMembers();
                    FirstInner firstInner = members.new FirstInner();
                    SecondInner secondInner = firstInner.new SecondInner();
                    ThirdInner thirdInner = secondInner.new ThirdInner();
                    members.tellMeName();
                    firstInner.tellMeName();
                    secondInner.tellMeName();
                    thirdInner.tellMeName();

                    //static member is easily accessed because cannot be shadowed
                    System.out.println(number);
                    System.out.println(InnerClassMembers.number);
                    System.out.println(InnerClassMembers.this.number);

                    //referencing using 'this' is impossible what is strange
                    //System.out.println(this.number);
                }
            }
        }
    }
}
