package tr.edu.gumushane.hayvantakip.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import tr.edu.gumushane.hayvantakip.entity.Mama;

@Repository
public class MamaDAOImpl implements MamaDAO {

    private EntityManager entityManager;

    @Autowired
    public MamaDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Mama> findAll() {
        TypedQuery<Mama> query = entityManager.createQuery("FROM Mama", Mama.class);
        return query.getResultList();
    }

    @Override
    public Mama findById(int id) {
        return entityManager.find(Mama.class, id);
    }

    @Override
    public Mama save(Mama mama) {
<<<<<<< HEAD

=======
        // ÖNEMLİ: Mama'yı kaydederken 'animal' ilişkisini de yönetmemiz gerekebilir.
        // Bu basit 'merge' işlemi, 'mama' objesinin 'animal' alanı doluysa çalışır.
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
        Mama dbMama = entityManager.merge(mama);
        return dbMama;
    }

    @Override
    public void deleteById(int id) {
        Mama mama = findById(id);
        if (mama != null) {
            entityManager.remove(mama);
        }
    }
}