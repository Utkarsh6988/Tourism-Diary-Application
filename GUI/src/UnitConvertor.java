// Design a GUI for Unit Converter from kilogram to gram 
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UnitConvertor {
    public static void main(String[] args) {
	      
    	JFrame frame = new JFrame("Kilogram to Gram Converter");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(400,200);
    	frame.setLayout(new BorderLayout(10,10));
    	
    	JPanel inputPanel = new JPanel(new GridLayout(2,2,10,10));
    	inputPanel.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));
    	
    	JLabel kgLabel = new JLabel("Kilogram (kg): ");
    	JTextField kgTextField = new JTextField();
    	JLabel gLabel = new JLabel("Gram (g): ");
    	JTextField gTextField = new JTextField();
    	gTextField.setEditable(false);
    	
    	inputPanel.add(kgLabel);
    	inputPanel.add(kgTextField);
    	inputPanel.add(gLabel);
    	inputPanel.add(gTextField);
    	
    	JButton convertButton = new JButton("Convert");
    	convertButton.setFont(new Font("Arial",Font.BOLD,14));
    	
    	JPanel buttonPanel = new JPanel();
    	buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,20,20,20));
    	buttonPanel.add(convertButton);
    	
    	convertButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double kilograms = Double.parseDouble(kgTextField.getText());
					
					double gram = kilograms*1000;
					
					gTextField.setText(String.format("%.2f", gram));
				}
				catch(NumberFormatException ex) {
					
					JOptionPane.showMessageDialog(frame, "Please enter a valid number for kilograms", "Input Error", JOptionPane.ERROR_MESSAGE);
					kgTextField.setText("");
					gTextField.setText("");
				}
				
			}
		});
    	
    	frame.add(inputPanel, BorderLayout.CENTER);
    	frame.add(buttonPanel,BorderLayout.SOUTH);
    	
    	frame.setVisible(true);
    	
    	
     }
}
