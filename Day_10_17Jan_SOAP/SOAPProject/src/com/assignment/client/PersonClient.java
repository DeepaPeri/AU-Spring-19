package com.assignment.client;

import java.net.URL;


import javax.xml.namespace.QName;

import javax.xml.ws.Service;

import com.assignment.jaxws.service.*;
import com.assignment.jaxws.beans.*;

public class PersonClient{

	public static void main(String[] args) throws Exception {

	URL url = new URL("http://localhost:9998/ws/person?wsdl");
//com.assignment.jaxws.service	

        //1st argument service URI, refer to wsdl document above

	    //2nd argument is service name, refer to wsdl document above

        QName qname = new QName("http://service.jaxws.assignment.com/", "PersonServiceImplService");

        Service service = Service.create(url, qname);

        PersonService personService = service.getPort(PersonService.class);

        Person p = new Person();
        p.setName("deepa");
        p.setId(1);
        p.setAge(22);
        
        personService.addPerson(p);
        
        Person p1 = new Person();
        p1.setName("Akhila");
        p1.setId(2);
        p1.setAge(21);
        personService.addPerson(p1);
        
        System.out.println(personService.getAllPersons());
       
        Person[] array = personService.getAllPersons();
        for(int i = 0; i < array.length; i++) {
        	System.out.println(array[i]);
        }     
        
    }

}