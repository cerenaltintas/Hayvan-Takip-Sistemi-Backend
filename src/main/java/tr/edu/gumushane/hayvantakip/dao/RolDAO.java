package tr.edu.gumushane.hayvantakip.dao;

import java.util.List;
import tr.edu.gumushane.hayvantakip.entity.Rol;

public interface RolDAO {
    Rol findById(int id);

    Rol findByRolAdi(String rolAdi);

    List<Rol> findAll();

    Rol save(Rol rol);

    void deleteById(int id);
}
