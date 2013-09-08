package order.hq.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 *  date util
 *  autor:rogr
 */
public class DateUtil{

	//默认的日期格式(年-月-日)
	private final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	
	//默认的日期编号(年-月-日)
	private final static String DEFAULT_DATE_NUMBER = "yyyyMMdd";

	//默认的日期时间格式(年-月-日 时:分:秒)
	private final static String DEFAULT_TIME_FORMAT = DEFAULT_DATE_FORMAT + " HH:mm:ss";

	//默认的日期星期格式(年-月-日 星期)
	private final static String DEFAULT_DATEANDWEEK_FORMAT = "yyyy-MM-dd EEEE";
	
	private final static DateFormat dfDate = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
	
	private final static DateFormat dfDateNumber = new SimpleDateFormat(DEFAULT_DATE_NUMBER);
	
	private final static DateFormat dfDateTime = new SimpleDateFormat(DEFAULT_TIME_FORMAT);
	
	private final static DateFormat dfDateAndWeek = 
			new SimpleDateFormat(DEFAULT_DATEANDWEEK_FORMAT,Locale.CHINA);

	/**
	 * 返回当前日期
	 */
	public static String getDate(){
		return dfDate.format(new Date());
	}
	
	/**
	 * 返回当前日期编号
	 * @return
	 */
	public static String getDateNumber() {
		return dfDateNumber.format(new Date()); 
	}
	
	/**
	 * @return format: yyyy-MM-dd
	 */
	public static String getDate(Date date){
		return dfDate.format(date);
	}
	
	/**
	 * @return get now time format: yyyy-MM-dd HH:mm:ss
	 */
	public static String getTime(){
		return dfDateTime.format(new Date());
	}
	
	/**
	 * @return format: yyyy-MM-dd HH:mm:ss
	 */
	public static String getTime(Date date){
		return dfDateTime.format(date);
	}
	
	/**
	 * @return get now time format: yyyy-MM-dd 星期一
	 */
	public static String getDateAndWeek(){
		Date date = new Date();
		return dfDateAndWeek.format(date);
	}

	
	public static void main(String[] args) {
		System.out.println("getDate():"+getDateAndWeek());
	}


}
