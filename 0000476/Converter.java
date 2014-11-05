import java.io.*;
import java.lang.*;



/** 
    Converter
    
    @author Erick Valle
    @version Converter for CS56, Winter 2012

*/
public class Converter {


    private String base10;
    private String base2;
    private String base8;
    private String base16;
    


    public Converter () {
	/**
      @param input should be legit number in fromBase, otherwise throw IllegalArgumentException
      @param fromBase should be 2,8,10, 16. Otherwise, through IllegalArgumentException
      @param toBase same thing
      
	**/
       




    }
    public void convert(String input, int fromBase) {
	//Catch NumberFormatException if user enters invalid number.
	try{
       
	    switch (fromBase) {
	    case 2:
		{   
		           
		    int decimal = this.convertToDecimal(input,2);
		    base10 = Integer.toString(decimal);
		    base8  = Integer.toOctalString(decimal);
		    base16 = Integer.toHexString(decimal);
		    break;
		           
		     

		}
	    case 8:
		{
		    int decimal = this.convertToDecimal(input,8);
		    base2  = Integer.toBinaryString(decimal);
		    base10 = Integer.toString(decimal);
		    base16 = Integer.toHexString(decimal);
		    break;
		}
	    case 10:
		{   int decimal = Integer.parseInt(input);
		    base2 = Integer.toBinaryString(decimal);
		    base8 = Integer.toOctalString(decimal);
		    base16 = Integer.toHexString(decimal);
		    break;
		           
   
		}
	    case 16:
		{
		    int decimal = this.convertToDecimal(input,16);
		    base2  = Integer.toBinaryString(decimal);
		    base8  = Integer.toOctalString(decimal);
		    base10 = Integer.toString(decimal);
		    break;
		           
		} 
	    default:
		{
		    base2  = "Invalid radix";
		    base8  = "Invalid radix";
		    base10 = "Invalid radix";
		    base16 = "Invalid radix";
		           
		}
	    }
	}catch (NumberFormatException ex){
	    base2  = "Invalid type";
	    base8  = "Invalid type";
	    base10 = "Invalid type";
	    base16 = "Invalid type";
	}
    }

    
    public int convertToDecimal(String num, int radix){
	

	return Integer.parseInt(num, radix);
	   
    }
    
    public String getBase2(){
	return this.base2;
    }
    
    public String getBase8(){
	return this.base8;
    }
    
    public String getBase10(){
	return this.base10;
    }
    public String getBase16(){
	return this.base16;
    }
    
    
   
}