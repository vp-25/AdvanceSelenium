import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class insertdataintodatabase {

	public static void main(String[] args) throws Throwable 
	{
		//step1: register/load my sql database
		
		Driver driveref = new Driver();
		DriverManager.registerDriver(driveref);
	
		//step2: get the connect of database //database name
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "Vtiger@123");
		
		//step3: create SQL statement
		Statement state = conn.createStatement();
		String query = "insert into studentdata(regno,firstname,lastname,address)values(4,'ram','sita','ayodhya')";
		int result = state.executeUpdate(query);
		if(result ==1) {
			System.out.println("data is created");
		}
		else {
			System.out.println("daya is not created");
		}
		conn.close();
	}

}
