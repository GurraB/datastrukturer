package lab05;

import java.util.Arrays;

public class DynamicString implements Comparable<DynamicString> {
    private char[] chars;
    private int length;

    public DynamicString() {
        chars = new char[10];
    }

    public DynamicString(DynamicString str) {
        chars = Arrays.copyOf(str.chars, str.length);
        length = str.length;
    }

    public DynamicString(String str) {
        chars = str.toCharArray();
        length = chars.length;
    }

    public void add(char chr) {
        add(length, chr);
    }

    public void add(int index, char chr) {
        checkIndex(index, length);
        if (length == chars.length) {
            chars = Arrays.copyOf(chars, chars.length * 2);
        }
        for (int i = length; i > index; i--) {
            chars[i] = chars[i - 1];
        }
        chars[index] = chr;
        length++;
    }

    public void remove(int index) {
        checkIndex(index, length - 1);
        for (int i = index + 1; i < length; i++) {
            chars[i - 1] = chars[i];
        }
        length--;
    }

    public String toString() {
        return new String(chars, 0, length);
    }

    // tas upp på föreläsning 14
    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < length; i++) {
            hash = 31 * hash + chars[i];
        }
        return hash;
    }

    // kontroll av index
    private void checkIndex(int index, int max) {
        if (index < 0 || index > max) {
            throw new IndexOutOfBoundsException("index: " + index + ", range: 0-" + max);
        }
    }

    public int length() {
        return length;
    }

    public char charAt(int index) {
        if (index <= length)
            return chars[index];
        throw new IndexOutOfBoundsException();
    }

    public void removeAll() {
        chars = new char[length()];
        length = 0;
    }

    public int indexOf(char chr) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == chr)
                return i;
        }
        return -1;
    }

    public DynamicString subString(int start, int end) {
        if (start < 0 || end > length || start > end)
            throw new IndexOutOfBoundsException();
        DynamicString dString = new DynamicString();
        for (int i = 0; i < (end - start); i++) {
            dString.add(chars[start + i]);
        }
        return dString;
    }

    public DynamicString subString(int start) {
        return subString(start, length);
    }

    public void concat(DynamicString str) {
        int strLength = str.length();
        for (int i = 0; i < strLength; i++) {
            add(str.charAt(i));
        }
    }

    @Override
    public int compareTo(DynamicString o) {
        for (int i = 0; i < chars.length && i < o.length(); i++) {
            if (chars[i] < o.charAt(i))
                return -1;
            else if (chars[i] > o.charAt(i))
                return 1;
        }
        return length - o.length();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DynamicString)) {
            return false;
        }
        if (this.compareTo((DynamicString) obj) != 0) {
            return false;
        }
        return true;
    }

    public int indexOf(DynamicString str) {
        int pos;
        if (str.length > length)
            return -1;
        for (int i = 0; i < chars.length; i++) {
            pos = 0;
            for (int j = 0; j < str.length() && (j + i) < length; j++) {
                if (chars[i + j] == str.charAt(j))
                    pos++;
                else
                    break;
            }
            if (pos == str.length())
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        DynamicString ds1 = new DynamicString();            // ds1 -> DynamicString med längden 0
        DynamicString ds2 = new DynamicString("Hej Lisa!"); // ds2 -> DynamicString med 'H','e','j',' ','L','i','s','a','!'
        DynamicString ds3 = new DynamicString(ds2);         // ds3 -> DynamicString med 'H','e','j',' ','L','i','s','a','!'
        System.out.println("ds1: " + ds1);
        System.out.println("ds2: " + ds2);
        System.out.println("ds3: " + ds3);
        ds1.add('J');                                       // ds1 -> 'J'
        ds1.add('a');                                       // ds1 -> 'J','a'
        ds1.add('a');                                       // ds1 -> 'J','a','a'
        ds1.add(2, 'v');                                     // ds1 -> 'J','a','v','a'
        ds2.remove(4);                                      // ds2 -> 'H','e','j',' ','i','s','a','!'
        ds2.remove(4);                                      // ds2 -> 'H','e','j',' ','s','a','!'
        System.out.println("ds1: " + ds1);
        System.out.println("ds2: " + ds2);
        System.out.println("ds3: " + ds3);

        System.out.println("length: " + ds1.length());
        System.out.println("length: " + ds2.length());
        System.out.println("length: " + ds3.length());

        System.out.println();

        System.out.println("charAt(2) = " + ds1.charAt(2));
        System.out.println("charAt(3) = " + ds2.charAt(3));
        System.out.println("charAt(4) = " + ds3.charAt(4));

        ds1.removeAll();
        System.out.println("removeAll: " + ds1.toString() + " length: " + ds1.length());

        System.out.println(ds2.indexOf('e'));

        System.out.println(ds3.subString(2).toString());
        ds2.concat(ds2);
        System.out.println(ds2);

        DynamicString[] strings = {
                new DynamicString("Orm"),
                new DynamicString("Kråka"),
                new DynamicString("Ärm"),
                new DynamicString("Kraka"),
                new DynamicString("ångan"),
                new DynamicString("Kråkan"),
                new DynamicString("ånga"),
                new DynamicString("Ånga"),
                new DynamicString("krycka"),
                new DynamicString("Kräka"),
                new DynamicString("Kräk"),
                new DynamicString("ärm"),
                new DynamicString("Kröka")
        };

        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + " ");
        }
        System.out.println();
        Arrays.sort(strings);
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + " ");
        }

        DynamicString ds4 = new DynamicString("aids");
        DynamicString ds5 = new DynamicString("canceraids");
        System.out.println();
        System.out.println(ds4.equals(ds5));
        System.out.println(ds5.indexOf(ds4));

        DynamicString ds6 = new DynamicString("Studentudent");
        DynamicString ds7 = new DynamicString("ude");
        DynamicString ds8 = new DynamicString("Anders");
        System.out.println(ds6.indexOf(ds7));
        System.out.println(ds6.indexOf(ds8));
    }
}
