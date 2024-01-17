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
        Query<UserDetails> query = session.createQuery("from UserDetails", UserDetails.class);
        query.setFirstResult(3);
        query.setMaxResults(2);
        List<UserDetails> users = query.list();
        session.getTransaction().commit();
        session.close();

        for(UserDetails efl:users){
            System.out.println(efl.getUserName());
        }
    }
}