/* Static Nested Class */


class Outer {
    static String staticMsg = "Static Data";
    String instanceMsg = "Instance Data";

    static class StaticNested {
        void show() {
            System.out.println(staticMsg); // Allowed
            // System.out.println(instanceMsg); // Compile Error!
        }
    }
}

// Instantiation does not require an outer object
Outer.StaticNested nestedObj = new Outer.StaticNested();
