
/**
 * sum_of_first_n_natural_numbers
 */
import java.util.*;

public class sum_of_first_n_natural_numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // radix = 10
        for (int i = 1; i <= n; i++) {
            System.out.printf("%d\n", i * (i + 1) / 2);
        }
    }
}
