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
        UserDetails userDetails = session.get(UserDetails.class, 1);
        session.getTransaction().commit();
        session.close();

        userDetails.setUserName("Detached object become persist again");

        session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(userDetails);
        userDetails.setUserName("set after merge doesnt track last change, i don't know why. with update method it can track last change");
        session.getTransaction().commit();
        session.close();
    }
}