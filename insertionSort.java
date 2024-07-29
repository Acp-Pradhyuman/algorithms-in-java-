/**
 * insertionSort
 */
public class insertionSort {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 3, 1, 7, 8, 9, 6, 4 };
        int key, j;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
