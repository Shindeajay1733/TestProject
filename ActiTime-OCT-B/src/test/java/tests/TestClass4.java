package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass4 {
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("before Test TestClass4");	
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("before Class TestClass4");	
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before Method TestClass4");	
	}
	@Test  
	public void testA() {
		System.out.println("test A TestClass4");
	}
	@Test
	public void testB() {
		System.out.println("test B TestClass4");
		
	}
	@Test 
	public void testC() {
		System.out.println("test C TestClass4");	
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("after Method TestClass4");	
	}
	@AfterClass
	public void afterClass() {
		System.out.println("after Class TestClass4");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("after Test TestClass4");	
	}
}
