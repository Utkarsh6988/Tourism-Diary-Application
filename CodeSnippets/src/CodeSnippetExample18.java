
class Box<T> {
	T t;

	void set(T t) {
		this.t = t;
	}

	T get() {
		return t;
	}
}

public class CodeSnippetExample18 {
	public static void main(String[] args) {
		Box<String> b = new Box<>();
		b.set("GENERIC");
		System.out.print(b.get());
	}
}