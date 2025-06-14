import java.io.FileOutputStream;
import java.io.IOException;

public class CreateBinaryFile {
    public static void main(String[] args) {
        String content = "This is binary data written to a file.";

        try (FileOutputStream fos = new FileOutputStream("input.bin")) {
            fos.write(content.getBytes()); // converting String to bytes and writing
            System.out.println("input.bin file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


// FileOutputStream Example (Writing Binary File)
//Used to write binary data, such as saving image files.  // it helps to create a file 