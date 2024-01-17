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
        //use newer method hibernate 6+ instead deprecated method
        SelectionQuery<UserDetails> query = session.createNamedQuery("UserDetails.byId",UserDetails.class);
        query.setParameter(1, Integer.parseInt(txtBoxId));
        List<UserDetails> users = query.list();
        session.getTransaction().commit();
        session.close();

        for(UserDetails efl:users){
            System.out.println(efl.getUserName());
        }
    }
}