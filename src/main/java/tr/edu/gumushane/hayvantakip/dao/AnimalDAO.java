package tr.edu.gumushane.hayvantakip.dao;

import java.util.List;
import tr.edu.gumushane.hayvantakip.entity.Animal;

public interface AnimalDAO {
    
    List<Animal> findAll();
    
    Animal findById(int id);
    
<<<<<<< HEAD
    Animal save(Animal animal); 
    
    void deleteById(int id);

=======
    Animal save(Animal animal); // Hem ekleme hem güncelleme
    
    void deleteById(int id);
    
    // Rubric Item: TypedQuery kullanımı için örnek bir metot
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    List<Animal> findByTur(String tur); 
}