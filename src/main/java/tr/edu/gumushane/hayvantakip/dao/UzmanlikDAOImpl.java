package tr.edu.gumushane.hayvantakip.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import tr.edu.gumushane.hayvantakip.entity.Uzmanlik;

@Repository
public class UzmanlikDAOImpl implements UzmanlikDAO {

    private EntityManager entityManager;

    @Autowired
    public UzmanlikDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Uzmanlik findById(int id) {
        return entityManager.find(Uzmanlik.class, id);
    }

    @Override
    public List<Uzmanlik> findAll() {
        TypedQuery<Uzmanlik> query = entityManager.createQuery("FROM Uzmanlik", Uzmanlik.class);
        return query.getResultList();
    }

    @Override
    public Uzmanlik save(Uzmanlik uzmanlik) {
        return entityManager.merge(uzmanlik);
    }

    @Override
    public void deleteById(int id) {
        Uzmanlik uzmanlik = entityManager.find(Uzmanlik.class, id);
        if (uzmanlik != null) {
            entityManager.remove(uzmanlik);
        }
    }
}
