package com.groupkt.utility;

import java.util.Random;

import com.groupkt.base.TestBase;

public class RandomNumber extends TestBase {
	
	// Generate random integers in range 0 to 999 
		public static int generateRandomNumber()
		{
			Random rand = new Random(); 
			int value ;
	        return value = rand.nextInt(1000); 
	       
		}

}
