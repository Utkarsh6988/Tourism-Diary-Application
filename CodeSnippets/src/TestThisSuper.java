class A {
	int x = 10;

	void print() {
		System.out.println("A: " + x);
	}
}

class B extends A {
	int x = 20;

	void print() {
		System.out.println("B: " + x);
	}

	void display() {
		print();
		super.print();
		System.out.println("x = " + x);
		System.out.println("super.x = " + super.x);
	}
}

public class TestThisSuper {
	public static void main(String[] args) {
		B b = new B();
		b.display();
	}
}