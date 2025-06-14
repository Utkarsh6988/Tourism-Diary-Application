//Used to write binary data, such as saving image files.

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample {
    public static void main(String[] args) {
        String content = "Utkarsh Arora";
        try (FileOutputStream fos = new FileOutputStream("input.bin")) {
            fos.write(content.getBytes());
            System.out.println("Binary data written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
