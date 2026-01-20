package tr.edu.gumushane.hayvantakip.dao;

import java.util.List;
import tr.edu.gumushane.hayvantakip.entity.Ilac;

public interface IlacDAO {
    List<Ilac> findAll();
    Ilac findById(int id);
    Ilac save(Ilac ilac);
    void deleteById(int id);
}