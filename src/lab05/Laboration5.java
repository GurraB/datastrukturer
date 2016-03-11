package lab05;
import java.util.*;

public class Laboration5 {
    public void reverse(Double[] array) {
        DoubleStack dStack = new DoubleStack(array.length);
        for (int i = 0; i < array.length; i++) {
            dStack.push(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = dStack.pop();
        }
    }
    
    public void descending(Double[] array) {
        Arrays.sort(array);
        reverse(array);
    }
    
    public void uppgift5() {
        Double[] arr = {new Double(5),new Double(14),new Double(12),new Double(9),
        		        new Double(3),new Double(7),new Double(5),new Double(12)};
        reverse( arr );
        for(Double d : arr) {
            System.out.print(d+" ");
        }
    }
    
    public void uppgift6() {
        Double[] arr = {new Double(5),new Double(14),new Double(12),new Double(9),
		                new Double(3),new Double(7),new Double(5),new Double(12)};
        descending( arr );
        for(Double d : arr) {
            System.out.print(d+" ");
        }
    }
    
    public static void main(String[] args) {
        Laboration5 lab6 = new Laboration5();
        lab6.uppgift5();
        System.out.println();
        lab6.uppgift6();
    }
}
