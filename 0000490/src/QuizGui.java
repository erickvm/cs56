import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;


 /** 
	GUI for Conversion Quiz
	
	@author Erick Valle and George Barrios
	@version Conversion Quiz for CS56, Winter 2012

 */

public class QuizGui   {
    
    //JPanel mainPanel;
    JFrame theFrame;
	
	//Instances so the instance classes can work
	
	private JTextField[] questions;
	
	private JLabel[] answers;
	
	private JLabel[] askit;
	
	private NQuestion quiz;
        
        private JLabel score;

	
	
	//  -------------Main Method
	
    public static void main (String [] args) { 
	QuizGui quiz = new QuizGui();
	quiz.buildQuiz();
			
	
    }
    
    
	
	public QuizGui(){
		
		questions = new JTextField[10];
		
		answers = new JLabel[10];
		
		askit = new JLabel[10];
		
		score =  new JLabel("");
		
		// Static index variable
		int i;
		
	
		for (i=0; i<10; i++) {
			questions[i] = new JTextField(20);
			answers[i] = new JLabel("");
			askit[i] = new JLabel("");
		}
		
		
		
		
		

		
		
		

		
		
		
	}
	
	//---------method that builds the gui
	
    public void buildQuiz(){ 
	
	//Makes the Questions	
	quiz = new NQuestion(10);
	quiz.printQuestion();
		
	//Builds the Frame	
	theFrame = new JFrame("Conversion Quiz");
	theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	BorderLayout layout = new BorderLayout();
	JPanel background = new JPanel(layout);
	background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	
	int i;// Static index variable

	//Laysout the Labels
	Box yesno = new Box(BoxLayout.Y_AXIS);	
	for (i = 0; i<10; i++) {
		yesno.add(answers[i]);
		yesno.add(Box.createVerticalStrut(29));
	}
	
	
	


	//----------Buttons for Check Answers and New Quiz-------
	Box buttons = new Box(BoxLayout.X_AXIS);
	JButton checkAns = new JButton("Check Answer");
	checkAns.addActionListener(new MyAnswerListener() );// Check Answer Event Button
	buttons.add(checkAns);
	buttons.add(Box.createVerticalStrut(10));
	buttons.add(score);
	buttons.add(Box.createVerticalStrut(10));
	
		
	
	JButton makeQuiz = new JButton("New Quiz");
	makeQuiz.addActionListener(new MyMakeQuizListener());
	buttons.add(makeQuiz);
	;
	
	
	
      
        	
  
	// Layout TextFields for input
	Box textFields = new Box(BoxLayout.Y_AXIS);
	for (i = 0; i<10; i++) {
		questions[i].setMaximumSize( questions[i].getPreferredSize() );
		textFields.add(questions[i]);
		textFields.add(Box.createVerticalStrut(25));
	}	
	

	
	
    //Layout Labels that ask the quesstion
	Box textLabel = new Box(BoxLayout.Y_AXIS);
	for (i = 0; i<10; i++) {
	askit[i].setText(quiz.getStringQues(i));
	textLabel.add(askit[i]);
	textLabel.add(Box.createVerticalStrut(28));
	    	
	}	
	
	
	
	
	background.add(BorderLayout.WEST, textLabel);
	background.add(BorderLayout.SOUTH, buttons);
	background.add(BorderLayout.CENTER, textFields);
	background.add(BorderLayout.EAST, yesno);
		


	
	
    theFrame.getContentPane().add(background);
	
    theFrame.setSize(600, 600);
	
	theFrame.setVisible(true);
	
	
	





/*-----------------------EVENT HANDLING CLASSES HERE--------------*/



}
	
	
    public class MyMakeQuizListener implements ActionListener {
	public void actionPerformed(ActionEvent e){
		
		
		theFrame.setVisible(false);
		theFrame.dispose();
		buildQuiz();
		for (int i = 0; i<10; i++) {
			answers[i].setText("");
		}
		for (int i = 0; i<10; i++) {
		    questions[i].setText("");
		}
		score.setText("");
		
	}
    }

    public class MyAnswerListener implements ActionListener {
	    public void actionPerformed(ActionEvent ans){
		
			
			for (int i = 0; i<10; i++) {
				// Gets the index question number and gets the text from the  text field
				//to check if the match, if not, check answer returns "Wrong"
				answers[i].setText(quiz.checkAnswers(i,questions[i].getText()));
				
			}
			score.setText(quiz.scoreResults());
			
			
			
			
	}
    
    }
}

    

