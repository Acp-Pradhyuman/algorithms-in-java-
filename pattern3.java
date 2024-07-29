
/**
 * pattern3
 */
import java.util.*;

public class pattern3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(10); // radix = 10
        // for (int i = 1; i <= n; i++) {
        // for (int j = 1; j <= n - i; j++) {
        // System.out.print(" ");
        // }

        // for (int j = 1; j <= n; j++) {
        // if (j == 1 || i == 1 || i == n)
        // System.out.print("* ");
        // }

        // for (int j = 2; j <= n - 1; j++) {
        // System.out.print(" ");
        // }

        // for (int j = 1; j <= n; j++) {
        // if (j == n && i > 1 && i < n)
        // System.out.print("* ");
        // }

        // System.out.println();
        // }

        // for (int i = 1; i <= n; i++) {
        // for (int j = 1; j <= n - i; j++) {
        // System.out.print(" ");
        // }

        // for (int j = 1; j <= i; j++) {
        // System.out.print(i + " ");
        // }

        // System.out.println();
        // }

        // for (int i = 1; i <= n; i++) {
        // for (int j = 1; j <= n - i; j++) {
        // System.out.print(" ");
        // }

        // int k = i;
        // for (int j = 1; j <= i; j++) {
        // System.out.print(k-- + " ");
        // }

        // k = 2;
        // for (int j = 1; j <= i - 1; j++) {
        // System.out.print(k++ + " ");
        // }

        // System.out.println();
        // }

        printFunc(n);

    }

    public static void printFunc(int n) {
        for (int i = 1; i <= 2 * n - 1; i = i + 2) {
            for (int j = 2 * n - i - 1; j >= 1; j--) {
                System.err.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = 2 * n - 1; i >= 1; i = i - 2) {
            for (int j = 2 * n - 1; j >= i + 1; j--) {
                System.err.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
