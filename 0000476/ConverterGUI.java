import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;


/** 
    GUI for Converter 
    
    @author Erick Valle
    @version Converter for CS56, Winter 2012

*/

public class ConverterGUI   {
    
    //JPanel mainPanel;
    Converter converter;
    JFrame theFrame;
    private JButton convert;
    private JButton clear;
    private JTextField base2;
    private JTextField base8;
    private JTextField base10;
    private JTextField base16;
    private JLabel mainPanel;
    private JLabel binary;
    private JLabel decimal;
    private JLabel octal;
    private JLabel hex;
    
    

    

    public static void main (String [] args) {
	ConverterGUI converter = new ConverterGUI();
	converter.build();
    }

    public ConverterGUI(){
	converter = new Converter ();
	convert = new JButton("Convert");
	clear = new JButton("Clear");
	base2   = new JTextField(15);
	base2.setMaximumSize(base2.getPreferredSize());
	base2.setText("");
	base8   = new JTextField(15);
	base8.setText("");
	base8.setMaximumSize(base8.getPreferredSize());
	base10  = new JTextField(15);
	base10.setMaximumSize(base10.getPreferredSize());
	base10.setText("");
	base16  = new JTextField(15);
	base16.setMaximumSize(base16.getPreferredSize());
	base16.setText("");
	binary  = new JLabel("Binary:");
	decimal = new JLabel("Decimal:");
	octal   = new JLabel("Octal:");
        hex     = new JLabel("Hex:");

	
    }

    public void build() {
	theFrame = new JFrame("Converter");
	theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	BorderLayout layout = new BorderLayout();
	JPanel background = new JPanel(layout);
	background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	Box box1 = new Box(BoxLayout.Y_AXIS);
	Box box2 = new Box(BoxLayout.Y_AXIS);
	JPanel button = new JPanel();
	
	button.add(convert);
	button.add(clear);
	// add JLabel  to box1 
	box1.add(binary);
	box1.add(Box.createVerticalStrut(25));
	box1.add(decimal);
	box1.add(Box.createVerticalStrut(25));
	box1.add(octal);
	box1.add(Box.createVerticalStrut(25));
	box1.add(hex);
	box1.add(Box.createVerticalStrut(25));
	

	// add JTextFields to box2
	box2.add(base2);
	box2.add(Box.createVerticalStrut(20));
	box2.add(base10);
	box2.add(Box.createVerticalStrut(20));
	box2.add(base8);
	box2.add(Box.createVerticalStrut(20));
	box2.add(base16);
	box2.add(Box.createVerticalStrut(20));
	
	JPanel labelPanel = new JPanel();
	labelPanel.add(box1);

	Box centerBox = new Box(BoxLayout.X_AXIS);
	centerBox.add(labelPanel);
	centerBox.add(box2);
	
	JLabel title = new JLabel("Insert a number at a text field"); 
	JPanel top = new JPanel();
	top.add(title);


	// add everything to the background
	
	background.add(BorderLayout.CENTER, centerBox);
	//background.add(BorderLayout.CENTER, box2);
	background.add(BorderLayout.SOUTH, button);
	background.add(BorderLayout.NORTH, top);
	


	// Put everything in the JFrame and make it visible
	
	theFrame.getContentPane().add(background);
	theFrame.setSize(450, 290);
	theFrame.setResizable(false);
	theFrame.setVisible(true);

	//Action listener
	convert.addActionListener(new MyConvertListener());
	clear.addActionListener(new MyClearListener());



    }
    
    public void clearTextFields( ){
       
	base2.setText("");
	base8.setText("");
	base10.setText("");
	base16.setText("");
	
    }
    
    public class MyClearListener implements ActionListener {
	public void actionPerformed(ActionEvent e){
	    clearTextFields();
	}
    }
    
    public class MyConvertListener implements ActionListener {
	public void actionPerformed(ActionEvent e){
	       
	    String b2  = base2.getText();
	    String b8  = base8.getText();
	    String b10 = base10.getText();
	    String b16 = base16.getText();
	    if (!b2.isEmpty() ){
		converter.convert(base2.getText(),2);
		base8.setText(converter.getBase8());
		base10.setText(converter.getBase10());
		base16.setText(converter.getBase16());
		
		
		
	    }
	       
	    if (!b8.isEmpty()){
		converter.convert(base8.getText(),8);
		base2.setText(converter.getBase2());
		base10.setText(converter.getBase10());
		base16.setText(converter.getBase16());
		  
		
	    }
	           
	    if (!b10.isEmpty()){
		converter.convert(b10,10);
		base2.setText(converter.getBase2());
		base8.setText(converter.getBase8());
		base16.setText(converter.getBase16());
		       
		       
	    }
	          
	    if (!b16.isEmpty()){
		converter.convert(b16,16);
		base2.setText(converter.getBase2());
		base10.setText(converter.getBase10());
		base8.setText(converter.getBase8());
		     
		   
	    }
	       
	        
	}
    }
    

    
       
       
}//closes ConverterGUI