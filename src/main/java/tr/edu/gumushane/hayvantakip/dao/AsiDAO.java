package tr.edu.gumushane.hayvantakip.dao;

import java.util.List;
import tr.edu.gumushane.hayvantakip.entity.Asi;

public interface AsiDAO {
    List<Asi> findAll();
    Asi findById(int id);
    Asi save(Asi asi);
    void deleteById(int id);
}