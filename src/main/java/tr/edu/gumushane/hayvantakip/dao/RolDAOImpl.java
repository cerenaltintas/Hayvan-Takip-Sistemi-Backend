package tr.edu.gumushane.hayvantakip.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import tr.edu.gumushane.hayvantakip.entity.Rol;

@Repository
public class RolDAOImpl implements RolDAO {

    private EntityManager entityManager;

    @Autowired
    public RolDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Rol findById(int id) {
        return entityManager.find(Rol.class, id);
    }

    @Override
    public Rol findByRolAdi(String rolAdi) {
        TypedQuery<Rol> query = entityManager.createQuery(
                "SELECT r FROM Rol r WHERE r.rolAdi = :rolAdi", Rol.class);
        query.setParameter("rolAdi", rolAdi);

        List<Rol> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public List<Rol> findAll() {
        TypedQuery<Rol> query = entityManager.createQuery("FROM Rol", Rol.class);
        return query.getResultList();
    }

    @Override
    public Rol save(Rol rol) {
        return entityManager.merge(rol);
    }

    @Override
    public void deleteById(int id) {
        Rol rol = entityManager.find(Rol.class, id);
        if (rol != null) {
            entityManager.remove(rol);
        }
    }
}
