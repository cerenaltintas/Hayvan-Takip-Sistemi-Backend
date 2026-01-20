package tr.edu.gumushane.hayvantakip.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import tr.edu.gumushane.hayvantakip.dao.AnimalDAO;
import tr.edu.gumushane.hayvantakip.dao.IlacDAO;
import tr.edu.gumushane.hayvantakip.entity.Animal;
import tr.edu.gumushane.hayvantakip.entity.Ilac;
import tr.edu.gumushane.hayvantakip.exception.AnimalNotFoundException;

@Service
public class IlacServiceImpl implements IlacService {

    private IlacDAO ilacDAO;
    private AnimalDAO animalDAO;
    private EntityManager entityManager;

    @Autowired
    public IlacServiceImpl(IlacDAO ilacDAO, AnimalDAO animalDAO, EntityManager entityManager) {
        this.ilacDAO = ilacDAO;
        this.animalDAO = animalDAO;
        this.entityManager = entityManager;
    }

    @Override
    public List<Ilac> findAll() {
        return ilacDAO.findAll();
    }

    @Override
    public Ilac findById(int id) {
        return ilacDAO.findById(id);
    }

    @Transactional
    @Override
    public Ilac save(Ilac ilac) {
        return ilacDAO.save(ilac);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        ilacDAO.deleteById(id);
    }

    @Override
    public List<Ilac> findByAnimalId(int animalId) {
        Animal animal = animalDAO.findById(animalId);
        if (animal == null) {
            throw new AnimalNotFoundException("Animal id not found - " + animalId);
        }

        TypedQuery<Ilac> query = entityManager.createQuery(
            "FROM Ilac WHERE animal.id = :animalId", Ilac.class);
        query.setParameter("animalId", animalId);
        return query.getResultList();
    }
}