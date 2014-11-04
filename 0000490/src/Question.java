import java.lang.Math;

/** 
	Question class 
	
	@author Erick Valle and George Barrios
	@version Conversion Quiz for CS56, Winter 2012

 */


public class Question {
    
    private int num;
    
    private String stringRadix;
    
    private int intRadix;
    

    // No argument constructor 
   
    public Question(){
    
    }
    
    // Getters and Setters for our intance variables 
    
    public String getRadix(){
	return this.stringRadix;
    }
    public void setRadix(String radix2){
	this.stringRadix = radix2;
    }
	
    public int getNum(){
		return num;
		}
    public void setNum(int x) {
	this.num = x;
		}
    
    public int getIntRadix() {
	return this.intRadix;
    }
    
    public void setIntRadix(int x) {
	this.intRadix = x;
    }

    // Generates a random option to convert the number to.
    
    public void randomOption(){
	int option = (int)(Math.random()*3);
	
	switch (option) {
	
	case 0:
	    this.setIntRadix(2);
	    this.setRadix("Binary");
	    break;
	case 1:
	    this.setIntRadix(8);
	    this.setRadix("Octal");
	    break;
	case 2:
	    this.setIntRadix(16);
	    this.setRadix("Hexadecimal");
	    break;
			
	}
	

    }
	
    // Creates a random decimal to convert
    
    public void  randomNumber () {
		num = (int)(Math.random()*100);
		this.setNum(num);
		}
    public String generateQuestion() {
	
	this.randomOption();
	this.randomNumber();
	int randomDecimal = this.getNum();
	int radixInt = this.getIntRadix();
	String radixString = this.getRadix();
	 
	return ("Convert " + randomDecimal + " to " + radixString);
    }
}