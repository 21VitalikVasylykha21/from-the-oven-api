package com.from.the.oven.api.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Vitalii Vasylykha
 * @company UzhNU
 * @since 2023/05/18
 */
public class DateHelper {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	public static String formatDate(Timestamp sqlTimestamp) {
		Date date = new Date(sqlTimestamp.getTime());
		return DATE_FORMAT.format(date);
	}

	public static Timestamp nowTimestamp() {
		return Timestamp.valueOf(LocalDateTime.now());
	}
}