class Parent {
	Parent() {
		System.out.println("Parent constructor");
	}
}

class Child extends Parent {
	Child() {
		super();
		System.out.println("Child constructor");
	}
}

public class TestConstructor {
	public static void main(String[] args) {
		Child c = new Child();  // it will print values 
	}
}
