package org.koushik.hibernate;
import org.javabrains.koushik.dto.UserDetails;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class HibernateTest {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("siapaBelumMandi");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<UserDetails> criteriaQuery = criteriaBuilder.createQuery(UserDetails.class);
        Root<UserDetails> root = criteriaQuery.from(UserDetails.class);
        
        CriteriaQuery<UserDetails> queryLogic = criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("userName"), "user 3"));

        TypedQuery<UserDetails> typedQuery = em.createQuery(queryLogic);
        List<UserDetails> details = typedQuery.getResultList();
        em.getTransaction().commit();
        em.close();

        for(UserDetails efl:(List<UserDetails>)details){
            System.out.println(efl.getUserId() + " : " + efl.getUserName());
        }
    }
}