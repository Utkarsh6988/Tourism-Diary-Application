
interface C{
	public int greatest(int a, int b, int c);
}

public class FunctionalInterfaceExample {
	public static void main(String[]args) {
     C ref = (x,y,z)->  Math.max(Math.max(x, y), z);
     System.out.println("Result:"+ref.greatest(4, 3, 7));
  }
}


// ternary operator approach

//interface C {
//  public int greatest(int a, int b, int c);
//}
//
//public class FunctionalInterfaceExample {
//  public static void main(String[] args) {
//      C ref = (x, y, z) -> (x > y) ? ((x > z) ? x : z) : ((y > z) ? y : z);
//      System.out.println("Result: " + ref.greatest(4, 3, 7));
//  }
//}