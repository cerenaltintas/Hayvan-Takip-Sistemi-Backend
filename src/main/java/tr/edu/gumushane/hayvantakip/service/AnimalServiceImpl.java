package tr.edu.gumushane.hayvantakip.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.edu.gumushane.hayvantakip.dao.AnimalDAO;
import tr.edu.gumushane.hayvantakip.entity.Animal;
<<<<<<< HEAD
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service 
=======

@Service // Rubric Item
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
public class AnimalServiceImpl implements AnimalService {

    private AnimalDAO animalDAO;

    @Autowired
    public AnimalServiceImpl(AnimalDAO animalDAO) {
        this.animalDAO = animalDAO;
    }
<<<<<<< HEAD
    
    @PostConstruct
    public void beanBaslatildiginda() {
        System.out.println(">>> AnimalServiceImpl bean'i oluşturuldu. (PostConstruct)");
    }

    @PreDestroy
    public void beanYokEdilmedenOnce() {
        System.out.println(">>> AnimalServiceImpl bean'i yok ediliyor. (PreDestroy)");
    }
=======
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a

    @Override
    public List<Animal> findAll() {
        return animalDAO.findAll();
    }

    @Override
    public Animal findById(int id) {
        return animalDAO.findById(id);
    }

<<<<<<< HEAD
=======
    // Rubric Item: @Transactional. Veritabanını değiştiren işlemlere eklenir.
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    @Transactional 
    @Override
    public Animal save(Animal animal) {
        return animalDAO.save(animal);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        animalDAO.deleteById(id);
    }
    
    @Override
    public List<Animal> findByTur(String tur) {
        return animalDAO.findByTur(tur);
    }
<<<<<<< HEAD
    @PostConstruct
    public void initMetodu() {
        System.out.println(">>> AnimalServiceImpl Bean'i başarıyla oluşturuldu.");
    }

    @PreDestroy
    public void cleanupMetodu() {
        System.out.println(">>> AnimalServiceImpl Bean'i yok ediliyor...");
    }
=======
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
}