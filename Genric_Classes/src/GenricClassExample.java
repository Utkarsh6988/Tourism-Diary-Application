class A<T> // A is a generic type parameter
{
	T t; // T is a data type here

	void get(T t) {
		this.t = t;
	}

	public T display() { // T is a return type here , display() is a generic method 
		{
			return (t);
		}
	}
}

public class GenricClassExample {
	public static void main(String[] args) {
		A<Integer> obj = new A<>(); // Object of Integer type
		obj.get(10);

		System.out.println(obj.display());

		A<String> obj1 = new A<>(); // Object of String type
		obj1.get("Utkarsh");

		System.out.println(obj1.display());
	}
}

//Generics enable the use of stronger type-checking, the elimination of casts, and the ability to develop generic algorithms.
//Without generics, many of the features that we use in Java today would not be possible.

//Generics let you tailor a method, class, structure, or interface to the precise data type it acts upon. 
//For example, instead of using the Hashtable class,which allows keys and values to be of any type, 
//you can use the Dictionary<TKey,TValue> generic class and specify the types allowed for the key and the value

//Generics let you tailor a method, class, structure, or interface to the precise data type it acts upon. 
//For example, instead of using the Hashtable class, which allows keys and values to be of any type, 
//you can use the Dictionary<TKey,TValue> generic class and specify the types allowed for the key and the value

//A generic class is defined just like a normal class, with the addition of a list of type parameters in angle brackets <...> after the class name