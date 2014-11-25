package org.jbpm.demo.rewards.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExttraUtlis {
	private static DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	public static Date formateDate(String date){
		
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Date();
	}
	public static String dateToString(Date date){
		return sdf.format(date);
}
}
