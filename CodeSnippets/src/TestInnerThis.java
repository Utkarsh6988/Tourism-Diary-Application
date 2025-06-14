class Outer {
	int x = 100;

	class Inner {
		int x = 200;

		void show() {
			int x = 300;
			System.out.println(x);
			System.out.println(this.x);
			System.out.println(Outer.this.x);
		}
	}
}

public class TestInnerThis {
	public static void main(String[] args) {
		Outer.Inner obj = new Outer().new Inner();
		obj.show();
	}
}