package tr.edu.gumushane.hayvantakip.service;

import java.util.List;
import tr.edu.gumushane.hayvantakip.entity.Rol;

public interface RolService {

    List<Rol> findAll();

    Rol findById(int id);

    Rol findByRolAdi(String rolAdi);

    Rol save(Rol rol);

    void deleteById(int id);
}
