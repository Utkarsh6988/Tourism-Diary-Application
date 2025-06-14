import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;

@SuppressWarnings("serial")
public class Calculator extends JFrame implements ActionListener {
	private JTextField display;
	private double firstNumber = 0;
	private String operation = "";
	private boolean startNewInput = true;

	public Calculator() {
		setTitle("Simple Calculator");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		display = new JTextField();
		display.setFont(new Font("Arial", Font.PLAIN, 24));
		display.setHorizontalAlignment(JTextField.RIGHT);
		display.setEditable(false);
		add(display, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel(); // Button to hold calculator buttons
		buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));

		String[] buttons = {
					"7", "8", "9", "/",
					"4", "5", "6", "*",
					"1", "2", "3", "-",
					"0", ".", "=", "+",
					"C", "CE"
			};

		for (String text : buttons) {
			JButton button = new JButton(text);
			button.setFont(new Font("Arial", Font.PLAIN, 18));
			button.addActionListener(this); // Makes buttons trigger actionPerformed().
			buttonPanel.add(button);
		}
		add(buttonPanel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand(); // Gets the clicked button's text (command).

		if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
			if (startNewInput) {
				display.setText("");
				startNewInput = false;
			}
			display.setText(display.getText() + command);
		} else if (command.equals("C")) {
			display.setText("");
			firstNumber = 0;
			operation = "";
		} else if (command.equals("CE")) {
			display.setText("");
		} else if (command.equals("=")) {
			calculate();
			operation = "";
			startNewInput = true;
		} else { // +, -,*,/
			if (!operation.isEmpty()) {
				calculate();
			}
			firstNumber = Double.parseDouble(display.getText()); // Store the current number in firstNumber.
			operation = command;
			startNewInput = true;
		}
	}

	private void calculate() {
		double secondNumber = Double.parseDouble(display.getText());
		double result = 0;

		switch (operation) {
		case "+":
			result = firstNumber + secondNumber;
			break;
		case "-":
			result = firstNumber - secondNumber;
			break;
		case "*":
			result = firstNumber * secondNumber;
			break;
		case "/":
			if (secondNumber != 0) {
				result = firstNumber / secondNumber;
			} else {
				display.setText("Error");
				return;
			}
			break;
		}
		display.setText(String.valueOf(result));
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> { // SwingUtilities.invokeLater(): Ensures GUI runs on the Event Dispatch
											// Thread (EDT). Use SwingUtilities.invokeLater() for safety.
			Calculator calculator = new Calculator();
			calculator.setVisible(true);
		});
	}

}

//What is the EDT (Event Dispatch Thread) in Swing?
//	The Event Dispatch Thread (EDT) is a special thread in Java Swing responsible for:
//
//		Processing all user interface events (button clicks, mouse movements, key presses).
//
//		Updating GUI components (changing labels, text fields, etc.).

//	Why is the EDT Important?
//			 Thread Safety: Swing components must be accessed/modified only from the EDT.
//			 Avoid Freezing GUI: Long-running tasks on the EDT make the GUI unresponsive.

//	invokeLater(Runnable r):
//		Schedules the Runnable (GUI code) to run on the EDT.