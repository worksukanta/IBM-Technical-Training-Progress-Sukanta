/* Anonymous Inner Class */

abstract class Engine {
    abstract void start();
}

public class Anonymous_Inner_Class {
    public static void main(String[] args) {
        // Creating an object that extends Engine implicitly without giving it a class name
        Engine myEngine = new Engine() {
            @Override
            void start() {
                System.out.println("Vroom!");
            }
        };
        myEngine.start();
    }
}
