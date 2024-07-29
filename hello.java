
/**
 * hello
 */
import java.util.*;

class hello {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // String name = sc.next();
        String name = sc.nextLine();
        System.out.println(name);
        // int n = 10;
        int n = sc.nextInt(2); // radix = 2
        // int n = sc.nextInt(10);
        for (int i = 1; i <= n; i++) {
            // System.out.print(i);
            System.out.printf("%d ", i);
            if (i < 10) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
        // System.out.print("Hello world!\n");
        // // System.out.println("Hello world!");
        // System.out.print("Hello world!");
    }
}