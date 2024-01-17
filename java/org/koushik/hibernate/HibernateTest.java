package org.koushik.hibernate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.SelectionQuery;
import org.javabrains.koushik.dto.UserDetails;

public class HibernateTest {
    public static void main(String[] args) {        

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        String txtBoxId = "3";
        String txtBoxName = "user 5";
        //use newer method hibernate 6+ instead deprecated method
        SelectionQuery<UserDetails> query = session.createSelectionQuery("from UserDetails where userId > :pertama and userName = :kedua", UserDetails.class);
        query.setParameter("pertama", Integer.parseInt(txtBoxId));
        query.setParameter("kedua", txtBoxName);
        List<UserDetails> users = query.list();
        session.getTransaction().commit();
        session.close();

        for(UserDetails efl:users){
            System.out.println(efl.getUserName());
        }
    }
}