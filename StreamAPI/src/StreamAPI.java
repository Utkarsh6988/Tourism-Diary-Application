//Take a list, find out the numbers divisible by 3 , square them , sort them and put them in a new list.

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {
	public static void main(String[] args) {
          
		List<Integer> num = Arrays.asList(10,9,8,7,6,5,4,3,2,1);     //If we want to convert array into list 
		
		List<Integer> res = num.stream()    //.stream() converts the List into a Stream of integers, This is like opening a pipeline of data that we can process, stream() is a method that creates a Stream from a Collection
				.filter(n->n%3==0) //intermediate functions or operations
				.map(n-> n*n)     //intermediate functions or operations
				.sorted()       //intermediate functions or operations
				.collect(Collectors.toList());
		
		System.out.println(res);
	}
}

//Stream API is used to process collections of objects.
//A stream in Java is a sequence of objects that supports various methods which can be pipelined to produce the desired result.

//Yes, the Stream API in Java utilizes functional interfaces extensively. that's why only we can use lambda expression.


//.collect(...)
//This is a terminal operation of the Stream API. It tells Java to collect the elements produced by the stream pipeline into some kind of result (like a list, set, map, string, etc.).
//
//Collectors.toList()
//This is a collector, specifically one provided by the java.util.stream.Collectors utility class.
//It collects the stream elements into a new List.