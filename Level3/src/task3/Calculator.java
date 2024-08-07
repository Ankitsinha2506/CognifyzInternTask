package task3;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField display;
	private double firstNumber = 0;
	private double secondNumber = 0;
	private String operator = "";
	private boolean startNewNumber = true;
	
	public Calculator() {
		setTitle("Akya's Calculator");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		display = new JTextField();
		display.setEditable(false);
		display.setFont(new Font("Arial", Font.BOLD, 24));
		add(display, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,4,10,10));
		
		String[] buttons = {
				"7", "8", "9", "/",
	            "4", "5", "6", "*",
	            "1", "2", "3", "-",
	            "0", ".", "=", "+"
		};
		
		for(String text : buttons) {
			JButton button = new JButton(text);
			button.setFont(new Font("Arial", Font.BOLD, 24));
			button.addActionListener(this);
			panel.add(button);
		}
		add(panel);
		setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if (command.matches("[0-9.]")) {
			if (startNewNumber) {
				display.setText(command);
				startNewNumber = false;
			} else {
				display.setText(display.getText()+ command);
			}
		} else if (command.equals("=")) {
			try {
				secondNumber = Double.parseDouble(display.getText());
				double result = 0;
				
				switch(operator) {
					case "+" :
						display.setText(Double.toString(firstNumber + secondNumber));
						break;
						
					case "-":
						display.setText(Double.toString(firstNumber - secondNumber));
						break;
					
					case "*":
						display.setText(Double.toString(firstNumber * secondNumber));
						break;
					
					case "/":
						if(secondNumber != 0)
						{
							display.setText(Double.toString(firstNumber / secondNumber));
						} else {
							display.setText("Error");
							startNewNumber = true;
							return;
						}
						break;
				}
				display.setText(Double.toString(result));
			} catch (NumberFormatException ex) {
				display.setText("Error");
			}
			
		} 
		
		
		else {
			if (!startNewNumber) {
				try {
					firstNumber = Double.parseDouble(display.getText());
				} catch (NumberFormatException ex) {
					display.setText("Error");
					startNewNumber = true;
					return;
				}
				operator = command;
				startNewNumber = true;
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		new Calculator();
	}

}
