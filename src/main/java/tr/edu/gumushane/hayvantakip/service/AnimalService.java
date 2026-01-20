package tr.edu.gumushane.hayvantakip.service;

import java.util.List;
import tr.edu.gumushane.hayvantakip.entity.Animal;

<<<<<<< HEAD
=======
// DAO'daki metotlarla aynı, arayüzü koruyoruz
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
public interface AnimalService {
    List<Animal> findAll();
    Animal findById(int id);
    Animal save(Animal animal);
    void deleteById(int id);
    List<Animal> findByTur(String tur);
}