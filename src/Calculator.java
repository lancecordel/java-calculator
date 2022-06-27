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
		textfield.setEditable(false);
		
		addButton = new JButton("+");							// create instances of JButtons
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("Clear");
		
		functionButtons[0] = addButton;							// add buttons to array
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		
		for(int i = 0; i < 8; i++) {		//iterate through function array
			functionButtons[i].addActionListener(this);			//and set attributes
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		for(int i = 0; i < numberButtons.length; i++) {			//iterate through buttons array
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		delButton.setBounds(50, 430, 145, 50);					//set location for delete button
		clrButton.setBounds(205,430,145, 50);					//set location for clear button
		
		panel = new JPanel();									//instantiate panel
		panel.setBounds(50, 100,300, 300);						//set location 
		panel.setLayout(new GridLayout(4, 4, 10, 10));			//w, h, top space, right space
//		panel.setBackground(Color.GRAY);						//back ground color of panel

		panel.add(numberButtons[1]);							//add number button
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);									//operator button						
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		frame.add(panel);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);									//add text field to frame				
		frame.setVisible(true);
	}
	
	//this is the main where everything happens in the program
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		System.out.println("hello, How are you Friend?");

	}

	@Override
	public void actionPerformed(ActionEvent e) {				//iterate through numberButtons
		for(int i = 0; i < numberButtons.length; i++) {
			if(e.getSource() == numberButtons[i]) {					//if event is a number button
				textfield.setText(textfield.getText().concat(String.valueOf(i)));		//set text field to the string value of each button concatenated together.
				
			}
		}
		if(e.getSource() == decButton) {							//if event is decimal
			textfield.setText(textfield.getText().concat("."));		//add decimal to strings
		}
		if(e.getSource() == addButton) {							//if event is add button
			num1 = Double.parseDouble(textfield.getText());			//parse contents of text feild to a number then assign it to num1
			operator = '+';											//assign '+' sign to operater
			textfield.setText("");									//set text field to empty
		}
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		if(e.getSource() == equButton){									//if even is '=' parse text field to a number and assign it to num2
			num2 = Double.parseDouble(textfield.getText());
			
			switch(operator){
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1 = result;												//assign result to num1 so continue doing calculations				
		}
		if(e.getSource() == clrButton) {								// if even is clear set text field to an empty 
			textfield.setText("");
		}
		if(e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			
			for(int i = 0; i < string.length() - 1; i++){
				textfield.setText(textfield.getText() + string.charAt(i));
			}
		}
	}

}
