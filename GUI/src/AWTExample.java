import java.awt.*;
import java.awt.event.*;  // Required for WindowListener

public class AWTExample {
    public static void main(String[] args) {
        // Create the frame
        Frame frame = new Frame("AWT Window");
        frame.setSize(400, 400);

        // Add WindowListener to handle closing
//        frame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);  // Terminate the program when window closes
//            }
//        });
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose(); // Close this window
                System.exit(0);  // Terminate all AWT threads
            }
        });

        // Make the window visible
        frame.setVisible(true);
    }
}