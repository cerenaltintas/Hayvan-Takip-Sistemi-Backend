package tr.edu.gumushane.hayvantakip.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD
import jakarta.persistence.EntityManager; 
import jakarta.persistence.TypedQuery; 

import tr.edu.gumushane.hayvantakip.dao.AnimalDAO; 
import tr.edu.gumushane.hayvantakip.dao.MamaDAO;
import tr.edu.gumushane.hayvantakip.entity.Animal; 
import tr.edu.gumushane.hayvantakip.entity.Mama;
import tr.edu.gumushane.hayvantakip.exception.AnimalNotFoundException;
=======
import jakarta.persistence.EntityManager; // Ekstra sorgu için
import jakarta.persistence.TypedQuery; // Ekstra sorgu için

import tr.edu.gumushane.hayvantakip.dao.AnimalDAO; // Animal için
import tr.edu.gumushane.hayvantakip.dao.MamaDAO;
import tr.edu.gumushane.hayvantakip.entity.Animal; // Animal için
import tr.edu.gumushane.hayvantakip.entity.Mama;
import tr.edu.gumushane.hayvantakip.exception.AnimalNotFoundException; // Hata için
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a

@Service
public class MamaServiceImpl implements MamaService {

<<<<<<< HEAD
=======
   // .../service/MamaServiceImpl.java içindeki constructor'ı bununla değiştir:

>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    private MamaDAO mamaDAO;
    private AnimalDAO animalDAO; 
    private EntityManager entityManager; 

    @Autowired
    public MamaServiceImpl(MamaDAO mamaDAO, AnimalDAO animalDAO, EntityManager entityManager) {
    this.mamaDAO = mamaDAO;
    this.animalDAO = animalDAO;
    this.entityManager = entityManager;

    }

    @Override
    public List<Mama> findAll() {
        return mamaDAO.findAll();
    }

    @Override
    public Mama findById(int id) {
        return mamaDAO.findById(id);
    }

    @Transactional
    @Override
    public Mama save(Mama mama) {
<<<<<<< HEAD
=======
        // Bu kısım biraz karmaşık: Bir 'mama'yı 'animal'a bağlamak için.
        // Postman'den 'animalId'si 0 olan bir 'mama' gelirse hata alırız.
        // Controller katmanında 'animalId'yi alıp 'mama'ya set etmek daha iyi bir yöntemdir.
        // Şimdilik DAO'daki basit 'merge'e güveniyoruz.
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
        return mamaDAO.save(mama);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        mamaDAO.deleteById(id);
    }

<<<<<<< HEAD
    @Override
    public List<Mama> findByAnimalId(int animalId) {
        
=======
    // Özel sorgu: EntityManager kullanarak
    @Override
    public List<Mama> findByAnimalId(int animalId) {
        // Önce hayvan var mı kontrol et
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
        Animal animal = animalDAO.findById(animalId);
        if (animal == null) {
            throw new AnimalNotFoundException("Animal id not found - " + animalId);
        }

<<<<<<< HEAD
=======
        // JPQL sorgusu (Mama entity'sindeki 'animal' alanının 'id'sine göre)
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
        TypedQuery<Mama> query = entityManager.createQuery(
            "FROM Mama WHERE animal.id = :animalId", Mama.class);
        query.setParameter("animalId", animalId);
        return query.getResultList();
    }
}