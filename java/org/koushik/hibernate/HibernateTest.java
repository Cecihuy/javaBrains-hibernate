package org.koushik.hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.UserDetails;

public class HibernateTest {
    public static void main(String[] args) {
        UserDetails userDetails = new UserDetails();
        userDetails.setUserId(2);
        userDetails.setUserName("Second User");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(userDetails);
        session.getTransaction().commit();
    }
}
