package tr.edu.gumushane.hayvantakip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.edu.gumushane.hayvantakip.dao.SaglikKartiDAO;
import tr.edu.gumushane.hayvantakip.entity.SaglikKarti;

@Service
public class SaglikKartiServiceImpl implements SaglikKartiService {

    private SaglikKartiDAO saglikKartiDAO;

    @Autowired
    public SaglikKartiServiceImpl(SaglikKartiDAO saglikKartiDAO) {
        this.saglikKartiDAO = saglikKartiDAO;
    }

    @Override
    public SaglikKarti findById(int id) {
        return saglikKartiDAO.findById(id);
    }

    @Override
    public SaglikKarti findByAnimalId(int animalId) {
        return saglikKartiDAO.findByAnimalId(animalId);
    }

    @Override
    public List<SaglikKarti> findAll() {
        return saglikKartiDAO.findAll();
    }

    @Override
    @Transactional
    public SaglikKarti save(SaglikKarti saglikKarti) {
        return saglikKartiDAO.save(saglikKarti);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        saglikKartiDAO.deleteById(id);
    }
}
