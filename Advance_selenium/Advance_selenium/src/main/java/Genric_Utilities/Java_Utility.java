package Genric_Utilities;

import java.util.Random;

public class Java_Utility {
	
	/**
	 * This method is used to avoid duplicate values
	 * 
	 * @return
	 * @author vishnu
	 */
	
	public int getRandomNum() {
		Random ran = new Random();
	    int rannum = ran.nextInt();
	    return rannum;
	}

}
