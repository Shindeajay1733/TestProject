package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass3 {
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("before Test TestClass3");	
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("before Class TestClass3");	
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before Method TestClass3");	
	}
	@Test  
	public void testX() {
		System.out.println("test X TestClass3");
	}
	@Test
	public void testY() {
		System.out.println("test Y TestClass3");
		
	}
	@Test 
	public void testZ() {
		System.out.println("test Z TestClass3");	
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("after Method TestClass3");	
	}
	@AfterClass
	public void afterClass() {
		System.out.println("after Class TestClass3");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("after Test TestClass3");	
	}

}
