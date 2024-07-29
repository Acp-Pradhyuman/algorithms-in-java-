
/**
 * patterns2
 */
import java.util.*;

public class patterns2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(10); // radix = 10
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print("* ");

            for (int j = 1; j <= 2 * n - 2 * i; j++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++)
                System.out.print("* ");
            System.out.println();
        }

        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 2 * n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n - i; j++)
                System.out.print("* ");

            for (int j = 1; j <= 2 * i; j++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= n - i; j++)
                System.out.print("* ");
            System.out.println();
        }
    }
}