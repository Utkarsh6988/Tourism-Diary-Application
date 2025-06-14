
import java.io.File;

public class HiddenFileExample {
    public static void main(String[] args) {
        // Specify the file name
        String fileName = "file1.txt";
        File file = new File(fileName);

        // Check if file exists
        if (file.exists()) {
            // Check if file is hidden
            if (file.isHidden()) {
                System.out.println("The file '" + fileName + "' is hidden.");
                System.out.println("Full path: " + file.getAbsolutePath());
            } else {
                System.out.println("The file '" + fileName + "' is not hidden.");
            }
        } else {
            System.out.println("The file '" + fileName + "' does not exist.");
        }
    }
}
