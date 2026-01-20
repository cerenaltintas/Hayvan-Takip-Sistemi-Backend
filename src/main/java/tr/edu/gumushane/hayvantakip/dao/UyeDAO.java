package tr.edu.gumushane.hayvantakip.dao;

import java.util.List;
import tr.edu.gumushane.hayvantakip.entity.Uye;

public interface UyeDAO {
    Uye findById(int id);

    Uye findByKullaniciAdi(String kullaniciAdi);

    List<Uye> findAll();

    Uye save(Uye uye);

    void deleteById(int id);
}
