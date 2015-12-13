package com.techvalueinsight.rest.client;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.techvalueinsight.rest.model.Course;
import com.techvalueinsight.util.AppsConstants;
import com.techvalueinsight.util.AppsProperties;

public class TechCoursesRestClientTest {
	private static String baseUrl;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// REST test Base Url. Same as main for now.
		baseUrl = AppsProperties.getProperty(AppsConstants.DRUPAL_TECH_COURSES_REST_BASEURL);
	}

	@Test
	public void testGetAllCourses_ValidInput_returnCourseList() {
		TechCoursesRestClient myTechCoursesRestClient = new TechCoursesRestClient(baseUrl);
		List<Course> coursesList = myTechCoursesRestClient.getAllCourses();

		assertNotNull("coursesList must not be null", coursesList);
		assertFalse("coursesList must not be empty", coursesList.isEmpty());
	}

	@Test(expected = RuntimeException.class)
	public void testGetAllCourses_WrongPath_returnCourseList() {
		TechCoursesRestClient myTechCoursesRestClient = new TechCoursesRestClient(
				"http://dev-my-tech-courses.pantheon.io/wrongpath");
		List<Course> coursesList = myTechCoursesRestClient.getAllCourses();
	}
}
