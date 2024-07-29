/**
 * quickSort
 */
public class quickSort {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 3, 1, 7, 8, 9, 6, 4 };
        quickSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int arr[], int p, int r) {
        // if (p < r) {
        while (p < r) {
            int pivot = partition(arr, p, r);

            // Sedgewick's imporvemnt for space complexity to O(log(n))
            if ((pivot - p) < (r - pivot)) {
                quickSort(arr, p, pivot - 1);
                p = pivot + 1;
            } else {
                quickSort(arr, pivot + 1, r);
                r = pivot - 1;
            }
        }
    }

    public static int partition(int arr[], int p, int r) {
        int x = arr[p];
        int i = p;
        for (int j = p + 1; j <= r; j++) {
            if (arr[j] < x) {
                int temp = arr[j];
                arr[j] = arr[++i];
                arr[i] = temp;
            }
        }

        int temp = arr[i];
        arr[i] = x;
        arr[p] = temp;
        return i;
    }
}
