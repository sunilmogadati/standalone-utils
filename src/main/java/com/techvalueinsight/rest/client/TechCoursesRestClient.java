package com.techvalueinsight.rest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.techvalueinsight.rest.model.Course;

/**
 * 
 * The Client class which will be used to make calls to REST Service
 *
 */
public class TechCoursesRestClient {

	private Client client;
	private String baseUrl;

	/**
	 * Constructor explicitly specifying the endpoint
	 * 
	 * @param baseUrl
	 *            Endpoint of Rest service
	 */
	public TechCoursesRestClient(String baseUrl) {
		if ((baseUrl != null) && (!baseUrl.equals(""))) {
			if (!baseUrl.endsWith("/")) {
				baseUrl += "/";
			}
			this.baseUrl = baseUrl;
		} else {
			throw new RuntimeException("Endpoint URL must be supplied to create TechCoursesRestClient");
		}
		client = ClientBuilder.newClient();
	}

	/**
	 * GET request to get a list of all courses.
	 * 
	 * @return List of Courses
	 */
	public List<Course> getAllCourses() {
		WebTarget target = client.target(baseUrl);
		Response response = target.path("courses/").request(MediaType.APPLICATION_JSON).get(Response.class);
		
		if (response.getStatus() != 200) {
			//System.out.println(response.readEntity(String.class));
			throw new RuntimeException(response.getStatus() + ": Error from Server");
		}

		return response.readEntity(new GenericType<List<Course>>() {});
	}

}
