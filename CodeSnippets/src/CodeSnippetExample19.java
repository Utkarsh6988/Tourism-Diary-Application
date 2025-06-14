
class Box1<T> {

	T t;

	Box1(T t) {
		this.t = t;
	}

	public String toString() {
		return t.toString();
	}
}

public class CodeSnippetExample19 {
	public static void main(String[] args) {
		Box1<Integer> b = new Box1<>(10);
		System.out.print(b);
	}
}
