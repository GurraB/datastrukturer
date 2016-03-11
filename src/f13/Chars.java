package f13;

public class Chars {
	private char[] value;

	public Chars(String str) {
		value = str.toCharArray();
	}

	// Liknar equals i klassen String
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Chars) {
			Chars anotherChars = (Chars) obj;
			int n = value.length;
			if (n == anotherChars.value.length) {
				while (n-- != 0) {
					if (value[n] != anotherChars.value[n])
						return false;
				}
				return true;
			}
		}
		return false;
	}

	// Liknar hashCode i klassen String
	public int hashCode() {
		int hash = 0;
		for (int i = 0; i < value.length; i++) {
			hash = 31 * hash + value[i];
		}
		return hash;
	}

	public String toString() {
		return String.valueOf(value);
	}
}
