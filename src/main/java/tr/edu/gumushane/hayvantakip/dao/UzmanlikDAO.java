package tr.edu.gumushane.hayvantakip.dao;

import java.util.List;
import tr.edu.gumushane.hayvantakip.entity.Uzmanlik;

public interface UzmanlikDAO {
    Uzmanlik findById(int id);

    List<Uzmanlik> findAll();

    Uzmanlik save(Uzmanlik uzmanlik);

    void deleteById(int id);
}
