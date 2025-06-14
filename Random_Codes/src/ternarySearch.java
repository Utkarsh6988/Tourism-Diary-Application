////Ternary Search is a divide-and-conquer algorithm to find an element in a sorted array. 
////It works similarly to binary search, but instead of splitting the array into two parts, it splits it into three parts using two midpoints.

import java.util.*;
public class ternarySearch {
     public static int TernarySearch(int arr[], int key) {
    	 int left=0;
    	 int right=arr.length-1;
    	 
    	 int mid1=left+(right-left)/3;   //one-third
    	 int mid2 =right-(right-left)/3;  //two-third
    	 
    	 if(arr[mid1]==key)
    		 return mid1;
    	 if(arr[mid2]==key)
    		 return mid2;
    	 if(key<arr[mid1]) {
    		 right=mid1-1;
    	 }
    	 else if(key>arr[mid2]) {
    		 left=mid2+1;
    	 }
    	 else {
    		 left=mid1+1;
    		 right=mid2-1;
    	 }
    	 return -1;    	 
     }
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter a size of array");
		int n=sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter a array");
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println("Enter key to be searched");
		int key = sc.nextInt();
		int result = TernarySearch(arr,key);
		System.out.println("Array is:");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+ " ");
		}
		if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }
			
		sc.close();

	}

}

//public class ternarySearch {
//
//    public static int ternarySearch(int[] arr, int key) {
//        int left = 0;
//        int right = arr.length - 1;
//
//        while (left <= right) {
//            // Divide the range into 3 parts
//            int mid1 = left + (right - left) / 3;
//            int mid2 = right - (right - left) / 3;
//
//            if (arr[mid1] == key) {
//                return mid1;
//            }
//            if (arr[mid2] == key) {
//                return mid2;
//            }
//
//            if (key < arr[mid1]) {
//                right = mid1 - 1;
//            } else if (key > arr[mid2]) {
//                left = mid2 + 1;
//            } else {
//                left = mid1 + 1;
//                right = mid2 - 1;
//            }
//        }
//
//        return -1; // Key not found
//    }
//
//    public static void main(String[] args) {
//        int[] arr = {1, 4, 7, 10, 15, 18, 21, 27, 30};
//        int key = 18;
//
//        int result = ternarySearch(arr, key);
//
//        if (result != -1) {
//            System.out.println("Element found at index: " + result);
//        } else {
//            System.out.println("Element not found.");
//        }
//    }
//}

