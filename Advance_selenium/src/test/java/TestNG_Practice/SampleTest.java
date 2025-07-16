package TestNG_Practice;

import org.testng.annotations.Test;

public class SampleTest {
	
	@Test(invocationCount = 8)
	public void createproduct() {
		System.out.println("Product is created");
	}
	
	@Test(dependsOnMethods = "createproduct")
	public void modifyproduct() {
		
		System.out.println(" product is modified");
	}
	
	@Test( dependsOnMethods = {"createproduct","modifyproduct"}) // this will show 1pass1skip1fail
	public void deleteproduct() {
		System.out.println("product is deleted");
	}
	

}
