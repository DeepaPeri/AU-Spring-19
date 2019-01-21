package com.accolite.hibernate.hibernate1;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.accolite.hibernate.hibernate2.Person;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        long start = System.nanoTime();
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry  = new ServiceRegistryBuilder()
        		.applySettings(configuration.getProperties()).buildServiceRegistry();
        		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        long end = System.nanoTime();
        System.out.println("Time: " + (end - start));
       
        Person p = new Person();
        p.setName("accolite");
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        session.save(p);
        
       // Person p2 = (Person)session.get(Person.class, 1);
        session.getTransaction().commit();
        session.close();
       // System.out.println(p2.toString());
    }
}
