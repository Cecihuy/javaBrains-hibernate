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
        for(int i = 0; i < 10; i++){
            UserDetails userDetails = new UserDetails();
            userDetails.setUserName("User " + i);
            session.persist(userDetails);
        }
        session.getTransaction().commit();

        session.close();
    }
}