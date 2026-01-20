package tr.edu.gumushane.hayvantakip.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.edu.gumushane.hayvantakip.dao.UyeDAO;
import tr.edu.gumushane.hayvantakip.entity.Rol;
import tr.edu.gumushane.hayvantakip.entity.Uye;

@Service
public class UyeServiceImpl implements UyeService {

    private UyeDAO uyeDAO;
    private RolService rolService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UyeServiceImpl(UyeDAO uyeDAO, RolService rolService, PasswordEncoder passwordEncoder) {
        this.uyeDAO = uyeDAO;
        this.rolService = rolService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public List<Uye> findAll() {
        return uyeDAO.findAll();
    }

    @Override
    @Transactional
    public Uye findById(int id) {
        return uyeDAO.findById(id);
    }

    @Override
    @Transactional
    public Uye findByKullaniciAdi(String kullaniciAdi) {
        return uyeDAO.findByKullaniciAdi(kullaniciAdi);
    }

    @Override
    @Transactional
    public Uye save(Uye uye) {
        // Şifre BCrypt ile encode edilmemişse encode et
        if (uye.getSifre() != null && !uye.getSifre().startsWith("$2a$")) {
            uye.setSifre(passwordEncoder.encode(uye.getSifre()));
        }
        return uyeDAO.save(uye);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Uye uye = uyeDAO.findById(id);
        if (uye != null) {
            uye.getRoller().clear();
        }
        uyeDAO.deleteById(id);
    }

    @Override
    @Transactional
    public Uye addRoleToUye(int uyeId, int rolId) {
        Uye uye = uyeDAO.findById(uyeId);
        if (uye == null) {
            throw new RuntimeException("Uye bulunamadi - id: " + uyeId);
        }
        Rol rol = rolService.findById(rolId);
        if (rol == null) {
            throw new RuntimeException("Rol bulunamadi - id: " + rolId);
        }
        // Eğer rol zaten ekliyse tekrar ekleme
        if (!uye.getRoller().contains(rol)) {
            uye.addRol(rol);
            return uyeDAO.save(uye);
        }
        return uye;
    }

    @Override
    @Transactional
    public Uye removeRoleFromUye(int uyeId, int rolId) {
        Uye uye = uyeDAO.findById(uyeId);
        if (uye == null) {
            throw new RuntimeException("Uye bulunamadi - id: " + uyeId);
        }
        Rol rol = rolService.findById(rolId);
        if (rol == null) {
            throw new RuntimeException("Rol bulunamadi - id: " + rolId);
        }
        uye.getRoller().remove(rol);
        return uyeDAO.save(uye);
    }
}
