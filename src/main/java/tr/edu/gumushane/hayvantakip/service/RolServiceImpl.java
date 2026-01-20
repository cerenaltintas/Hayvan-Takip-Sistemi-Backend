package tr.edu.gumushane.hayvantakip.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.edu.gumushane.hayvantakip.dao.RolDAO;
import tr.edu.gumushane.hayvantakip.dao.UyeDAO;
import tr.edu.gumushane.hayvantakip.entity.Rol;
import tr.edu.gumushane.hayvantakip.entity.Uye;

@Service
public class RolServiceImpl implements RolService {

    private RolDAO rolDAO;
    private UyeDAO uyeDAO;

    @Autowired
    public RolServiceImpl(RolDAO rolDAO, UyeDAO uyeDAO) {
        this.rolDAO = rolDAO;
        this.uyeDAO = uyeDAO;
    }

    @Override
    @Transactional
    public List<Rol> findAll() {
        return rolDAO.findAll();
    }

    @Override
    @Transactional
    public Rol findById(int id) {
        return rolDAO.findById(id);
    }

    @Override
    @Transactional
    public Rol findByRolAdi(String rolAdi) {
        return rolDAO.findByRolAdi(rolAdi);
    }

    @Override
    @Transactional
    public Rol save(Rol rol) {
        return rolDAO.save(rol);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Rol rol = rolDAO.findById(id);
        if (rol != null) {
            List<Uye> uyeler = uyeDAO.findAll();
            for (Uye uye : uyeler) {
                uye.getRoller().remove(rol);
            }
        }
        rolDAO.deleteById(id);
    }
}
