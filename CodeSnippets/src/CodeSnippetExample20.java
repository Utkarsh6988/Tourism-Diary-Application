
class Pair<K, V> {
	K key;
	V value;

	Pair(K k, V v) {
		key = k;
		value = v;
	}

	public String toString() {
		return key + ":" + value;
	}
}

public class CodeSnippetExample20 {
	public static void main(String[] args) {
		Pair<String, Integer> p = new Pair<>("Age", 30);
		System.out.print(p);
	}
}
