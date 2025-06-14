class Animal{
	void eat() {
		System.out.println("Animal is eating");
	}
}
class Dog extends Animal{
	void bark() {
		System.out.println("Dog is Barking");
	}
}
class Puppy extends Dog {
	void weep() {
		System.out.println("Puppy is weeping");
	}
}

public class MultilevelInheritance {
   public static void main(String[]args) {
	   Puppy myPuppy = new Puppy();
	   
	   myPuppy.eat();
	   myPuppy.bark();
	   myPuppy.weep();
   }
}
