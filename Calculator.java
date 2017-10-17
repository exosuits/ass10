package ass10;//클리어 구현

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class Calculator extends JFrame {
	private String spch;
	private int num, sum, total;
	private int count = 0, input = 0;
	private final String names[] = { "7", "8", "9", "-", 
									 "4", "5", "6", "+", 
									 "1", "2", "3", "*", 
									 "0", "C", "=", "/" };
	private JTextField Tfield;

	public Calculator() {
		JPanel Panel1 = new JPanel(new BorderLayout(5, 2));
		Tfield = new JTextField("", SwingConstants.CENTER);
		Tfield.setHorizontalAlignment(JTextField.RIGHT);
		Panel1.add(Tfield, BorderLayout.CENTER);
		JPanel Panel2 = new JPanel(new GridLayout(5, 5));
		JButton buttons[] = new JButton[names.length];
		
		for (int count = 0; count < names.length; count++) {
			buttons[count] = new JButton(names[count]);
			Panel2.add(buttons[count]);
			PadInput handler = new PadInput();
			buttons[count].addActionListener(handler);
		}
		add(Panel1, BorderLayout.NORTH);
		add(Panel2, BorderLayout.CENTER);
		setSize(210, 350);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	private class PadInput implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String eventText = event.getActionCommand();

			if (eventText.equals("+")){
				input = 1;
			} 
			
			else if (eventText.equals("-")){
				input = 2;
			} 
			
			else if (eventText.equals("*")){
				input = 3;
			} 
			
			else if (eventText.equals("/")){
				input = 4;
			}
			
			else if (eventText.equals("=")){
				input = 5;
			} 
			else if (eventText.equals("C")){
				input = 6;
			}
			
			else {
				if (count == 1){
					Tfield.setText("");
					count = 0;
				}
				Tfield.setText(Tfield.getText() + event.getActionCommand()); 
			}

			try {
				if ((total != 0) && (input <= 6)){
					Tfield.setText(Tfield.getText()); 
				} 
				else {
					if (input == 1){
						num = Integer.parseInt(Tfield.getText()); 
						total += num; 
						num = 0; 
						Tfield.setText(String.valueOf(total)); 
						count = 1;
						spch = "+"; 
					} 
					
					else if (input == 2){
						num = Integer.parseInt(Tfield.getText());
						total += num;
						num = 0;
						Tfield.setText(String.valueOf(total));
						count = 1;
						spch = "-";
					} 
					
					else if (input == 3){
						num = Integer.parseInt(Tfield.getText());
						total += num;
						num = 0;
						Tfield.setText(String.valueOf(total));
						count = 1;
						spch = "*";
					} 
					
					else if (input == 4){
						num = Integer.parseInt(Tfield.getText());
						total += num;
						num = 0;
						Tfield.setText(String.valueOf(total));						
						count = 1;
						spch = "/";
					}
					else if(input == 6){
						  Tfield.setText("");
						   num = 0;
						   total = 0;
						   sum = 0;
						   count = 0;
						   input = 0;
					}
				}
			} 
			catch (Exception e){
				System.out.println(" Error ==> " + e);
			}

			if (total == 0) 
			{
				Tfield.setText(Tfield.getText()); 
			} else {
				if ((input == 5) && spch.equals("+")) 
				{
					num = Integer.parseInt(Tfield.getText()); 
					sum = num + total; 
					count = 1;
					num = 0;
					total = 0;
					Tfield.setText(String.valueOf(sum)); 
				} 
				else if ((input == 5) && spch.equals("-")){				
					num = Integer.parseInt(Tfield.getText());
					sum = total - num;
					count = 1;
					num = 0;
					total = 0;
					Tfield.setText(String.valueOf(sum));					
				} 
				else if ((input == 5) && spch.equals("*")){					
					num = Integer.parseInt(Tfield.getText());
					sum = num * total;
					count = 1;
					num = 0;
					total = 0;
					Tfield.setText(String.valueOf(sum));
				} 
				else if ((input == 5) && spch.equals("/")){				
					num = Integer.parseInt(Tfield.getText());
					sum = total / num;
					count = 1;
					num = 0;
					total = 0;
					Tfield.setText(String.valueOf(sum));
				}
				else if((input==6)&&spch.equals("C")){
					 Tfield.setText("");
					   num = 0;
					   total = 0;
					   sum = 0;
					   count = 0;
					   input = 0;
				}
			}
		}
	}	

	public static void main(String args[]) {
		Calculator start = new Calculator();

	}
}
