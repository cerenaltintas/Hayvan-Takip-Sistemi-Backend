package tr.edu.gumushane.hayvantakip.service;

import java.util.List;
import tr.edu.gumushane.hayvantakip.entity.Mama;

public interface MamaService {
    List<Mama> findAll();
    Mama findById(int id);
    Mama save(Mama mama);
    void deleteById(int id);

<<<<<<< HEAD
=======
    // Bir hayvana ait mamaları getirmek için ekstra metot
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    List<Mama> findByAnimalId(int animalId);
}