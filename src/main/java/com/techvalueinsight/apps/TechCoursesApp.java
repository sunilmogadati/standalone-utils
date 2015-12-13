package com.techvalueinsight.apps;

import java.util.List;

import com.techvalueinsight.rest.client.TechCoursesRestClient;
import com.techvalueinsight.rest.model.Course;
import com.techvalueinsight.util.AppsConstants;
import com.techvalueinsight.util.AppsProperties;

/**
 * 
 * Class with main method to make rest client calls
 *
 */
public class TechCoursesApp 
{
	
	/**
	 * The main method that creates and calls REST Client
	 * @param args
	 */
    public static void main( String[] args )
    {   
    	// Get the REST Bas Url from properties file
        String myTechCoursesbaseUrl = AppsProperties.getProperty(AppsConstants.DRUPAL_TECH_COURSES_REST_BASEURL);
        System.out.println( "REST endpoint base url = " + myTechCoursesbaseUrl);
        
        // Create rest client using the base url endpoint
        TechCoursesRestClient myTechCoursesRestClient = new TechCoursesRestClient(myTechCoursesbaseUrl);
        
        // Get all courses by making REST client call 
        List<Course> coursesList = myTechCoursesRestClient.getAllCourses();
		System.out.println(coursesList);
    }
}
