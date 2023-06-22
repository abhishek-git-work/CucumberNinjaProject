package utils;

import java.util.Date;

public class EmailWithTimeStamp {

	public static String emailWithTimeStamp()
	
	{
		Date date = new Date();
		return "abhi"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}
	
}
