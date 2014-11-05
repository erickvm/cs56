import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * The test class ConverterTest, to test the Converter class
 *
 * @author Erick Valle
 * @version CS56, Winter 2012, Converter
 * @see Converter
 */


public class ConverterTest
{
     
   @Test public void testConvertFromBase2_1()
    {
	// Test base 2 number "10"
	Converter test1 = new Converter();
	test1.convert("10",2);
        assertEquals("2",test1.getBase10());
	assertEquals("2",test1.getBase8());
	assertEquals("2",test1.getBase16());	
    }


    @Test public void testConvertFromBase2_2()
    {
	// default polynomial has degree 0, and value 0
	Converter test = new Converter();
	test.convert("11",2);
        assertEquals("3",test.getBase10());
	assertEquals("3",test.getBase8());
	assertEquals("3",test.getBase16());

	
    }

    @Test public void testConvertFromBase2_3()
    {
	Converter test = new Converter();
	test.convert("100",2);
        assertEquals("4",test.getBase10());
	assertEquals("4",test.getBase8());
	assertEquals("4",test.getBase16());
    }

    @Test public void testConvertFromBase2_4()
    {
	Converter test = new Converter();
	test.convert("1111",2);
        assertEquals("15",test.getBase10());
	assertEquals("17",test.getBase8());
	assertEquals("f",test.getBase16());
    }
    @Test public void testConvertFromBase2_5()
    {
	Converter test = new Converter();
	test.convert("110111",2);
        assertEquals("55",test.getBase10());
	assertEquals("67",test.getBase8());
	assertEquals("37",test.getBase16());
    }

    @Test public void testConvertFromBase2_6()
    {
	Converter test = new Converter();
	test.convert("11100111010",2);
        assertEquals("1850",test.getBase10());
	assertEquals("3472",test.getBase8());
	assertEquals("73a",test.getBase16());
    }

    @Test public void testConvertFromBase8_1()
    {
	Converter test = new Converter();
	test.convert("17",8);
        assertEquals("15",test.getBase10());
	assertEquals("1111",test.getBase2());
	assertEquals("f",test.getBase16());
    }

   @Test public void testConvertFromBase8_2()
    {
	Converter test = new Converter();
	test.convert("25",8);
        assertEquals("21",test.getBase10());
	assertEquals("10101",test.getBase2());
	assertEquals("15",test.getBase16());
    }

   @Test public void testConvertFromBase8_3()
    {
	Converter test = new Converter();
	test.convert("100",8);
        assertEquals("64",test.getBase10());
	assertEquals("1000000",test.getBase2());
	assertEquals("40",test.getBase16());
    }

    @Test public void testConvertFromBase8_4()
    {
	Converter test = new Converter();
	test.convert("10",8);
        assertEquals("8",test.getBase10());
	assertEquals("1000",test.getBase2());
	assertEquals("8",test.getBase16());
    }

    @Test public void testConvertFromBase10_1()
    {
	Converter test = new Converter();
	test.convert("12",10);
        assertEquals("1100",test.getBase2());
	assertEquals("14",test.getBase8());
	assertEquals("c",test.getBase16());
    }

    @Test public void testConvertFromBase10_2()
    {
	Converter test = new Converter();
	test.convert("10",10);
        assertEquals("1010",test.getBase2());
	assertEquals("12",test.getBase8());
	assertEquals("a",test.getBase16());
    }

    @Test public void testConvertFromBase10_3()
    {
	Converter test = new Converter();
	test.convert("9",10);
        assertEquals("1001",test.getBase2());
	assertEquals("11",test.getBase8());
	assertEquals("9",test.getBase16());
    }
    
    @Test public void testConvertFromBase10_4()
    {
	Converter test = new Converter();
	test.convert("19",10);
        assertEquals("10011",test.getBase2());
	assertEquals("23",test.getBase8());
	assertEquals("13",test.getBase16());
    }

    @Test public void testConvertFromBase16_1()
    {
	Converter test = new Converter();
	test.convert("100",16);
        assertEquals("100000000",test.getBase2());
	assertEquals("400",test.getBase8());
	assertEquals("256",test.getBase10());
    }
    
     @Test public void testConvertFromBase16_2()
    {
	Converter test = new Converter();
	test.convert("2b",16);
        assertEquals("101011",test.getBase2());
	assertEquals("53",test.getBase8());
	assertEquals("43",test.getBase10());
    }

     @Test public void testConvertFromBase16_3()
    {
	Converter test = new Converter();
	test.convert("5d",16);
        assertEquals("1011101",test.getBase2());
	assertEquals("135",test.getBase8());
	assertEquals("93",test.getBase10());
    }

     @Test public void testConvertFromBase16_4()
    {
	Converter test = new Converter();
	test.convert("4e",16);
        assertEquals("1001110",test.getBase2());
	assertEquals("116",test.getBase8());
	assertEquals("78",test.getBase10());
    }
     @Test public void testConvertInvalid_1()
    {
	Converter test = new Converter();
	test.convert("5",5);
        assertEquals("Invalid radix",test.getBase2());
	assertEquals("Invalid radix",test.getBase8());
	assertEquals("Invalid radix",test.getBase10());
    }

     @Test public void testConvertInvalid_2()
    {
	Converter test = new Converter();
	test.convert("52",2);
        assertEquals("Invalid type",test.getBase2());
	assertEquals("Invalid type",test.getBase8());
	assertEquals("Invalid type",test.getBase10());
    }
 @Test public void testConvertInvalid_3()
    {
	Converter test = new Converter();
	test.convert("w",16);
        assertEquals("Invalid type",test.getBase2());
	assertEquals("Invalid type",test.getBase8());
	assertEquals("Invalid type",test.getBase10());
    }
     @Test public void testConvertInvalid_4()
    {
	Converter test = new Converter();
	test.convert("888",8);
        assertEquals("Invalid type",test.getBase2());
	assertEquals("Invalid type",test.getBase8());
	assertEquals("Invalid type",test.getBase10());
    }

}