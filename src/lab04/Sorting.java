package lab04;
import java.util.*;

public class Sorting {

    // ------------------------ BUBBLESORT ----------------------------------------
    public static void bubblesort(int[] array) {
        for( int i=0; i < array.length - 1; i++ ) {
            for( int j = array.length - 1; j > i; j-- ) {
                if( array[ j ] < array[ j - 1 ] )
                    Utility.swap( array, j, j - 1 );
            }
        }
    }

    public static void bubbelsortDesc(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for(int j = array.length - 1; j > i; j--) {
                if(array[j] > array[j-1]) {
                    Utility.swap(array, j, j-1);
                }
            }
        }
    }

    public static void bubbelsortDescC(double[] array) {
        int comp = 0, swap = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for(int j = array.length - 1; j > i; j--) {
                comp++;
                if(array[j] > array[j-1]) {
                    swap++;
                    Utility.swap(array, j, j-1);
                }
            }
        }
        System.out.println("BubblesortDesc, element = " + array.length + " jämförelser = " + comp + " byten = " + swap);
    }

    public static void bubblesortC(int[] array) {
        int comp = 0, swap = 0;
        for( int i=0; i < array.length - 1; i++ ) {
            for( int j = array.length - 1; j > i; j-- ) {
                comp++;
                if( array[ j ] < array[ j - 1 ] ) {
                    swap++;
                    Utility.swap( array, j, j - 1 );
                }
            }
        }
        System.out.println("Bubblesort, element = " + array.length + " jämförelser = " + comp + " byten = " + swap);
    }
    
    public static void bubblesort(Object[] array, Comparator comp) {
        for( int i=0; i < array.length - 1; i++ ) {
            for( int j = array.length - 1; j > i; j-- ) {
                if( comp.compare( array[ j ], array[ j - 1 ] ) < 0 )
                    Utility.swap( array, j, j - 1 );
            }
        }
    }
      
// ------------------------ INSERTIONSORT ----------------------------------------
    public static void insertionsort(int[] array) { // Används på små arrayer i java (mindre än 7 element)
        for( int i = 1; i < array.length; i++ ) {
            for ( int j = i; ( j > 0 ) && ( array[j-1] > array[j] ) ; j--) {
                Utility.swap( array, j, j-1 );
            }
        }
    }

    public static void insertionsortDesc(double[] array) {
        for (int i = 1; i < array.length; i++) {
            for(int j = i; (j > 0) && (array[j - 1] < array[j]); j--) {
                Utility.swap(array, j, j-1);
            }
        }
    }

    public static void insertionsortDescC(double[] array) {
        int comp = 0, swap = 0;
        for (int i = 1; i < array.length; i++) {
            comp++;
            for(int j = i; (j > 0) && (array[j - 1] < array[j]); j--) {
                swap++;
                Utility.swap(array, j, j-1);
                comp++;
            }
        }
        System.out.println("InsertionsortDesc, element = " + array.length + " jämförelser = " + comp + " byten = " + swap);
    }
    
    public static void insertionsortC(int[] array) { 
        int comp = 0, swap = 0;
        for( int i = 1; i < array.length; i++ ) {
            comp++;
            for ( int j = i; ( j > 0 ) && ( array[j] < array[j-1] ) ; j--) {
                swap++;
                Utility.swap( array, j, j-1 );
                comp++;
            }
        }
        System.out.println("Insertionsort, element = " + array.length + " jämförelser = " + comp + " byten = " + swap);
    }
    
    public static void insertionsort1(Object[] array) { // Används på små arrayer i java (färre än 7 element)
    	Comparable comp;
    	for( int i = 1; i < array.length; i++ ) {
    		comp = (Comparable)array[i];
            for ( int j = i; ( j > 0 ) && ( comp.compareTo( array[j-1] ) < 0 ) ; j--) {
                Utility.swap( array, j, j-1 );
            }
        }
    }
    
    public static <T extends Comparable<T>> void insertionsort2(T[] array) { // Används på små arrayer i java (färre än 7 element)
    	for( int i = 1; i < array.length; i++ ) {
            for ( int j = i; ( j > 0 ) && ( ( (Comparable<T>)array[j] ).compareTo( array[j-1] ) < 0 ) ; j--) {
                Utility.swap( array, j, j-1 );
            }
        }
    }
    
// -------------------------- MERGESORT ----------------------------------------
    public static void mergesort( int[] array ) {
        int[] temp = new int[ array.length ];
        mergesort( array, 0, array.length, temp );
        temp = null;
    }
    
    private static void mergesort( int[] array, int start, int n, int[] temp ) {
        int n1,n2;
        if( n > 1 ) {
            n1 = n / 2;
            n2 = n - n1;
            mergesort( array, start, n1, temp );
            mergesort( array, start + n1, n2, temp );
            merge( array, start, n1, n2, temp );
        }
    }
    
    private static void merge(int[] array, int first, int n1, int n2, int[] temp) {
        int counter = 0,cursor1 = 0, cursor2 = n1, last = n1 + n2;
        while( ( cursor1 < n1 ) && ( cursor2 < last ) ) {
            if( array[ first + cursor1 ] < array[ first + cursor2 ] ) {
                temp[ counter ] = array[ first + cursor1];
                cursor1++;
            } else {
                temp[ counter ] = array[ first + cursor2 ];
                cursor2++;
            }
            counter++;
        }
        while( cursor1 < n1 ) {
            temp[ counter ] = array[ first + cursor1 ];
            cursor1++;
            counter++;
        }
        while( cursor2 < last ) {
            temp[ counter ] = array[ first + cursor2 ];
            cursor2++;
            counter++;
        }
        for( int i = 0; i < n1 + n2; i++ )
            array[ first + i ] = temp[ i ];
    }

    public static void mergesortDesc(double[] array) {
        double[] temp = new double[array.length];
        mergesortDesc(array, 0, array.length, temp);
        temp = null;
    }

    private static void mergesortDesc(double[] array, int start, int n, double[] temp) {
        int n1, n2;
        if(n > 1) {
            n1 = n / 2;
            n2 = n - n1;
            mergesortDesc(array, start, n1, temp);
            mergesortDesc(array, start + n1, n2, temp);
            mergeDesc(array, start, n1, n2, temp);
        }
    }

    private static void mergeDesc(double[] array, int first, int n1, int n2, double[] temp) {
        int counter = 0, cursor1 = 0, cursor2 = n1, last = n1 + n2;
        while ((cursor1 < n1) && (cursor2 < last)) {
            if(array[first + cursor1] > array[first + cursor2]) {
                temp[counter] = array[first + cursor1];
                cursor1++;
            }
            else {
                temp[counter] = array[first + cursor2];
                cursor2++;
            }
            counter++;
        }
        while(cursor1 < n1) {
            temp[counter] = array[first + cursor1];
            cursor1++;
            counter++;
        }
        while (cursor2 < last) {
            temp[counter] = array[first + cursor2];
            cursor2++;
            counter++;
        }

        for (int i = 0; i < last; i++) {
            array[first + i] = temp[i];
        }
    }

    public static void mergeSortObject(Object[] array) {
        Object[] temp = new Object[array.length];
        mergeSortObj(array, 0, array.length, temp);
        temp = null;
    }

    private static void mergeSortObj(Object[] array, int first, int n, Object[] temp) {
        int n1,n2;
        if( n > 1 ) {
            n1 = n / 2;
            n2 = n - n1;
            mergeSortObj( array, first, n1, temp );
            mergeSortObj( array, first + n1, n2, temp );
            mergeObj( array, first, n1, n2, temp );
        }
    }

    private static void mergeObj(Object[] array, int first, int n1, int n2, Object[] temp) {
        int cursor1 = 0, cursor2 = n1, counter = 0, last = n1 + n2;
        while (cursor1 < n1 && cursor2 < last) {
            if( ( (Comparable) array[first + cursor1]).compareTo(array[first + cursor2]) < 0) {
                temp[counter] = array[first + cursor1];
                cursor1++;
            }
            else {
                temp[counter] = array[first + cursor2];
                cursor2++;
            }
            counter++;
        }

        while(cursor1 < n1) {
            temp[counter] = array[first + cursor1];
            cursor1++;
            counter++;
        }
        while (cursor2 < last) {
            temp[counter] = array[first + cursor2];
            cursor2++;
            counter++;
        }

        for (int i = 0; i < last; i++) {
            array[first + i] = temp[i];
        }
    }
    
    
    
    public void compTime() {
        int[] arr1 = Utility.randomArray(40000, 1000000, 2000000);
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();
        long startTime,stopTime;
        
        startTime = System.currentTimeMillis();
        bubblesort( arr1 );
        stopTime = System.currentTimeMillis();
        System.out.println( "Bubblesort: " + ( stopTime - startTime ) + " ms" );
        
        startTime = System.currentTimeMillis();
        insertionsort( arr2 );
        stopTime = System.currentTimeMillis();
        System.out.println( "Insertionsort: " + ( stopTime - startTime ) + " ms" );
        
        startTime = System.currentTimeMillis();
        mergesort( arr3 );
        stopTime = System.currentTimeMillis();
        System.out.println( "Mergesort: " + ( stopTime - startTime ) + " ms" );
    }

    public void compTime2() {
        double min = 1000000, max = 2000000;
        double[] arr1 = Utility.randomArray(40000, min, max);
        double[] arr2 = arr1.clone();
        double[] arr3 = arr1.clone();
        long startTime,stopTime;

        startTime = System.currentTimeMillis();
        bubbelsortDesc( arr1 );
        stopTime = System.currentTimeMillis();
        System.out.println( "Bubblesort: " + ( stopTime - startTime ) + " ms" );

        startTime = System.currentTimeMillis();
        insertionsortDesc( arr2 );
        stopTime = System.currentTimeMillis();
        System.out.println( "Insertionsort: " + ( stopTime - startTime ) + " ms" );

        startTime = System.currentTimeMillis();
        mergesortDesc( arr3 );
        stopTime = System.currentTimeMillis();
        System.out.println( "Mergesort: " + ( stopTime - startTime ) + " ms" );
    }
    
    public void compSwap() {
        int[] arr1 = Utility.completeArray( 100, 199 );
        int[] arr2 = arr1.clone();
        bubblesortC( arr1 );
        insertionsortC( arr2 );
    }
    
    public void testBubblesort() {
        int[] arr1 = Utility.completeArray( 100, 199 );
        Utility.printArray( arr1, 20 );
        Sorting.bubblesort( arr1 );
        System.out.println();
        Utility.printArray( arr1, 20 );
    }
    
    public void testInsertionsort() {
        int[] arr1 = Utility.completeArray( 100, 199 );
        Utility.printArray( arr1, 20 );
        Sorting.insertionsort( arr1 );
        System.out.println();
        Utility.printArray( arr1, 20 );
    }
    
    public void testMergesort() {
        int[] arr1 = Utility.completeArray( 100, 199 );
        Utility.printArray( arr1, 20 );
        Sorting.mergesort( arr1 );
        System.out.println();
        Utility.printArray( arr1, 20 );
    }

    public void testBubblesortDesc() {
        double max = 199, min = 100;
        double[] arr1 = Utility.randomArray(100, min, max );
        Utility.printArray( arr1, 20 );
        Sorting.bubbelsortDescC( arr1 );
        System.out.println();
        Utility.printArray( arr1, 20 );
    }

    public void testInsertionsortDesc() {
        double max = 199, min = 100;
        double[] arr1 = Utility.randomArray(100, min, max );
        Utility.printArray( arr1, 20 );
        Sorting.insertionsortDescC( arr1 );
        System.out.println();
        Utility.printArray( arr1, 20 );
    }

    public void testMergesortDesc() {
        double max = 199, min = 100;
        double[] arr1 = Utility.randomArray(100, min, max );
        Utility.printArray( arr1, 20 );
        Sorting.mergesortDesc( arr1 );
        System.out.println();
        Utility.printArray( arr1, 20 );
    }

    public void testBubbleObj() {
        String[] aids = {"Cancer", "Hiv", "Aids", "Dildo"};
        for (String aid : aids) {
            System.out.println(aid);
        }
        lab4.bubbleObject(aids);
        System.out.println();
        for (String aid : aids) {
            System.out.println(aid);
        }
    }

    public void testBubbleOjbRealNbr() {
        RealNbr[] nbrs = RealNbr.randomNumbers(100, 0, 100);
        for (RealNbr nbr : nbrs) {
            System.out.println(nbr.getValue());
        }
        lab4.bubbleObject(nbrs);
        System.out.println("----------------------------------------------");
        for (RealNbr nbr : nbrs) {
            System.out.println(nbr.getValue());
        }
    }

    public void testMergesortObject() {
        String[] aids = {"Cancer", "Hiv", "Aids", "Dildo"};
        for (String aid : aids) {
            System.out.println(aid);
        }
        mergeSortObject(aids);
        System.out.println();
        for (String aid : aids) {
            System.out.println(aid);
        }
    }

    public void redovisning() {
        double min = 0, max = 10;
        double[] array = Utility.randomArray(10, min, max);
        Utility.printArray(array, 1);
        Sorting.mergesortDesc(array);
        System.out.println();
        Utility.printArray(array, 1);
    }
    
    public static void main(String[] args) {
        Sorting sort = new Sorting();
//        sort.testBubbleObj();
//        sort.testBubbleOjbRealNbr();
        sort.testMergesortObject();
//        sort.redovisning();
//        sort.testMergesortDesc();
//        sort.testBubblesort();
//        sort.testBubblesortDesc();
//        sort.testInsertionsort();
//        sort.testInsertionsortDesc();
//        sort.compSwap();
//        sort.testMergesort();
//        sort.compTime();
//        sort.compTime2();
    }
}
