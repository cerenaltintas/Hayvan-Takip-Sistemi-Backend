package tr.edu.gumushane.hayvantakip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.edu.gumushane.hayvantakip.dao.UzmanlikDAO;
import tr.edu.gumushane.hayvantakip.entity.Uzmanlik;
import tr.edu.gumushane.hayvantakip.entity.Veteriner;

@Service
public class UzmanlikServiceImpl implements UzmanlikService {

    private UzmanlikDAO uzmanlikDAO;

    @Autowired
    public UzmanlikServiceImpl(UzmanlikDAO uzmanlikDAO) {
        this.uzmanlikDAO = uzmanlikDAO;
    }

    @Override
    public Uzmanlik findById(int id) {
        return uzmanlikDAO.findById(id);
    }

    @Override
    public List<Uzmanlik> findAll() {
        return uzmanlikDAO.findAll();
    }

    @Override
    @Transactional
    public Uzmanlik save(Uzmanlik uzmanlik) {
        return uzmanlikDAO.save(uzmanlik);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Uzmanlik uzmanlik = uzmanlikDAO.findById(id);
        if (uzmanlik != null) {
            for (Veteriner veteriner : uzmanlik.getVeterinerler()) {
                veteriner.getUzmanliklar().remove(uzmanlik);
            }
            uzmanlik.getVeterinerler().clear();
        }
        uzmanlikDAO.deleteById(id);
    }
}
