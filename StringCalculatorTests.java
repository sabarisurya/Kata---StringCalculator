package kata;

import org.junit.*;
import static org.junit.Assert.*;

public class StringCalculatorTests {

	static StringCalculator ob;
	@BeforeClass
	public static void creatObj()
	{
		ob = new StringCalculator();
	}
	
	@Test
	public void task_1_2_testAdd()
	{
		System.out.println("\nTest-1\n");
		assertEquals(0,ob.add(""));
		assertEquals(32,ob.add("32"));
		assertEquals(3,ob.add("1,2"));
		assertEquals(30,ob.add("10,20"));
		assertEquals(0,ob.add(",2"));
		assertEquals(0,ob.add("20,"));
		assertEquals(0,ob.add(","));
	}
	
	@Test
	public void task_3_doubleDelimiter()
	{
		System.out.println("\nTest-2\n");
		assertEquals(0,ob.add("\n"));
		assertEquals(0,ob.add(","));
		assertEquals(0,ob.add("\n2"));
		assertEquals(0,ob.add("2\n"));
		assertEquals(3,ob.add("1\n2"));
		assertEquals(6,ob.add("1\n2,3"));
		assertEquals(31,ob.add("1,2\n3,4,5,6\n10"));
		
	}
}