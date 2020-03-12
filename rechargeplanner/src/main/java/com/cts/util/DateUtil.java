package com.cts.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date convertToDate(String date) {
		Date d=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			d=sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
}
