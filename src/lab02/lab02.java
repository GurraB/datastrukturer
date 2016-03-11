package lab02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Gustaf on 20/01/2016.
 */
public class lab02 {

    double test[] = {2.4, 1.7, 7, 9.2, 123.5};
    String test1[] = {"cancer", "aids", "hiv", "dildo", "ebola"};

    public static void main(String[] args) {
        new lab02();
    }

    public lab02() {
        /*//1---------------------
        System.out.println("1." + "\t" + indexOf(test, 1.7));

        //2---------------------
        System.out.println("2." + "\t" + indexOf(test1, "hiv"));

        //3---------------------
        int[] randomArray = randomIntArray(10000);
        long start = System.currentTimeMillis();
        for (int i = 0; i < randomArray.length; i++) {
            indexOf(randomArray, i);
        }
        System.out.println("3. " + "\t" + "Tid det tog: \t" +
                (System.currentTimeMillis() - start) + " ms");

        //4---------------------
        System.out.println();
        System.out.println("4." + "\t");
        Integer[] arr = new Integer[5];
        for (int i = 0; i < arr.length; i++)
            arr[i] = new Integer(i);
        shuffle(arr);
        for (Integer elem : arr)
            System.out.print(elem + " ");
        System.out.println();

        //5---------------------
        System.out.println();
        System.out.println("5." + "\t");
        RealNbr[] rArray = getRealNumberArray(20);
        for (RealNbr realNbr : rArray) {
            System.out.print(realNbr + " ");
        }
        System.out.println();

        //6---------------------
        System.out.println();
        System.out.println("6." + "\t" + indexOf(rArray, new RealNbr(10)));
        System.out.println();

        //7---------------------
        System.out.println("7. \t");
        System.out.println("String sökning:" + "\t" + indexOf(test1, "aids"));
        System.out.println("RealNumber sökning:" + "\t" + indexOf(rArray, new RealNbr(10)));

        //8---------------------
        System.out.println("8." + "\t");
        ArrayList<Integer> list = fillInteger(100000, 10000, 50000);
        ArrayList<RealNbr> rList = new ArrayList<RealNbr>();
        for (Integer integer : list)
            rList.add(new RealNbr(integer));
        Collections.sort(rList);
        for (int i = 10000; i < 50001; i += 10000) {
            System.out.print("i: " + i + " \t" + Collections.binarySearch(rList, new RealNbr(i)) + "\t");
        }
        System.out.println();

        //9---------------------
        System.out.println();
        int[] randomArray2 = randomIntArray(10000);
        Arrays.sort(randomArray2);
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < randomArray.length; i++) {
            binarySearch(randomArray, i);
        }
        System.out.println("9. " + "\t" + "Tid det tog: \t" +
                (System.currentTimeMillis() - start2) + " ms");

        //10-------------------

        //11-------------------
        System.out.println("11." + "\t" + binarySearch(test1, "hiv"));

        //12-------------------

        */
        redovisning();
    }

    public void redovisning() {
        RealNbr[] realNbrs = getRealNumberArray(10);
        System.out.println();
        for (RealNbr realNbr : realNbrs) {
            System.out.print(realNbr + " ");
        }
    }

    public int indexOf(double[] array, double value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value)
                return i;
        }
        return -1;
    }

    public int indexOf(String[] array, String texy) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(texy)) {
                return i;
            }
        }
        return -1;
    }

    public int indexOf(int[] array, int value) {
        int res = -1;
        for (int i = 0; (i < array.length) && (res == -1); i++) {
            if (value == array[i])
                res = i;
        }
        return res;
    }

    private void swap(int[] array, int elem1, int elem2) {
        int temp = array[elem1];
        array[elem1] = array[elem2];
        array[elem2] = temp;
    }

    private void shuffle(int[] array) {
        int newPos;
        for (int i = array.length - 1; i > 0; i--) {
            newPos = (int) (Math.random() * (i + 1));
            swap(array, i, newPos);
        }
    }

    public int[] randomIntArray(int count) {
        int[] res = new int[count];
        for (int i = 0; i < res.length; i++)
            res[i] = i;
        shuffle(res);
        return res;
    }

    private void swap(Object[] array, int elem1, int elem2) {
        Object temp = array[elem1];
        array[elem1] = array[elem2];
        array[elem2] = temp;
    }

    private void shuffle(Object[] array) {
        int newPos;
        for (int i = array.length - 1; i > 0; i--) {
            newPos = (int) (Math.random() * (i + 1));
            swap(array, i, newPos);
        }
    }

    public RealNbr[] getRealNumberArray(int n) {
        RealNbr[] array = new RealNbr[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = new RealNbr(i);
        }
        for (RealNbr realNbr : array) {
            System.out.print(realNbr + " ");
        }
        shuffle(array);
        return array;
    }

    public int indexOf(RealNbr[] array, RealNbr value) {
        for (int i = 0; i < array.length; i++) {
            if(array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public int indexOf(Object[] array, Object object) {
        for (int i = 0; i < array.length; i++) {
            if(array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Integer> fillInteger( int n, int min, int max ) {
        int random;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for( int i = 0; i < n; i++ ) {
            random = ( int )( Math.random() * ( max - min + 1 ) ) + min;
            list.add( new Integer( random ) );
        }
        return list;
    }

    public int binarySearch( int[] array, int key ) {
        int res = -1, min = 0, max = array.length - 1, pos;
        while( ( min <= max ) && ( res == -1 ) ) {
            pos = (min + max) / 2;
            if( key == array[ pos ] )
                res = pos;
            else if( key < array[ pos ])
                max = pos - 1;
            else
                min = pos + 1;
        }
        return res;
    }

    public int binarySearch(long[] array, long value) {
        int res = -1, min = 0, max = array.length - 1, pos;
        while( ( min <= max ) && ( res == -1 ) ) {
            pos = (min + max) / 2;
            if( value == array[ pos ] )
                res = pos;
            else if( value < array[ pos ])
                max = pos - 1;
            else
                min = pos + 1;
        }
        return res;
    }

    public int binarySearch(String[] array, String value) {
        int res = -1, min = 0, max = array.length - 1, pos;
        while( ( min <= max ) && ( res == -1 ) ) {
            pos = (min + max) / 2;
            if( value.compareTo(array[pos]) == 0 )
                res = pos;
            else if( value.compareTo(array[pos]) < 0)
                max = pos - 1;
            else
                min = pos + 1;
        }
        return res;
    }

    public int binarySearch(Object[] array, Object value) {
        int res = -1, min = 0, max = array.length - 1, pos;
        while( ( min <= max ) && ( res == -1 ) ) {
            pos = (min + max) / 2;
            if( ((Comparable) value).compareTo(array[pos]) == 0 )
                res = pos;
            else if( ((Comparable) value).compareTo(array[pos]) < 0)
                max = pos - 1;
            else
                min = pos + 1;
        }
        return res;
    }
}
