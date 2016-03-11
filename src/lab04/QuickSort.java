package lab04;

/**
 * Created by Gustaf on 27/01/2016.
 */
public class QuickSort {

    private static void sort(int[] arr, int left, int right) {
        int pivotIndex;
        if (left < right) {
            pivotIndex = partion(arr, left, right, (left + right) / 2);
            sort(arr, left, pivotIndex - 1);
            sort(arr, pivotIndex + 1, right);
        }
    }

    private static int partion(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        int wall = left;
        swap(arr, pivotIndex, right);
        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, i, wall);
                wall++;
            }
        }
        swap(arr, right, wall);
        return wall;
    }

    private static void swap(int[] arr, int element1, int element2) {
        int temp = arr[element1];
        arr[element1] = arr[element2];
        arr[element2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 3, 9, 0, 5, 2, 6, 8, 0, 4, 2};
        for (int i : arr) {
            System.out.print(arr[i]);
        }
        sort(arr, 0, arr.length - 1);
        System.out.println();
        for (int i : arr) {
            System.out.print(arr[i]);
        }
    }
}
