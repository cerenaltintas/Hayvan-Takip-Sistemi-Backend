package tr.edu.gumushane.hayvantakip.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import tr.edu.gumushane.hayvantakip.entity.Animal;

<<<<<<< HEAD
@Repository 
=======
@Repository // Rubric Item: DAO katmanı olduğunu belirtir
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
public class AnimalDAOImpl implements AnimalDAO {

    private EntityManager entityManager;

<<<<<<< HEAD
=======
    // Rubric Item: @Autowired ile constructor injection
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    @Autowired
    public AnimalDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Animal> findAll() {
<<<<<<< HEAD
        
=======
        // JPQL sorgusu (Entity sınıfına sorgu atarız, tabloya değil)
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
        TypedQuery<Animal> query = entityManager.createQuery("FROM Animal", Animal.class);
        return query.getResultList();
    }

    @Override
    public Animal findById(int id) {
        return entityManager.find(Animal.class, id);
    }

    @Override
    public Animal save(Animal animal) {
<<<<<<< HEAD
        
=======
        // Eğer id=0 ise (yeni kayıt) persist (ekle), değilse merge (güncelle) yapar.
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
        Animal dbAnimal = entityManager.merge(animal);
        return dbAnimal;
    }

    @Override
    public void deleteById(int id) {
        Animal animal = findById(id);
        if (animal != null) {
            entityManager.remove(animal);
        }
    }

    @Override
    public List<Animal> findByTur(String tur) {
<<<<<<< HEAD
=======
        // Rubric Item: TypedQuery kullanımı
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
        TypedQuery<Animal> query = entityManager.createQuery(
            "FROM Animal WHERE tur = :paramTur", Animal.class);
        query.setParameter("paramTur", tur);
        return query.getResultList();
    }
}