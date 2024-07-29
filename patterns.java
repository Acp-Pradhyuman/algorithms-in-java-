
/**
 * patterns
 */
import java.util.*;

public class patterns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(10); // radix = 10
        // rectangle pattern
        // int m = sc.nextInt(10);
        // for (int i = 1; i <= n; i++) {
        // if (i == 1 || i == n) {
        // for (int j = 1; j <= m; j++) {
        // System.out.printf("* ");
        // }
        // } else {
        // System.out.printf("* ");
        // for (int j = 2; j <= m - 1; j++) {
        // System.out.printf(" ");
        // }
        // System.out.printf("* ");
        // }
        // System.out.printf("\n");
        // }

        // for (int i = 1; i <= n; i++) {
        // for (int j = n; j >= i; j--) {
        // System.out.print("* ");
        // }
        // System.out.println();
        // }

        // for (int i = 1; i <= n; i++) {
        // for (int j = n; j >= i + 1; j--) {
        // System.out.print(" ");
        // }
        // for (int j = 1; j <= i; j++) {
        // System.out.print("* ");
        // }
        // System.out.println();
        // }

        // for (int i = 1; i <= n; i++) {
        // for (int j = n; j >= i + 1; j--) {
        // System.out.print(" ");
        // }
        // for (int j = 1; j <= i; j++) {
        // System.out.printf("%d ", j);
        // }
        // System.out.println();
        // }

        // for (int i = 1; i <= n; i++) {
        // // for (int j = n; j >= i + 1; j--) {
        // // System.out.print(" ");
        // // }
        // for (int j = 1; j <= i; j++) {
        // System.out.printf("%d ", j);
        // }
        // System.out.println();
        // }

        // for (int i = 1; i <= n; i++) {
        // // for (int j = n; j >= i + 1; j--) {
        // // System.out.print(" ");
        // // }
        // for (int j = n; j >= i; j--) {
        // System.out.printf("%d ", n - j + 1);
        // }
        // System.out.println();
        // }

        // int k = 1;
        // for (int i = 1; i <= n; i++) {
        // // for (int j = n; j >= i + 1; j--) {
        // // System.out.print(" ");
        // // }
        // for (int j = 1; j <= i; j++) {
        // System.out.printf("%d ", k++);
        // }
        // System.out.println();
        // }

        for (int i = 1; i <= n; i++) {
            // for (int j = n; j >= i + 1; j--) {
            // System.out.print(" ");
            // }
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.printf("1 ");
                } else {
                    System.out.printf("0 ");
                }
            }
            System.out.println();
        }
    }
}
