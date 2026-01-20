package tr.edu.gumushane.hayvantakip.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import tr.edu.gumushane.hayvantakip.entity.Ilac;

@Repository
public class IlacDAOImpl implements IlacDAO {

    private EntityManager entityManager;

    @Autowired
    public IlacDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Ilac> findAll() {
        TypedQuery<Ilac> query = entityManager.createQuery("FROM Ilac", Ilac.class);
        return query.getResultList();
    }

    @Override
    public Ilac findById(int id) {
        return entityManager.find(Ilac.class, id);
    }

    @Override
    public Ilac save(Ilac ilac) {
        Ilac dbIlac = entityManager.merge(ilac);
        return dbIlac;
    }

    @Override
    public void deleteById(int id) {
        Ilac ilac = findById(id);
        if (ilac != null) {
            entityManager.remove(ilac);
        }
    }
}