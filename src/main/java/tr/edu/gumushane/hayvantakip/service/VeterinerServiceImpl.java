package tr.edu.gumushane.hayvantakip.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.edu.gumushane.hayvantakip.dao.VeterinerDAO;
<<<<<<< HEAD
import tr.edu.gumushane.hayvantakip.entity.Animal;
import tr.edu.gumushane.hayvantakip.entity.Uzmanlik;
=======
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
import tr.edu.gumushane.hayvantakip.entity.Veteriner;

@Service
public class VeterinerServiceImpl implements VeterinerService {

    private VeterinerDAO veterinerDAO;

    @Autowired
    public VeterinerServiceImpl(VeterinerDAO veterinerDAO) {
        this.veterinerDAO = veterinerDAO;
    }

    @Override
    public List<Veteriner> findAll() {
        return veterinerDAO.findAll();
    }

    @Override
    public Veteriner findById(int id) {
        return veterinerDAO.findById(id);
    }

    @Transactional
    @Override
    public Veteriner save(Veteriner veteriner) {
        return veterinerDAO.save(veteriner);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
<<<<<<< HEAD
        Veteriner veteriner = veterinerDAO.findById(id);
        if (veteriner != null) {
            for (Animal animal : veteriner.getHayvanlar()) {
                animal.setVeteriner(null);
            }
            for (Uzmanlik uzmanlik : veteriner.getUzmanliklar()) {
                uzmanlik.getVeterinerler().remove(veteriner);
            }
            veteriner.getUzmanliklar().clear();
        }
=======
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
        veterinerDAO.deleteById(id);
    }
}