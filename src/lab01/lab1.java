package lab01;

/**
 * Created by Gustaf on 19/01/2016.
 */
public class lab1 {
    public static void main(String[] args) {
        new lab1();
    }

    public lab1() {
        /*print(10, 15);
        System.out.println();

        everySecondReverse("Lärare", 3);
        System.out.println();

        reverse(4, 10);
        System.out.println();

        print("Student", 3);
        System.out.println();

        System.out.println(factiorial(6));

        int[] arr = {23, -45, -20, 10, 8};
        System.out.println(member(17, arr, 0));
        System.out.println(member(23, arr, 0));
        System.out.println(member(23, arr, 2));
        System.out.println(member(10, arr, 0));

        System.out.println(mystery3(arr, 0));
        System.out.println(mystery3(arr, 1));

        System.out.println(mystery4(arr, 0));

        System.out.println(sum(-2, 1));

        System.out.println(reverse("Student"));

        System.out.println(mystery5(4, 1));

        everySecond("Student", 0, 6);

        System.out.println();
        printString("Student", 3, -1);

        System.out.println();
        mystery6(10);

        arr = new int[]{3, 7, -2, 6, 9};
        mystery7(arr, 0);

        System.out.println();
        System.out.println(digits("Student"));
        System.out.println(digits("RDS 435"));
        System.out.println(digits("Pw TT54W41"));

        System.out.println(digits(2145678));
        //System.out.println(fib(40));*/

        taTiden();
    }

    public void print(int min, int max) {
        if (min <= max) {
            System.out.print(min + " ");
            print(min + 1, max);
        }
    }

    public void everySecondReverse(String texy, int pos) {
        if (pos >= 0 && pos < texy.length()) {
            System.out.print(texy.charAt(pos));
            everySecondReverse(texy, pos - 2);
        }
    }

    /*
    3.
    108642

    4.
    10 + 20 = 30
    11 + 19 = 30
    12 + 18 = 30
    13 + 17 = 30
    14 + 16 = 30
    15 + 15 = 30

     */

    public void reverse(int min, int max) {
        if (min <= max) {
            reverse(min + 1, max);
            System.out.print(min + " ");
        }
    }

    public void print(String texy, int pos) {
        if (pos >= 0 && pos < texy.length()) {
            System.out.print(texy.charAt(pos));
            print(texy, pos + 1);
        }
    }

    public long factiorial(long n) {
        if (n <= 1)
            return 1;
        else {
            return n * factiorial(n - 1);
        }
    }

    public boolean member(int nbr, int[] array, int pos) {
        if (pos < array.length) {
            if (array[pos] == nbr)
                return true;
            else
                return member(nbr, array, pos + 1);
        } else
            return false;
    }

    public int mystery3(int[] array, int pos) {
        if (pos >= array.length) {
            return 0;
        } else {
            return array[pos] + mystery3(array, pos + 2);
        }
    }

    public int mystery4(int[] array, int pos) {
        if (pos >= array.length)
            return 0;
        else if (array[pos] < 0)
            return 1 + mystery4(array, pos + 1);
        else
            return mystery4(array, pos + 1);
    }

    public int sum(int min, int max) {
        if (min <= max) {
            return sum(min + 1, max) + min;
        } else
            return 0;
    }

    public String reverse(String texy) {
        if (texy.length() >= 1) {
            String subway = texy.substring(0, texy.length() - 1);
            return texy.substring(texy.length() - 1, texy.length()) + reverse(subway);
        } else
            return "";
    }

    public int mystery5(int n, int res) {
        if (n == 1)
            return res;
        else
            return mystery5(n - 1, n * res);
    }

    public void everySecond(String texy, int pos, int n) {
        if (pos >= 0 && n < texy.length() && pos <= n) {
            System.out.print(texy.charAt(pos));
            everySecond(texy, pos + 1, n);
        }
    }

    public void printString(String texy, int pos, int n) {
        if (pos < texy.length() && pos >= 0) {
            System.out.print(texy.charAt(pos));
            printString(texy, pos + n, n);
        }
    }

    public void mystery6(int a) {
        if (a >= 0) {
            System.out.println("a=" + a);
            mystery6(a - 4);
            mystery6(a - 3);
        }
    }

    private void mystery7(int[] arr, int pos) {
        if ((pos >= 0) && (pos < arr.length)) {
            mystery7(arr, pos + 1);
            System.out.print(arr[pos] + " ");
        }
    }

    public int digits(String texy) {
        if(texy.length() > 0) {
            if (texy.charAt(0) >= '0' && texy.charAt(0) <= '9') {
                return digits(texy.substring(1, texy.length())) + 1;
            } else
                return digits(texy.substring(1, texy.length()));
        }
        else
            return 0;
    }

    public int digits(int nbr) {
        if(nbr > 0) {
            return digits(nbr / 10) + 1;
        }
        else
            return 0;
    }

    public long fib(int n) {
        if(n <= 2)
            return 1;
        else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public void taTiden() {
        long startTid = System.currentTimeMillis();
        for(int n = 0; n < 1000; n++) {
            fib(30);
        }
        System.out.println(System.currentTimeMillis() - startTid);
    }
}