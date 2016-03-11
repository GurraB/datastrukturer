package f13;

public class HashCode {
	private int hashIndex(String id) {
		int nbr1=Integer.parseInt(id.substring(1,5));
		int nbr2=Integer.parseInt(id.substring(7));
		return (nbr1+nbr2)%103;
	}
	
	public void example1() {
	    String id1 = "691025-2365";
		String id2 = "781130-1171";
        String id3 = "980317-6549";
		System.out.println(id1 + ": " + hashIndex(id1));
		System.out.println(id2 + ": " + hashIndex(id2));
		System.out.println(id3 + ": " + hashIndex(id3));
	}
	
	
	public static void main(String[] args) {
		HashCode code = new HashCode();
		code.example1();
	}
}
