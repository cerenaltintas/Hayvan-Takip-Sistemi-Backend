package tr.edu.gumushane.hayvantakip.dao;

import java.util.List;
import tr.edu.gumushane.hayvantakip.entity.Veteriner;

public interface VeterinerDAO {
    List<Veteriner> findAll();
    Veteriner findById(int id);
    Veteriner save(Veteriner veteriner);
    void deleteById(int id);
}