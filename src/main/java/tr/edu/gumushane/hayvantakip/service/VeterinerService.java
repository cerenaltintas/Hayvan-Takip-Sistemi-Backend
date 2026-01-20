package tr.edu.gumushane.hayvantakip.service;

import java.util.List;
import tr.edu.gumushane.hayvantakip.entity.Veteriner;

public interface VeterinerService {
    List<Veteriner> findAll();
    Veteriner findById(int id);
    Veteriner save(Veteriner veteriner);
    void deleteById(int id);
}