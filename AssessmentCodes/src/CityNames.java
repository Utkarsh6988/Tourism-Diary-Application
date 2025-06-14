import java.util.Scanner;

public class CityNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] cities = new String[10];
        
        System.out.println("Enter 10 city names:");
        

        for (int i = 0; i < 10; i++) {
            System.out.print("City " + (i + 1) + ": ");
            cities[i] = sc.nextLine();
        }
        
        String longestCity = cities[0];
        String shortestCity = cities[0];
        
        for (String city : cities) {
            if (city.length() > longestCity.length()) {
                longestCity = city;
            }
            if (city.length() < shortestCity.length()) {
                shortestCity = city;
            }
        }
        
        // Display results
        System.out.println("\nResults:");
        System.out.println("Longest city name: " + longestCity + " (" + longestCity.length() + " characters)");
        System.out.println("Shortest city name: " + shortestCity + " (" + shortestCity.length() + " characters)");
        
        sc.close();
    }
}