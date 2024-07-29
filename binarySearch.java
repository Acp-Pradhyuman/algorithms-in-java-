
/**
 * binarySearch
 */
import java.util.*;

public class binarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int i = 0, j = arr.length - 1, mid = (i + j) / 2;
        int n = sc.nextInt(10);

        while (i <= j) {
            mid = (i + j) / 2;
            if (arr[mid] == n) {
                System.out.println("element found at " + (mid + 1));
                return;
            } else if (arr[mid] > n) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        System.out.println("element not found");
    }
}
