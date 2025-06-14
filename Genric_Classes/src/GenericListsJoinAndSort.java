//create a generic class , define generic method inside it, take the different list , join them and also sort it  and display together
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ListJoiner<T> {
    
    // Generic method to join, sort, and display multiple lists
    @SafeVarargs
    public final void joinSortAndDisplay(List<? extends T>... lists) {
        // Create a new list to hold all elements
        List<T> joinedList = new ArrayList<>();
        
        // Join all lists
        for (List<? extends T> list : lists) {
            joinedList.addAll(list);
        }
        
        // Sort the joined list
        Collections.sort(joinedList, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                // Handle different types by converting to String for comparison
                return o1.toString().compareTo(o2.toString());
            }
        });
        
        // Display the sorted list
        System.out.println("Joined and Sorted List:");
        for (T item : joinedList) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}

public class GenericListsJoinAndSort {
    public static void main(String[] args) {
        ListJoiner<Object> joiner = new ListJoiner<>();
        
        // Example lists of different types
        List<Integer> intList = List.of(3, 1, 2);
        List<String> strList = List.of("Banana", "Apple", "Cherry");
        List<Double> doubleList = List.of(2.2, 1.1, 3.3);
        
        // Join, sort and display the lists
        joiner.joinSortAndDisplay(intList, strList, doubleList);
    }
}


//Uses List<? extends T> to accept lists of any type that extends T



