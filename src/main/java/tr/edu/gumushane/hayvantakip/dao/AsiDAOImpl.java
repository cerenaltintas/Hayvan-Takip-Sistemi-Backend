package tr.edu.gumushane.hayvantakip.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import tr.edu.gumushane.hayvantakip.entity.Asi;

@Repository
public class AsiDAOImpl implements AsiDAO {

    private EntityManager entityManager;

    @Autowired
    public AsiDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Asi> findAll() {
        TypedQuery<Asi> query = entityManager.createQuery("FROM Asi", Asi.class);
        return query.getResultList();
    }

    @Override
    public Asi findById(int id) {
        return entityManager.find(Asi.class, id);
    }

    @Override
    public Asi save(Asi asi) {
        Asi dbAsi = entityManager.merge(asi);
        return dbAsi;
    }

    @Override
    public void deleteById(int id) {
        Asi asi = findById(id);
        if (asi != null) {
            entityManager.remove(asi);
        }
    }
}