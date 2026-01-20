package tr.edu.gumushane.hayvantakip.service;

import java.util.List;
import tr.edu.gumushane.hayvantakip.entity.Asi;

public interface AsiService {
    List<Asi> findAll();
    Asi findById(int id);
    Asi save(Asi asi);
    void deleteById(int id);
    List<Asi> findByAnimalId(int animalId);
}