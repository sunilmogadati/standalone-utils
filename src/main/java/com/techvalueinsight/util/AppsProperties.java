package com.techvalueinsight.util;

import java.net.URL;
import java.util.Properties;

/**
 * 
 * Convenience methods to load and get property values from properties file
 *
 */
public class AppsProperties {
	public static Properties properties;

	/**
	 * 
	 * @param property Name to be fetched from properties file
	 * @return property value from properties file
	 */
	public static String getProperty(String propertyName){
		if(properties == null || properties.isEmpty()){
			properties = loadProperties(AppsConstants.APPS_PROPERTIES_FILE_NAME);
		}
		String propertyValue = getProperty(propertyName, properties);

		return propertyValue;
	}
	
	private static String getProperty(String propertyName, Properties properties){
		String propertyValue = null;

		if(properties != null &&  !properties.isEmpty()){
			if(properties.containsKey(propertyName)){
				propertyValue = properties.getProperty(propertyName);
			}
		}
		return propertyValue;
	}
	
	private static Properties loadProperties(String propertiesFileName){
		Properties properties = new Properties();
		try{
			properties = new Properties();
			URL url = Thread.currentThread().getContextClassLoader().getResource(propertiesFileName);
			properties.load(url.openStream());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return properties;
	}
}
