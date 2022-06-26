import javax.swing.*;  											//pure java GUI (creates buttons, check-boxes etc...)
import java.awt.*;												//Java interface to native system
import java.awt.event.*;

public class Calculator implements ActionListener{
	
	JFrame frame;
	JTextField textfield; 										//will hold the numbers and the result
	JButton[] numberButtons = new JButton[10]; 					//instance of 10 buttons
	JButton[] functionButtons = new JButton[8]; 				//array of functions buttons
	JButton addButton, subButton, mulButton, divButton; 		//names of functions buttons
	JButton decButton, equButton, delButton, clrButton; 		//names of function buttons
	JPanel panel; 												//create a panel to hold the buttons	
		
	Font myFont = new Font("Ink Free",Font.BOLD,30); 			//create a Font(font,weight,size)
	double num1 = 0, num2 = 0, result = 0;
	char operator; 												//this holds a single character. example:('+', '-', '/')
	
	//this is the constructor
	Calculator(){
		frame = new JFrame("Calculatore"); 						//initial frame and give a title
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	//allows you close the program
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);					//x, y, w, h
		textfield.setFont(myFont);								//add myFont to text field
		frame.add(textfield);									//add text field to frame				
		
		frame.setVisible(true);
	}
	
	//this is the main where everything happens in the program
	public static void main(String[] args) {
		Calculator calc = new Calculator();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
