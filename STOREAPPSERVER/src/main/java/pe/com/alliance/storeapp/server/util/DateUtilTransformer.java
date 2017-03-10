package pe.com.alliance.storeapp.server.util;

import java.sql.Timestamp;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

public class DateUtilTransformer {

	public static Date transformToDate(Timestamp timestamp){
		return LocalDateTime.fromDateFields(timestamp).toDate();
	}
	
	public static Timestamp transformToTimestamp(Date date){
		return new Timestamp(date.getTime());
	}
	
	public static DateTime transformToDateTime(Timestamp timestamp){
		return new DateTime(timestamp.getTime());
	}
	
	public static DateTime transformToDateTime(Date date){
		return new DateTime(date);
	}
}
