package org.order.cloud.util;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static final String DATE_PATTERN = "dd-MM-yyyy";
	public static final String TIMESTAMP_PATTERN = "dd-MM-yyyy HH:mm:ss";
	public static final String DB_DATE_PATTERN = "yyyy-MM-dd";
	public static final String DB_TIMESTAMP_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String TIME_PATTERN_24_HOUR = "HH:mm:ss";
	public static final String TIME_PATTERN_12_HOUR = "hh:mm aa";

	public static String format(Date date, String format) {
		try {
			return new SimpleDateFormat(format).format(date);
		} catch (Exception e) {
		}
		return null;
	}

	public static Date parse(String date, String format) {
		try {
			return new SimpleDateFormat(format).parse(date);
		} catch (Exception e) {
		}
		return null;
	}

	public static String formatTime(LocalTime time, String format) {
		try {
			return time.format(DateTimeFormatter.ofPattern(format));
		} catch (Exception e) {
		}
		return null;
	}

	public static LocalTime parseTime(String time, String format) {
		try {
			return LocalTime.parse(time, DateTimeFormatter.ofPattern(format));
		} catch (Exception e) {
		}
		return null;
	}

	public static Date convertFromSqlToUtil(java.sql.Date date) {
		return new Date(date.getTime());
	}

	public static java.sql.Date convertFromUtilToSql(Date date) {
		return new java.sql.Date(date.getTime());
	}

	public static java.sql.Date getSqlDate() {
		java.sql.Date date = new java.sql.Date(new Date().getTime());
		return date;
	}

	public static Date modifyTime(Date date, int hours, int minutes, int seconds) {
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, hours);
		cal.set(Calendar.MINUTE, minutes);
		cal.set(Calendar.SECOND, seconds);
		return cal.getTime();
	}

	public static Date modifyDate(Date date, int years, int months, int days) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.YEAR, years);
			cal.add(Calendar.MONTH, months);
			cal.add(Calendar.DATE, days);
			return cal.getTime();
		} catch (Exception e) {
		}
		return null;
	}

	public static String getTimeDiff(Date start, Date end) {
		long diff = end.getTime() - start.getTime();
		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);
		StringBuilder sb = new StringBuilder();
		if (diffDays > 0) {
			sb.append(String.valueOf(diffDays)).append("d ");
		}
		if (diffHours > 0) {
			sb.append(String.valueOf(diffHours)).append("h ");
		}
		if (diffMinutes > 0) {
			sb.append(String.valueOf(diffMinutes)).append("m ");
		}
		sb.append(String.valueOf(diffSeconds)).append("s ");
		return sb.toString();
	}

	public static String getTime(long milliseconds) {
		if (milliseconds <= 0l) {
			return "0 s";
		}
		long diffSeconds = milliseconds / 1000 % 60;
		long diffMinutes = milliseconds / (60 * 1000) % 60;
		long diffHours = milliseconds / (60 * 60 * 1000) % 24;
		long diffDays = milliseconds / (24 * 60 * 60 * 1000);
		StringBuilder sb = new StringBuilder();
		if (diffDays > 0) {
			sb.append(String.valueOf(diffDays)).append("d ");
		}
		if (diffHours > 0) {
			sb.append(String.valueOf(diffHours)).append("h ");
		}
		if (diffMinutes > 0) {
			sb.append(String.valueOf(diffMinutes)).append("m ");
		}
		sb.append(String.valueOf(diffSeconds)).append("s ");
		return sb.toString();
	}

}
