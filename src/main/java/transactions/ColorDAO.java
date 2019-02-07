package transactions;

import javax.ejb.*;
import javax.persistence.*;
import javax.xml.rpc.ServiceException;
import java.util.List;

@Stateless
public class ColorDAO {

    @PersistenceContext(unitName = "TestPersistence")
    EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void simpleMerge_requiresNew(Colour entity) {
        em.persist(entity);
        em.flush();

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void simpleMerge_required(Colour entity) {
        em.persist(entity);
        em.flush();

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void throwsException_required() {
        throw new RuntimeException();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void throwsException_notSupported() throws ServiceException {
        throw new RuntimeException();
    }

    @TransactionAttribute(TransactionAttributeType.NEVER)
    public void simpleMerge_never(Colour entity) {
        em.persist(entity);
        em.flush();

    }

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void simpleMerge_mandatory(Colour entity) {
        em.persist(entity);
        em.flush();

    }


    public List<Colour> findAll() {
        TypedQuery<Colour> query = em.createQuery("select t from " + Colour.class.getName() + " t", Colour.class);
        return query.getResultList();
    }
}
