package tr.edu.gumushane.hayvantakip.service;

import java.util.List;
import tr.edu.gumushane.hayvantakip.entity.Ilac;

public interface IlacService {
    List<Ilac> findAll();
    Ilac findById(int id);
    Ilac save(Ilac ilac);
    void deleteById(int id);
    List<Ilac> findByAnimalId(int animalId);
}