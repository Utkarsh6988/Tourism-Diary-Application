public class TrianglePatterns {

    public static void main(String[] args) {
        int rows = 5; // Number of rows for the patterns
        
        System.out.println("1. Right-Angled Triangle (Left Aligned):");
        rightAngleLeft(rows);
        
        System.out.println("\n2. Right-Angled Triangle (Right Aligned):");
        rightAngleRight(rows);
        
        System.out.println("\n3. Inverted Right-Angled Triangle (Left Aligned):");
        invertedRightAngleLeft(rows);
        
        System.out.println("\n4. Inverted Right-Angled Triangle (Right Aligned):");
        invertedRightAngleRight(rows);
        
        System.out.println("\n5. Pyramid Triangle:");
        pyramid(rows);
        
        System.out.println("\n6. Inverted Pyramid Triangle:");
        invertedPyramid(rows);
        
        System.out.println("\n7. Diamond Pattern:");
        diamond(rows);
        
        System.out.println("\n8. Hollow Pyramid:");
        hollowPyramid(rows);
        
        System.out.println("\n9. Pascal's Triangle:");
        pascalsTriangle(rows);
        
        System.out.println("\n10. Floyd's Triangle:");
        floydsTriangle(rows);
    }
    
    // 1. Right-Angled Triangle (Left Aligned)
    public static void rightAngleLeft(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
    // 2. Right-Angled Triangle (Right Aligned)
    public static void rightAngleRight(int rows) {
        for (int i = 1; i <= rows; i++) {
            // Print spaces
            for (int j = rows - i; j >= 1; j--) {
                System.out.print("  ");
            }
            // Print stars
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
    // 3. Inverted Right-Angled Triangle (Left Aligned)
    public static void invertedRightAngleLeft(int rows) {
        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
    // 4. Inverted Right-Angled Triangle (Right Aligned)
    public static void invertedRightAngleRight(int rows) {
        for (int i = rows; i >= 1; i--) {
            // Print spaces
            for (int j = rows - i; j >= 1; j--) {
                System.out.print("  ");
            }
            // Print stars
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
    // 5. Pyramid Triangle
    public static void pyramid(int rows) {
        for (int i = 1; i <= rows; i++) {
            // Print spaces
            for (int j = rows - i; j >= 1; j--) {
                System.out.print(" ");
            }
            // Print stars
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    // 6. Inverted Pyramid Triangle
    public static void invertedPyramid(int rows) {
        for (int i = rows; i >= 1; i--) {
            // Print spaces
            for (int j = rows - i; j >= 1; j--) {
                System.out.print(" ");
            }
            // Print stars
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    // 7. Diamond Pattern
    public static void diamond(int rows) {
        // Upper half
        for (int i = 1; i <= rows; i++) {
            for (int j = rows - i; j >= 1; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // Lower half
        for (int i = rows - 1; i >= 1; i--) {
            for (int j = rows - i; j >= 1; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    // 8. Hollow Pyramid
    public static void hollowPyramid(int rows) {
        for (int i = 1; i <= rows; i++) {
            // Print spaces
            for (int j = rows - i; j >= 1; j--) {
                System.out.print(" ");
            }
            // Print stars
            for (int k = 1; k <= 2 * i - 1; k++) {
                if (k == 1 || k == 2 * i - 1 || i == rows) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    
    // 9. Pascal's Triangle
    public static void pascalsTriangle(int rows) {
        for (int i = 0; i < rows; i++) {
            int number = 1;
            // Print spaces
            for (int j = 0; j < rows - i; j++) {
                System.out.print(" ");
            }
            // Print numbers
            for (int k = 0; k <= i; k++) {
                System.out.print(number + " ");
                number = number * (i - k) / (k + 1);
            }
            System.out.println();
        }
    }
    
    // 10. Floyd's Triangle
    public static void floydsTriangle(int rows) {
        int number = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(number + " ");
                number++;
            }
            System.out.println();
        }
    }
}