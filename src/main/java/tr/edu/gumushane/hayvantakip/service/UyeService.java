package tr.edu.gumushane.hayvantakip.service;

import java.util.List;
import tr.edu.gumushane.hayvantakip.entity.Uye;

public interface UyeService {

    List<Uye> findAll();

    Uye findById(int id);

    Uye findByKullaniciAdi(String kullaniciAdi);

    Uye save(Uye uye);

    void deleteById(int id);

    Uye addRoleToUye(int uyeId, int rolId);

    Uye removeRoleFromUye(int uyeId, int rolId);
}
