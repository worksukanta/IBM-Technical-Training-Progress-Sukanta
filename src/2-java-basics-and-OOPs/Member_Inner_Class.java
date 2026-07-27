/* Member Inner Class */

class Outer {
    private String message = "Hello from Outer!";

    class Inner {
        void display() {
            // Direct access to private outer members
            System.out.println(message); 
        }
    }
}

public class Member_Inner_Class {
    public static void main(String[] args) {
        Outer outerObj = new Outer();
        Outer.Inner innerObj = outerObj.new Inner(); // Special instantiation syntax
        innerObj.display();
    }
}
