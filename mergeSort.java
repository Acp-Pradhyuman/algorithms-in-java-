/**
 * mergeSort
 */
public class mergeSort {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 3, 1, 7, 8, 9, 6, 4 };
        merge_sort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void merge_sort(int[] arr, int l, int h) {
        if (l < h) {
            int mid = l + (h - l) / 2;
            merge_sort(arr, l, mid);
            merge_sort(arr, mid + 1, h);
            merge(arr, l, mid, h);
        }
    }

    public static void merge(int[] arr, int l, int mid, int h) {
        int[] first = new int[mid - l + 1];
        int[] second = new int[h - mid];

        for (int i = 0; i < first.length; i++) {
            first[i] = arr[l + i];
        }

        for (int i = 0; i < second.length; i++) {
            second[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = l;
        while (i < (mid - l + 1) && j < (h - mid)) {
            if (first[i] <= second[j]) {
                arr[k++] = first[i++];
            } else {
                arr[k++] = second[j++];
            }
        }

        while (i < (mid - l + 1)) {
            arr[k++] = first[i++];
        }

        while (j < (h - mid)) {
            arr[k++] = second[j++];
        }
    }
}
