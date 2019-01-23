package com.assignment.jaxws.beans;

import javax.xml.ws.Endpoint;
import com.assignment.jaxws.service.PersonServiceImpl;

public class PersonPublisher {
		public static void main(String[] args) {
			 Endpoint.publish("http://localhost:9998/ws/person", new PersonServiceImpl());

		}
}
