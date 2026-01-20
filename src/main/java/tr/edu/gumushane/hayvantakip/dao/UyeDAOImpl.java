package tr.edu.gumushane.hayvantakip.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import tr.edu.gumushane.hayvantakip.entity.Uye;

@Repository
public class UyeDAOImpl implements UyeDAO {

    private EntityManager entityManager;

    @Autowired
    public UyeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Uye findById(int id) {
        return entityManager.find(Uye.class, id);
    }

    @Override
    public Uye findByKullaniciAdi(String kullaniciAdi) {
        TypedQuery<Uye> query = entityManager.createQuery(
                "SELECT u FROM Uye u WHERE u.kullaniciAdi = :kullaniciAdi", Uye.class);
        query.setParameter("kullaniciAdi", kullaniciAdi);

        List<Uye> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public List<Uye> findAll() {
        TypedQuery<Uye> query = entityManager.createQuery("FROM Uye", Uye.class);
        return query.getResultList();
    }

    @Override
    public Uye save(Uye uye) {
        return entityManager.merge(uye);
    }

    @Override
    public void deleteById(int id) {
        Uye uye = entityManager.find(Uye.class, id);
        if (uye != null) {
            entityManager.remove(uye);
        }
    }
}
