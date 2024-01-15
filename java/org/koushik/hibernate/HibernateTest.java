package org.koushik.hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.Address;
import org.javabrains.koushik.dto.UserDetails;

public class HibernateTest {
    public static void main(String[] args) {
        UserDetails userDetails = new UserDetails();
        userDetails.setUserName("First User");        

        Address address = new Address();
        address.setStreet("Street Name");
        address.setCity("City Name");
        
        userDetails.setHomeAddress(address);

        Address address2 = new Address();
        address2.setStreet("Second Street Name");
        address2.setCity("Second City Name");

        userDetails.setOfficeAddress(address2);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(userDetails);
        session.getTransaction().commit();
        session.close();
    }
}