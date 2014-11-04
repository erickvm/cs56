import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


 /** 
	NewQuestion class handles data from Question class
	
	@author Erick Valle and George Barrios
	@version Conversion Quiz for CS56, Winter 2012

 */

public class NQuestion{
    
   
    // questions arrayList for Objects of type Question
    private ArrayList<Question> questions = new ArrayList<Question> ();
    // answers holds the answers that the user enters
    private ArrayList<String> answers = new ArrayList<String> ();
    // stringQues holds the string format of all questions created
    private ArrayList<String> stringQues = new ArrayList<String> ();
    // decimalNum holds the decimal numbers to used in th questions
    private ArrayList<Integer> decimalNum = new ArrayList<Integer>();
    // radix holds the radix values of the question
    private ArrayList<Integer>  radix = new ArrayList<Integer>(); 
    
    private int totalQuestions;
    // holds the amount of correct questions 
    private ArrayList<Integer> scoreArray = new ArrayList<Integer>();


    /**
     *  
     * @param numOfQuestions  numOfQuestions Number of Questions to create
     *  
     */
    

    public NQuestion (int numOfQuestions ){
	this.totalQuestions = numOfQuestions;

    }
    
    public Question getQuesions(int index){
	return this.questions.get(index);
    }
    
    public String getStringQues(int index){
	return this.stringQues.get(index);
    }
    public int getDecimalNum(int index){
	return this.decimalNum.get(index);
    }
    
    public String getAnswers(int index){
	return this.answers.get(index);
    }
    
    public void addAnswer(int index, String ans){
	this.answers.add(index, ans);
    }
    public void setRadixValue(int radix) {
	this.radix.add(radix);

    }

    public int getRadixValue(int index){
	return this.radix.get(index);
	
    }
    
    

    
    public int getSize(){
	return this.totalQuestions;
    }
    

    
    
    public int getScore() {
	return this.scoreArray.size();
    }
    public void makeQuestion(){
	Question getValues = new Question();
	this.questions.add(getValues);
	String completeQuestion = getValues.generateQuestion();
	this.stringQues.add(completeQuestion);
	int valueToconvert = getValues.getNum();
	this.decimalNum.add(valueToconvert);
	int radiaxVa = getValues.getIntRadix();
	this.setRadixValue(radiaxVa);
	
    }

   
    
    public void printQuestion() {
	for(int numQues = 0; numQues < this.getSize(); numQues++){
	    this.makeQuestion();
	    
	}
    }
    
   
    
    public String checkAnswers(int qs, String ans){
	try {
	    int radix = this.getRadixValue(qs);
	    int convertedInt = Integer.parseInt(ans, radix);

	
	    String convertedAns = (new Integer(convertedInt)).toString();
	    if ((this.decimalNum.get(qs) == convertedInt)){
		
		scoreArray.add(1);
		return "Correct";
	    }
	    else 
		return "Wrong";
	}catch (NumberFormatException ex){
	    return "Invalid";
	}
	
    }

    public String scoreResults() {
	double size = this.getSize();
	double quesCorrect = this.getScore();
	double score1 = (quesCorrect/size)*100.0;
	float score2 = Math.round(score1);
	
	return ("Your score: " + score2 +"%");
    }



  
}