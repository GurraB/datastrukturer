package collections;

/**
 * Created by Gustaf on 05/02/2016.
 * Contains methods to sort a double array with quicksort and methods to sort an ArrayList with mergesort
 */
public class Sorting {

    /**
     * sorts the array in ascending order
     * @param array the array to be sorted
     */
    public static void sort(double[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * recursive method to split the array
     * @param arr array to be sorted
     * @param left left border
     * @param right right border
     */
    private static void quickSort(double[] arr, int left, int right) {
        int pivotIndex;
        if (left < right) {
            pivotIndex = partion(arr, left, right, (left + right) / 2);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    /**
     * sorts a partion of the array
     * @param arr the array to be sorted
     * @param left the left border
     * @param right the right border
     * @param pivotIndex the element to compare with
     * @return the border of where the array is sorted
     */
    private static int partion(double[] arr, int left, int right, int pivotIndex) {
        double pivotValue = arr[pivotIndex];
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

    /**
     * changes the places of two elements
     * @param arr the array in which they should change places
     * @param element1 position of element1
     * @param element2 position of element2
     */
    private static void swap(double[] arr, int element1, int element2) {
        double temp = arr[element1];
        arr[element1] = arr[element2];
        arr[element2] = temp;
    }

    /**
     * sorts an ArrayList with mergesort
     * @param list the list to be sorted
     * @param <E> type of the list
     */
    public static <E> void sort(ArrayList<E> list) {
        E temp[] = (E[]) new Object[list.size()];
        mergesort(list, 0, list.size(), temp);
        temp = null;
    }

    /**
     * recursive method to split the list
     * @param list the list to be sorted
     * @param start start index
     * @param n end index
     * @param temp the temporary array to hold the sorted values
     * @param <E> type of objects to be sorted
     */
    private static<E> void mergesort( ArrayList<E> list, int start, int n, E[] temp ) {
        int n1,n2;
        if( n > 1 ) {
            n1 = n / 2;
            n2 = n - n1;
            mergesort( list, start, n1, temp );
            mergesort( list, start + n1, n2, temp );
            merge( list, start, n1, n2, temp );
        }
    }

    /**
     * merges two parts of list in ascending order
     * @param list the list to be sorted
     * @param first the first element
     * @param n1 start index of the second part
     * @param n2 end index
     * @param temp temporary array to hold the sorted values
     * @param <E> type of object to be sorted
     */
    private static<E> void merge(ArrayList<E> list, int first, int n1, int n2, E[] temp) {
        int counter = 0,cursor1 = 0, cursor2 = n1, last = n1 + n2;
        while( ( cursor1 < n1 ) && ( cursor2 < last ) ) {
            if(((Comparable) list.get(first + cursor1)).compareTo(list.get(first + cursor2)) < 0) {
                temp[counter] = list.get(first + cursor1);
                cursor1++;
            } else {
                temp[counter] = list.get(first + cursor2);
                cursor2++;
            }
            counter++;
        }
        while( cursor1 < n1 ) {
            temp[counter] = list.get(first + cursor1);
            cursor1++;
            counter++;
        }
        while( cursor2 < last ) {
            temp[counter] = list.get(first + cursor2);
            cursor2++;
            counter++;
        }
        for( int i = 0; i < n1 + n2; i++ )
            list.set(first + i, temp[i]);
    }
}
