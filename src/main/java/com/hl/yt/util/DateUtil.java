package com.hl.yt.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String dateToString(Date time) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(time);
	}
}
