package tr.edu.gumushane.hayvantakip.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import tr.edu.gumushane.hayvantakip.entity.SaglikKarti;

@Repository
public class SaglikKartiDAOImpl implements SaglikKartiDAO {

    private EntityManager entityManager;

    @Autowired
    public SaglikKartiDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public SaglikKarti findById(int id) {
        return entityManager.find(SaglikKarti.class, id);
    }

    @Override
    public SaglikKarti findByAnimalId(int animalId) {
        TypedQuery<SaglikKarti> query = entityManager.createQuery(
                "SELECT s FROM SaglikKarti s WHERE s.animal.id = :animalId", SaglikKarti.class);
        query.setParameter("animalId", animalId);

        List<SaglikKarti> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public List<SaglikKarti> findAll() {
        TypedQuery<SaglikKarti> query = entityManager.createQuery("FROM SaglikKarti", SaglikKarti.class);
        return query.getResultList();
    }

    @Override
    public SaglikKarti save(SaglikKarti saglikKarti) {
        return entityManager.merge(saglikKarti);
    }

    @Override
    public void deleteById(int id) {
        SaglikKarti saglikKarti = entityManager.find(SaglikKarti.class, id);
        if (saglikKarti != null) {
            entityManager.remove(saglikKarti);
        }
    }
}
