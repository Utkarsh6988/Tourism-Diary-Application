import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import javax.swing.undo.*;
import java.awt.BorderLayout;

public class Menubar {
	private static JFrame frame;
	private static JTextArea textArea;
	private static UndoManager undoManager = new UndoManager();
	private static JPanel mainPanel;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			createAndShowGUI();
		});
	}

	private static void createAndShowGUI() {
		frame = new JFrame("Notepad");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 500);

		mainPanel = new JPanel(new BorderLayout());
		frame.add(mainPanel);

		createNewTextArea();

		JMenuBar menuBar = createMenuBar();
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
	}

	private static void createNewTextArea() {
		// Remove previous text area if exists
		if (textArea != null) {
			mainPanel.removeAll();
		}

		textArea = new JTextArea();
		mainPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);

		// Reset undo manager
		undoManager.discardAllEdits();

		// Setup undo manager for new text area
		textArea.getDocument().addUndoableEditListener(e -> {
			undoManager.addEdit(e.getEdit());
			updateUndoRedoStates();
		});

		mainPanel.revalidate(); // In Swing, revalidate() and repaint() are important methods for updating the
								// GUI when you make changes to components dynamically.Tells the layout manager
								// to recalculate the layout of the container and its children
		mainPanel.repaint(); // Requests that the component be repainted (redrawn)
	}

	private static JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		// File Menu
		JMenu fileMenu = new JMenu("File");
		JMenuItem newItem = new JMenuItem("New");
		JMenuItem saveItem = new JMenuItem("Save");
		JMenuItem closeItem = new JMenuItem("Close");

		newItem.addActionListener(e -> {     //ActionListner is a functional interface
			createNewTextArea();
			showSweetAlert("New File Created!", "info");
		});
		saveItem.addActionListener(e -> showSweetAlert("File Saved Successfully!", "success"));
		closeItem.addActionListener(e -> {
			int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to close?", "Confirm Close",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				showSweetAlert("File Closed Successfully", "info");
			}
		});

		fileMenu.add(newItem);
		fileMenu.add(saveItem);
		fileMenu.addSeparator();
		fileMenu.add(closeItem);

		// Edit Menu
		JMenu editMenu = new JMenu("Edit");

		// Cut/Copy/Paste
		Action cutAction = new DefaultEditorKit.CutAction();
		cutAction.putValue(Action.NAME, "Cut");
		cutAction.putValue(Action.SHORT_DESCRIPTION, "Cut to Clipboard");

		Action copyAction = new DefaultEditorKit.CopyAction();
		copyAction.putValue(Action.NAME, "Copy");
		copyAction.putValue(Action.SHORT_DESCRIPTION, "Copy to Clipboard");

		Action pasteAction = new DefaultEditorKit.PasteAction();
		pasteAction.putValue(Action.NAME, "Paste");
		pasteAction.putValue(Action.SHORT_DESCRIPTION, "Paste from Clipboard");

		JMenuItem cutItem = new JMenuItem(cutAction);
		JMenuItem copyItem = new JMenuItem(copyAction);
		JMenuItem pasteItem = new JMenuItem(pasteAction);

		cutItem.setAccelerator(KeyStroke.getKeyStroke("control X"));
		copyItem.setAccelerator(KeyStroke.getKeyStroke("control C"));
		pasteItem.setAccelerator(KeyStroke.getKeyStroke("control V"));

		// Undo/Redo
		JMenuItem undoItem = new JMenuItem("Undo");
		undoItem.addActionListener(e -> {
			if (undoManager.canUndo()) {
				undoManager.undo();
				updateUndoRedoStates();
			}
		});

		JMenuItem redoItem = new JMenuItem("Redo");
		redoItem.addActionListener(e -> {
			if (undoManager.canRedo()) {
				undoManager.redo();
				updateUndoRedoStates();
			}
		});

		undoItem.setAccelerator(KeyStroke.getKeyStroke("control Z"));
		redoItem.setAccelerator(KeyStroke.getKeyStroke("control Y"));

		cutItem.addActionListener(e -> showSweetAlert("Text Cut to Clipboard", "info"));
		copyItem.addActionListener(e -> showSweetAlert("Text Copied to Clipboard", "success"));
		pasteItem.addActionListener(e -> showSweetAlert("Text Pasted from Clipboard", "info"));

		editMenu.add(cutItem);
		editMenu.add(copyItem);
		editMenu.add(pasteItem);
		editMenu.addSeparator();
		editMenu.add(undoItem);
		editMenu.add(redoItem);

		// Format Menu
		JMenu formatMenu = new JMenu("Format");

		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(formatMenu);

		return menuBar;
	}

	private static void updateUndoRedoStates() {
		// Can be used to enable/disable undo/redo buttons based on availability
	}

	private static void showSweetAlert(String message, String type) {
		String title;
		int messageType;

		switch (type.toLowerCase()) {
		case "success":
			title = "Success!";
			messageType = JOptionPane.INFORMATION_MESSAGE;
			break;
		case "error":
			title = "Error!";
			messageType = JOptionPane.ERROR_MESSAGE;
			break;
		case "warning":
			title = "Warning";
			messageType = JOptionPane.WARNING_MESSAGE;
			break;
		default:
			title = "Info";
			messageType = JOptionPane.INFORMATION_MESSAGE;
		}

		JOptionPane.showMessageDialog(frame, message, title, messageType);
	}
}





//import javax.swing.*;
//import java.awt.*;
//import javax.swing.text.DefaultEditorKit;
////import java.awt.event.ActionEvent;
////import java.awt.event.ActionListener;
////import java.io.File;
//
//public class WindowFrame {
//	public static void main(String args[])
//	{
//		     // Create the GUI components
//		     JFrame f=new JFrame("Notepad");
//		     JMenuBar m=new JMenuBar();
//		     JMenu file=new JMenu("File");
//		     JMenu edit=new JMenu("Edit");
//		     JMenu format=new JMenu("Format");
//		     JMenuItem New=new JMenuItem("New");
//		     JMenuItem Open=new JMenuItem("Open");
//		     JMenuItem Save=new JMenuItem("Save");
//		     JMenuItem Close=new JMenuItem("Close");
//		     
//		   	 // add menubar to frame, menu to menubar 
//		     // and menuitem to menu
//		     f.setVisible(true);
//		     f.setSize(600,500);
//		     f.add(m);
//		     f.setJMenuBar(m);
//		     f.getContentPane().setBackground(Color.LIGHT_GRAY);
//
//		     //
//		     m.add(file);
//		     m.add(edit);
//		     m.add(format);
//		     file.add(New);
//		     file.add(Open);
//		     file.add(Save);
//		     file.add(Close);
//		     // add a text area
//		     JTextArea ta=new JTextArea();
//		     f.add(ta);
//		     // Implement Cut, Copy and Paste
//		     Action cut = new DefaultEditorKit.CutAction();// Action Interface
//	         Action copy = new DefaultEditorKit.CopyAction();// static inner class constructor
//	         Action paste = new DefaultEditorKit.PasteAction();
//		   
//	         cut.putValue(Action.NAME, "Cut");
//	         copy.putValue(Action.NAME, "Copy");
//	         paste.putValue(Action.NAME, "Paste");
//	    
//	         edit.add(new JMenuItem(cut));
//	         edit.add(new JMenuItem(copy));
//	         edit.add(new JMenuItem(paste));
//	         // 
//	         
//	         
//	         
//	}
//}