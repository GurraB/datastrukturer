package lab04;

import java.util.Comparator;
import java.util.Random;

/**
 * Created by Gustaf on 25/01/2016.
 */
public class lab4 {

    public static double[] randomArray(int n, double min, double max) {
        Random rand = new Random();
        double[] arr = new double[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextDouble() * ( max - min ) + min;
        }
        return arr;
    }

    public static void main(String[] args) {
        //bubble();
        insertion();
        System.out.println("---------------------------------------------------------");

    }

    private static void bubble() {
        double[] array = randomArray(100, 0, 100);
        Utility.printArray(array, 1);
        Sorting.bubbelsortDesc(array);
        System.out.println("--------------------------------------------------------");
        Utility.printArray(array, 1);
    }

    private static void insertion() {
        double[] array = randomArray(100, 0, 100);
        Utility.printArray(array, 1);
        Sorting.insertionsortDesc(array);
        System.out.println("--------------------------------------------------------");
        Utility.printArray(array, 1);
    }

    public static void bubbleObject(Object[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for(int j = array.length - 1; j > i; j--) {
                Comparable comp = (Comparable) array[j - 1];
                if(comp.compareTo(array[j]) > 0) {
                    Utility.swap(array, j, j - 1);
                }
            }
        }
    }

    public static void bubblesort(Object[] array, Comparator comp) {
        for( int i=0; i < array.length - 1; i++ ) {
            for( int j = array.length - 1; j > i; j-- ) {
                if( comp.compare( array[ j ], array[ j - 1 ] ) < 0 )
                    Utility.swap( array, j, j - 1 );
            }
        }
    }

}
