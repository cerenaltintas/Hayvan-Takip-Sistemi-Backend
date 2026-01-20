package tr.edu.gumushane.hayvantakip.dao;

import java.util.List;
import tr.edu.gumushane.hayvantakip.entity.SaglikKarti;

public interface SaglikKartiDAO {
    SaglikKarti findById(int id);

    SaglikKarti findByAnimalId(int animalId);

    List<SaglikKarti> findAll();

    SaglikKarti save(SaglikKarti saglikKarti);

    void deleteById(int id);
}
