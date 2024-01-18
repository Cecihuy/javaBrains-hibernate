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
        CriteriaQuery<Integer> criteriaQuery = criteriaBuilder.createQuery(Integer.class);
        Root<UserDetails> root = criteriaQuery.from(UserDetails.class);
        CriteriaQuery<Integer> queryLogic = criteriaQuery.select(root.get("userId"));

        TypedQuery<Integer> typedQuery = em.createQuery(queryLogic);
        List<Integer> details = typedQuery.getResultList();

        em.getTransaction().commit();
        em.close();

        for(Integer efl:details){
            System.out.println(efl);
        }
    }
}