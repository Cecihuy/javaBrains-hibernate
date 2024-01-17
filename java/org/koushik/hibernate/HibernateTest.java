package org.koushik.hibernate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.javabrains.koushik.dto.UserDetails;

public class HibernateTest {
    public static void main(String[] args) {        

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        // Query<UserDetails> query = session.createQuery("from UserDetails", UserDetails.class);
        Query<UserDetails> query2 = session.createQuery("from UserDetails where userId > 5", UserDetails.class);
        List<UserDetails> users = query2.list();
        session.getTransaction().commit();
        session.close();

        System.out.println("Size of list result = " + users.size());
        System.out.println("Get username by index from result of query2 = " + users.get(1).getUserName());        
    }
}