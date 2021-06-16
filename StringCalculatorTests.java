package kata;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;


public class StringCalculatorTests {

	static StringCalculator ob;
	String[] dlist = {"@@","##","**","..","??","++","^^"}; 
	@BeforeClass
	public static void creatObj()
	{
		ob = new StringCalculator();
		
	}
	@Before
	public void emptyList()
	{
		ob.delimiterslist.clear();
	}
	
	
	@Test
	public void delimiters()
	{
		System.out.println("\nTest for delimiters() function\n");
		ob.delimiterslist.clear();
		assertEquals("",ob.delimiters("//"));
		assertTrue(ob.delimiterslist.isEmpty());
		ob.delimiterslist.clear();
		assertEquals("",ob.delimiters("//;\n"));
		assertTrue(ob.delimiterslist.contains(";"));
		ob.delimiterslist.clear();
		assertEquals("1",ob.delimiters("//;\n1"));
		assertTrue(ob.delimiterslist.contains(";"));
		ob.delimiterslist.clear();
		assertEquals("1,2,3",ob.delimiters("1,2,3"));
		assertTrue(ob.delimiterslist.isEmpty());
	}
	
	
	@Test
	public void lengthyDelimiters()
	{
		System.out.println("\nTest for any length delimiters() function\n");
		ob.delimiterslist.clear();
		assertEquals("",ob.delimiters("//[]"));
		assertTrue(ob.delimiterslist.isEmpty());
		ob.delimiterslist.clear();
		assertEquals("",ob.delimiters("//[**]"));
		assertTrue(ob.delimiterslist.contains("**"));
		ob.delimiterslist.clear();
		assertEquals("",ob.delimiters("//[**][$$$][&&&&&&]"));
		assertTrue(ob.delimiterslist.contains("**"));
		assertTrue(ob.delimiterslist.contains("$$$"));
		assertTrue(ob.delimiterslist.contains("&&&&&&"));
		ob.delimiterslist.clear();
		System.out.println("Success");
		assertEquals("**1,2\\n3**4@@@6**&",ob.delimiters("//[**][@@@@]\n**1,2\\n3**4@@@6**&"));
		assertTrue(ob.delimiterslist.contains("**"));
		assertTrue(ob.delimiterslist.contains("@@@@"));
	}
	
	
	@Test
	public void changeDelimiters()
	{
		
		System.out.println("\nTest for any length delimiters() function\n");
		
		ob.delimiterslist.clear();
		ob.delimiterslist.addAll(Arrays.asList(dlist));
		assertEquals("1,2",ob.changeDelimiters("1**2"));
		assertTrue(ob.delimiterslist.isEmpty());
		ob.delimiterslist.addAll(Arrays.asList(dlist));
		assertEquals(",12",ob.changeDelimiters("**12"));
		assertTrue(ob.delimiterslist.isEmpty());
		ob.delimiterslist.addAll(Arrays.asList(dlist));
		assertEquals("12,",ob.changeDelimiters("12**"));
		assertTrue(ob.delimiterslist.isEmpty());
		ob.delimiterslist.addAll(Arrays.asList(dlist));
		assertEquals("1,2,3,4,5,6,7,8",ob.changeDelimiters("1**2@@3..4++5??6^^7##8"));
		assertTrue(ob.delimiterslist.isEmpty());
		ob.delimiterslist.addAll(Arrays.asList(dlist));
		assertEquals("-1,0\n1,*2,3,4,%5,6,7,8",ob.changeDelimiters("-1,0\n1***2@@3..4++%5??6^^7##8"));
		assertTrue(ob.delimiterslist.isEmpty());
		
	}
	
	
	@Test
	public void task_1_2_testAdd()
	{
		System.out.println("\nTest-1&2\n");
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
		System.out.println("\nTest-3\n");
		assertEquals(0,ob.add("\n"));
		assertEquals(0,ob.add(","));
		assertEquals(0,ob.add("\n2"));
		assertEquals(0,ob.add("2\n"));
		assertEquals(3,ob.add("1\n2"));
		assertEquals(6,ob.add("1\n2,3"));
		assertEquals(31,ob.add("1,2\n3,4,5,6\n10"));
		
	}
	
	
	@Test
	public void task_4_differentDelimiters()
	{
		System.out.println("\nTest-4\n");
		assertEquals(0,ob.add("//:1"));
		assertEquals(0,ob.add("//:\n:1"));
		assertEquals(0,ob.add("//:\n1:"));
		assertEquals(3,ob.add("//;\n1;2"));
		assertEquals(21,ob.add("//;\n1;2,3,4\n5\n6"));
		assertEquals(0,ob.add("//;\n1;2-3"));
		
	}
	
	@Test
	public void task_5_negativesNotAllowed()
	{
		System.out.println("\nTest-5\n");
		assertEquals(0,ob.add("-1"));
		assertEquals(0,ob.add("1,2\n-3,4,5,6\n10"));
		assertEquals(0,ob.add("//;\n1;2,-3,4\n5\n6"));
		assertEquals(0,ob.add("-1,-2\n-3,-4,-5,-6"));
		
	}
	@Test
	public void task_6_ignoreGreaterthan1000()
	{
		System.out.println("\nTest-6\n");
		assertEquals(0,ob.add("9999"));
		assertEquals(1002,ob.add("1000,2"));
		assertEquals(2,ob.add("2,1002"));
		assertEquals(21,ob.add("//;\n1;2,,2999;3,4\n5\n6"));
		
	}
	@Test
	public void task_7_lengthyDelimiter()
	{
		System.out.println("\nTest-7\n");
		assertEquals(0,ob.add("//[]\n"));
		assertEquals(1,ob.add("//[]\n1"));
		assertEquals(6,ob.add("//[]\n1,2\n3"));
		assertEquals(0,ob.add("//[]\n,1,2"));
		assertEquals(0,ob.add("//[]\n1,2,3,4,"));
		assertEquals(0,ob.add("//[&&]\n1&&&2,3,4"));
		assertEquals(0,ob.add("//[&&]\n&&1,2,3,4"));
		assertEquals(0,ob.add("//[##]1,2,3,4##\n"));
		assertEquals(21,ob.add("//[]\n1,2\n3\n4,5\n6"));
		assertEquals(21,ob.add("//[**]\n1**2**3,4,5\n6"));
		assertEquals(16,ob.add("//[@@@@@@]\n1@@@@@@2@@@@@@3,4\n6"));
	}
	@Test
	public void task_8_9_multipleDelimiter()
	{
		System.out.println("\nTest-7\n");
		assertEquals(0,ob.add("//[][][]\n"));
		assertEquals(0,ob.add("//[*][&]\n*1,2&3"));
		assertEquals(0,ob.add("//[*][&]\n1,2*3&"));
		assertEquals(0,ob.add("//[**][&&]\n1,2**3&&4\n5--6"));
		assertEquals(15,ob.add("//[*][&]\n1,2*3&4\n5"));
		assertEquals(21,ob.add("//[**][&&]\n1,2**3&&4\n5**6"));
		assertEquals(45,ob.add("//[**][&&][..][???][++]\n1,2**3&&4\n5&&6..7???8++9"));
		
	}
	
	
	@AfterClass
	public static void deleteObj()
	{
		ob=null;
	}
}