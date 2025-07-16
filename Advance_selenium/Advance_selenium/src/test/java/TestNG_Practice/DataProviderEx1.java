package TestNG_Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {
	//Invocation count:- Executing same method multiple time with same
	//set of data
	
	//DataProvider:- Executing same method multiple times with
	//different set of data
	
	@Test(dataProvider = "getData")
	
	public void bookTickets(String src, String dest,int count) 
	{
		System.out.println(" Book tickts from " + src + " to " +dest+" count of people " + count);
	}
	@DataProvider
	public Object[][] getData() 
	{
		Object[][] objArr = new Object[3][3]; //to store different data we use  2D array
		objArr[0][0]="Bangalore";
		objArr[0][1]="goa";
		objArr[0][2]=10;
		
		objArr[1][0]="hyderabad";
		objArr[1][1]="hosur";
		objArr[1][2]=50;
		
		objArr[2][0]="pune";
		objArr[2][1]="noida";
		objArr[2][2]=40;
		
		return objArr;
		
	}

}
