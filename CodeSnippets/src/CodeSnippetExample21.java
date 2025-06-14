
class Gen<T> {
	T obj;

	Gen(T obj) {
		this.obj = obj;
	}

	T get() {
		return obj;
	}
}

public class CodeSnippetExample21 {
	public static void main(String[] args) {
		Gen<Double> g = new Gen<>(5.5);
		System.out.print(g.get());
	}
}