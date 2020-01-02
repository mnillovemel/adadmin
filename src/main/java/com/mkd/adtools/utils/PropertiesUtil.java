package com.mkd.adtools.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	public static Properties prop = new Properties();
	static{
		InputStream in = new PropertiesUtil().getClass().getResourceAsStream("/application.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getValue(String key){
		return prop.getProperty(key);
	}
	public static Integer getIntValue(String key){
		return Integer.parseInt(prop.getProperty(key));
	}
	public static Boolean getBoobleanValue(String key){
		return Boolean.parseBoolean(prop.getProperty(key));
	}
}