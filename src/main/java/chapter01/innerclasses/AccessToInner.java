package chapter01.innerclasses;

/**
 * Testing access to inner members of nested classes
 */
public class AccessToInner {

    public static void main(String[] args) {

        //Accessing nested classes from within another file has mandatory syntax
        InnerClassMembers members = new InnerClassMembers();
        InnerClassMembers.FirstInner firstInner = members.new FirstInner();
        InnerClassMembers.FirstInner.SecondInner secondInner = firstInner.new SecondInner();
        InnerClassMembers.FirstInner.SecondInner.ThirdInner thirdInner = secondInner.new ThirdInner();
        firstInner.tellMeName();
    }
}
