package transactions;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class ColorDAO {

    private static final String PERSISTENCE_UNIT_NAME = "TestPersistence";
    private static final EntityManagerFactory emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    // This Method Is Used To Retrieve The 'EntityManager' Object

    public static EntityManager em = emFactoryObj.createEntityManager();

    public Colour simpleMerge(Colour entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }

    public List<Colour> findAll() {
        TypedQuery<Colour> query = em.createQuery("select t from " + Colour.class.getName() + " t", Colour.class);
        return query.getResultList();
    }
}
