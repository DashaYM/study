package transactions;

import javax.ejb.*;
import javax.persistence.*;
import java.util.List;

@Stateless
public class ColorDAO {

    @PersistenceContext(unitName = "TestPersistence")
    EntityManager em;

    public void simpleMerge(Colour entity) {
        em.persist(entity);
        em.flush();
    }

    public List<Colour> findAll() {
        TypedQuery<Colour> query = em.createQuery("select t from " + Colour.class.getName() + " t", Colour.class);
        return query.getResultList();
    }
}
