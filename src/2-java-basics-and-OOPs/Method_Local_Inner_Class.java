/* Method-Local Inner Class */

class Outer {
    void runMethod() {
        final int number = 42;

        class LocalInner {
            void print() {
                System.out.println("Local number: " + number);
            }
        }

        LocalInner local = new LocalInner();
        local.print(); // Executed entirely within the method
    }
}
