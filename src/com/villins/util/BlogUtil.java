package com.villins.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.corba.se.spi.orb.StringPair;

public class BlogUtil {
	public static Date parseDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d;
			date = sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	public static void main(String[] args){
		String str = "2002-10-8 15:30:22"; 
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = null;
//		date = java.sql.Date.valueOf(str);
//		System.out.println(sdf.format(date));
		System.out.println(str.split(" ")[0]);
	}
}
