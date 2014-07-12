package br.com.helpcar.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {
	
	
	public static Calendar stringCalendar(String data){
		Calendar calendar = null;
		try{
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			calendar= Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		}catch (Exception e) {
			System.out.println("Erro ao converter a data");
			
		}
		return calendar;
	}

	public static String calendarString(Calendar calendar){
	    SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");  
	    return  s.format(calendar.getTime());  
	}

}
