package org.koushik.hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.UserDetails;

public class HibernateTest {
    public static void main(String[] args) {        

        UserDetails userDetails = new UserDetails();
        userDetails.setUserName("Test User");   //transient

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();        
        session.persist(userDetails);
        userDetails.setUserName("Updated User again");
        userDetails.setUserName("Last Updated User");   //persist
        session.getTransaction().commit();
        userDetails.setUserName("Detach object can't be save after session close"); //detach

        session.close();
    }
}