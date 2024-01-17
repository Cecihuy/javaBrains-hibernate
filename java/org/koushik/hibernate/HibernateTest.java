package org.koushik.hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.UserDetails;

public class HibernateTest {
    public static void main(String[] args) {        

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        UserDetails userDetails= session.get(UserDetails.class, 5);
        userDetails.setUserName("Updated User");
        session.merge(userDetails);
        session.getTransaction().commit();

        session.close();
    }
}