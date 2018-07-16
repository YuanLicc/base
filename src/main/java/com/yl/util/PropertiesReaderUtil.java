package com.yl.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReaderUtil {
	
	/**单例*/
	@SuppressWarnings("unused")
	private static PropertiesReaderUtil propertiesReaderUtil = new PropertiesReaderUtil();
	
	/**classRootPath*/
	private static String classpath = PropertiesReaderUtil.class.getResource("/").getPath();
	
	private PropertiesReaderUtil(){}
	
	/**读取properties @param filePath:相对路径*/
	public synchronized static Properties getProperties(String filePath) {
		Properties properties = new Properties();
		try{
			String path = classpath + "/" + filePath;
			InputStream inputStream = new BufferedInputStream(new FileInputStream(path));
			properties.load(inputStream);
			inputStream.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return properties;
	}
	
	public synchronized static Properties getPropertiesByAbsolutePath(String absolutePath) {
		Properties properties = new Properties();
		try{
			InputStream inputStream = new BufferedInputStream(new FileInputStream(absolutePath));
			properties.load(inputStream);
			inputStream.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return properties;
	}
	
	/**获取value*/
	public static String getProperty(String filePath,String key) {
		return getProperties(filePath).getProperty(key);
	}
	
}
