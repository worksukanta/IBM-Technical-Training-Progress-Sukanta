import java.util.Scanner;
public class AssertionDemo {
    public static void main(String[] args) {
        assert true == false: "There is a problem";
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Age: ");
        int age = sc.nextInt();
        assert age>=18: "Can not Vote";
        System.out.println("U"+age);

        sc.close();
    }
}
