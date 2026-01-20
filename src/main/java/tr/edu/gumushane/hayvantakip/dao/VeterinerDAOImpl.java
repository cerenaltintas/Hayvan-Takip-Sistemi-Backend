package tr.edu.gumushane.hayvantakip.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import tr.edu.gumushane.hayvantakip.entity.Veteriner;

@Repository
public class VeterinerDAOImpl implements VeterinerDAO {

    private EntityManager entityManager;

    @Autowired
    public VeterinerDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Veteriner> findAll() {
        TypedQuery<Veteriner> query = entityManager.createQuery("FROM Veteriner", Veteriner.class);
        return query.getResultList();
    }

    @Override
    public Veteriner findById(int id) {
        return entityManager.find(Veteriner.class, id);
    }

    @Override
    public Veteriner save(Veteriner veteriner) {
        Veteriner dbVeteriner = entityManager.merge(veteriner);
        return dbVeteriner;
    }

    @Override
    public void deleteById(int id) {
        Veteriner veteriner = findById(id);
        if (veteriner != null) {
            entityManager.remove(veteriner);
        }
    }
}