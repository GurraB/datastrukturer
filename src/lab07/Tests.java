package lab07;

import f7.ArrayList;

/**
 * Created by Gustaf on 01/02/2016.
 */
public class Tests {
    public static void main(String[] args) {
        new Tests();
    }

    public Tests() {
        testArrayList();
    }

    private void testArrayList() {
        ArrayList<String> list = new ArrayList(2);
        list.add("aa");
        list.add("bb");
        list.add("cc");
        System.out.println(list.toString());
        String a = list.remove(list.size() - 1);
        System.out.println(list.toString());
        System.out.println(a);
        list.set(0, "dd");
        System.out.println(list);
        System.out.println(list.get(0));
    }
}
