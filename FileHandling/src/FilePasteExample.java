import java.io.IOException;
import java.nio.file.*;

public class FilePasteExample {
    public static void main(String[] args) {
        Path tempLocation = Paths.get("D:\\temp\\source.txt");
        Path destination = Paths.get("D:\\new_location\\source.txt");
        
        try {
            // Create parent directory if it doesn't exist
            if (!Files.exists(destination.getParent())) {
                Files.createDirectories(destination.getParent());
            }
            
            // Paste (copy) the file from temp to destination
            Files.copy(tempLocation, destination,
                     StandardCopyOption.REPLACE_EXISTING,
                     StandardCopyOption.COPY_ATTRIBUTES); 
            
            // Optionally delete the temp file after pasting
            Files.delete(tempLocation);
            
            System.out.println("File pasted successfully to: " + destination);
        } catch (IOException e) {
            System.err.println("Error pasting file: " + e.getMessage());
        }
    }
}