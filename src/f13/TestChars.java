package f13;

import java.util.Random;

public class TestChars {
	public void example1() {
		String[] s1 = { "a", "b", "c", "aa", "ab", "ac", "aaa", "aab", "aac" };
		Chars[] s2 = { new Chars("a"), new Chars("b"), new Chars("c"),
				       new Chars("aa"), new Chars("ab"), new Chars("ac"),
				       new Chars("aaa"), new Chars("aab"), new Chars("aac") };
		for (String s : s1) {
			System.out.println(s + ": " + s.hashCode() + ", " + s.hashCode() % 103);
		}
		for (Chars s : s2) {
			System.out.println(s + ": " + s.hashCode() + ", " + s.hashCode() % 103);
		}
	}
	
	
    private Chars randomChars( String str, int n ) {
        String res = "";
        Random rand = new Random();
        for( int i=0; i<n; i++) {
            res += str.charAt(rand.nextInt(str.length()));
        }
        return new Chars(res);
    }
         
    public void example2() {
        int[] hashCount = new int[10];
        String str = "1234567890+qwertyuiopåasdfghjklöä'<zxcvbnm,.-!#¤%&/()=?QWERTYUIOPÅASDFGHJKLÖÄ*>ZXCVBNM;:_";
        Chars chrs;
        int hashCode;
        for( int i=0; i<1000; i++) {
            chrs = randomChars(str, 20);
            hashCode = Math.abs(chrs.hashCode() % hashCount.length); // hash-index
            hashCount[ hashCode ]++;
        }
        
        System.out.println("Index  Antal");
        for( int i=0; i<hashCount.length; i++ ) {
            System.out.println( String.format("%3d%8d",i,hashCount[i]));
        }
    }

	public static void main(String[] args) {
		TestChars prog = new TestChars();
		prog.example1();
//		prog.example2();
	}
}
