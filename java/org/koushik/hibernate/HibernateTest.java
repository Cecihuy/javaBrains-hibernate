package org.koushik.hibernate;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.UserDetails;

public class HibernateTest {
    public static void main(String[] args) {
        UserDetails userDetails = new UserDetails();
        userDetails.setUserId(1);
        userDetails.setUserName("First User");
        userDetails.setAddress("First User address");
        userDetails.setJoinedDate(new Date());
        userDetails.setDescription("Description of the user goes here");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(userDetails);
        session.getTransaction().commit();
    }
}
