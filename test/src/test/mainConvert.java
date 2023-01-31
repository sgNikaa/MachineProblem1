package test;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;

public class mainConvert {

	private JFrame frame;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainConvert window = new mainConvert();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainConvert() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		final JComboBox<ArrayList> comboBox;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("Binary");
		list.add("Decimal");
		list.add("Hexadecimal");
		list.add("Octal");
		comboBox = new JComboBox(list.toArray());
		comboBox.setBounds(211, 22, 191, 22);
		frame.getContentPane().add(comboBox);
		JLabel lblNewLabel = new JLabel("Select Numbering System");
		lblNewLabel.setBounds(62, 26, 191, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Value");
		lblNewLabel_1.setBounds(131, 52, 70, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(211, 49, 191, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Result:");
		lblNewLabel_2.setBounds(131, 109, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		final JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(131, 124, 271, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		final JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(131, 142, 271, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		final JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(131, 160, 271, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == comboBox)
		        {
		            int state = e.getStateChange();

		            if(state == ItemEvent.SELECTED)
		            {
		              String item = (String) comboBox.getSelectedItem();

		              
		              if(item.equalsIgnoreCase("binary")) {
		            	  
		            	  try {
		            		  Integer.parseInt(textField.getText(),2);
		            		  
		            		  lblNewLabel_3.setText(String.format("Decimal: %s", Integer.parseInt(textField.getText(),2)));
				              lblNewLabel_4.setText(String.format("Hexadecimal: %s", Integer.toHexString(Integer.parseInt(textField.getText(),2)).toUpperCase()));
				              lblNewLabel_5.setText(String.format("Octal: %s", Integer.toOctalString(Integer.parseInt(textField.getText(),2))));
				              
		            	  }catch (NumberFormatException error) {
		            		  
		            		  JOptionPane.showMessageDialog(frame,"Input must be in binary format and not blank.");
		            		  
		            	  }
		              }else if(item.equalsIgnoreCase("decimal")) {
		            	  
		            	  try {
		            		  
		            		  Integer.parseInt(textField.getText());
		            		  
		            		  lblNewLabel_3.setText(String.format("Binary: %s", Integer.toBinaryString(Integer.parseInt(textField.getText()))));
				              lblNewLabel_4.setText(String.format("Hexadecimal: %s", Integer.toHexString(Integer.parseInt(textField.getText())).toUpperCase()));
				              lblNewLabel_5.setText(String.format("Octal: %s", Integer.toOctalString(Integer.parseInt(textField.getText()))));	
		            		  
		            	  }catch (NumberFormatException error){
		            		  
		            		  JOptionPane.showMessageDialog(frame,"Input must be in decimal format and not blank.");
		            		  
		            	  }
			          
		              }else if(item.equalsIgnoreCase("Hexadecimal")) {
		            	  
		            	  try {
		            		  
		            		  Integer.parseInt(textField.getText(),16);
		            		  lblNewLabel_3.setText(String.format("Binary: %s", Integer.toBinaryString(Integer.parseInt(textField.getText(),16))));
				              lblNewLabel_4.setText(String.format("Decimal: %s", Integer.parseInt(textField.getText(),16)));
				              lblNewLabel_5.setText(String.format("Octal: %s", Integer.toOctalString(Integer.parseInt(textField.getText(),16))));	
				              
		            	  }catch (NumberFormatException error){
		            		  
		            		  JOptionPane.showMessageDialog(frame,"Input must be in hexadecimal format and not blank.");
		            		  
		            	  }
		            	  
		              }else if(item.equalsIgnoreCase("Octal")) {
		            	  
		            	  //test
		            	  try {
		            		  
		            		  Integer.parseInt(textField.getText(),8);
		            		  lblNewLabel_3.setText(String.format("Binary: %s", Integer.toBinaryString(Integer.parseInt(textField.getText(),8))));
		            		  lblNewLabel_5.setText(String.format("Hexadecimal: %s", Integer.toHexString(Integer.parseInt(textField.getText(),8)).toUpperCase()));
				              lblNewLabel_4.setText(String.format("Decimal: %s", Integer.parseInt(textField.getText(),8)));
				              
		            	  } catch (NumberFormatException error) {
		            		  
		            		  JOptionPane.showMessageDialog(frame,"Input must be in octal format and not blank.");
		            		  
		            	  }
			              
		              }
		              //
		            }
		        }
			}
			
		});
		
	}
}
