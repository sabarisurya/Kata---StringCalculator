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
	public void Task_1_2_testAdd()
	{
		assertEquals(0,ob.add(""));
		assertEquals(32,ob.add("32"));
		assertEquals(3,ob.add("1,2"));
		assertEquals(30,ob.add("10,20"));
		assertEquals(0,ob.add(",2"));
		assertEquals(0,ob.add("20,"));
		assertEquals(0,ob.add(","));
	}
}