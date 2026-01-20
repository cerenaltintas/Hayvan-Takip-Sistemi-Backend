package tr.edu.gumushane.hayvantakip.dao;

import java.util.List;
import tr.edu.gumushane.hayvantakip.entity.Mama;

public interface MamaDAO {
    List<Mama> findAll();
    Mama findById(int id);
    Mama save(Mama mama);
    void deleteById(int id);
}