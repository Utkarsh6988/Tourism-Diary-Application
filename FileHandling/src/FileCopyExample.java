import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopyExample {
    public static void main(String[] args) {
        Path sourcePath = Paths.get("D:\\Data.txt");
        Path targetPath = Paths.get("D:\\Info.txt");

        try {
            // Only perform ONE copy operation
            Files.copy(
                sourcePath, 
                targetPath, 
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
            );
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}




//The StandardCopyOption enum provides options for file copy operations in Java's NIO package.
//Let's break down the two options you're asking about:
//
//1. REPLACE_EXISTING
//What it does:
//
//If the target file already exists, this option tells Java to overwrite it
//
//Without this option, the copy operation would fail with FileAlreadyExistsException
//
//When to use it:
//
//When you want to force overwrite an existing file
//
//When you're not sure if the target exists and want to ensure the copy succeeds
//
//2. COPY_ATTRIBUTES
//What it does:
//
//Copies all possible file attributes from the source to the target
//
//This includes (where supported by the filesystem):
//
//Last modified time
//
//File permissions
//
//Owner information
//
//Other platform-specific attributes
//
//When to use it:
//
//When you need an exact duplicate including metadata
//
//When file timestamps are important to preserve
//
//When permissions need to be maintained

