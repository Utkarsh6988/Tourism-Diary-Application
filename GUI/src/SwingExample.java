import javax.swing.*;

public class SwingExample {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Swing Window");
        
        // Set size (width, height)
        frame.setSize(400, 400);
        
        // Ensure program exits when window closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Make the window visible
        frame.setVisible(true);
    }
}