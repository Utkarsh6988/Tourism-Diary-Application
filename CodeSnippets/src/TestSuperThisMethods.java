class C {
	void method() {
		System.out.println("Class A method");
	}
}

class D extends C {
	void method() {
		System.out.println("Class B method");
	}

	void callMethod() {
		this.method();
		super.method();
	}
}

public class TestSuperThisMethods {
	public static void main(String[] args) {
		D d = new D();
		d.callMethod();
	}
}