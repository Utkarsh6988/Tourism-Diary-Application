class AnimalNew {
 void eat() {
     System.out.println("Animal is eating");
 }
}

class Bird extends AnimalNew {
 void chirp() {
     System.out.println("Bird is chirping");
 }
}

class Cat extends AnimalNew {
 void meow() {
     System.out.println("Cat is meowing");
 }
}

class Cow extends AnimalNew {
 void moo() {
     System.out.println("Cow is mooing");
 }
}

public class HierarichalInheritance {
 public static void main(String[] args) {
     Bird myBird = new Bird();
     Cat myCat = new Cat();
     Cow myCow = new Cow();
     
     myBird.eat();
     myBird.chirp();
     
     myCat.eat();
     myCat.meow();
     
     myCow.eat();
     myCow.moo();
 }
}