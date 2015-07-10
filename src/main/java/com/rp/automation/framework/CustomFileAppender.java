package com.rp.automation.framework;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.FileAppender;

/**
 * CustomFileAppender class, implements appender for log4j
 * 
 * @author sveerapaneni Date :08/21/14
 */
public class CustomFileAppender extends FileAppender {

	/**
	 * setFile method,
	 */
	@Override
	public void setFile(String fileName) {
		if (fileName.indexOf("%timestamp") >= 0) {
			Date d = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			fileName = fileName.replaceAll("%timestamp", format.format(d));
		}
		super.setFile(fileName);
	}
}