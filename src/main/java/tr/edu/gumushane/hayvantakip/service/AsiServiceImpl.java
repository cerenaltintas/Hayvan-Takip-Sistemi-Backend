package tr.edu.gumushane.hayvantakip.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import tr.edu.gumushane.hayvantakip.dao.AnimalDAO;
import tr.edu.gumushane.hayvantakip.dao.AsiDAO;
import tr.edu.gumushane.hayvantakip.entity.Animal;
import tr.edu.gumushane.hayvantakip.entity.Asi;
import tr.edu.gumushane.hayvantakip.exception.AnimalNotFoundException;

@Service
public class AsiServiceImpl implements AsiService {

    private AsiDAO asiDAO;
    private AnimalDAO animalDAO;
    private EntityManager entityManager;

    @Autowired
    public AsiServiceImpl(AsiDAO asiDAO, AnimalDAO animalDAO, EntityManager entityManager) {
        this.asiDAO = asiDAO;
        this.animalDAO = animalDAO;
        this.entityManager = entityManager;
    }

    @Override
    public List<Asi> findAll() {
        return asiDAO.findAll();
    }

    @Override
    public Asi findById(int id) {
        return asiDAO.findById(id);
    }

    @Transactional
    @Override
    public Asi save(Asi asi) {
        return asiDAO.save(asi);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        asiDAO.deleteById(id);
    }

    @Override
    public List<Asi> findByAnimalId(int animalId) {
        Animal animal = animalDAO.findById(animalId);
        if (animal == null) {
            throw new AnimalNotFoundException("Animal id not found - " + animalId);
        }

        TypedQuery<Asi> query = entityManager.createQuery(
            "FROM Asi WHERE animal.id = :animalId", Asi.class);
        query.setParameter("animalId", animalId);
        return query.getResultList();
    }
}