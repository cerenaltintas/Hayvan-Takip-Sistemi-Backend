package tr.edu.gumushane.hayvantakip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tr.edu.gumushane.hayvantakip.entity.SaglikKarti;
import tr.edu.gumushane.hayvantakip.service.SaglikKartiService;

@RestController
@RequestMapping("/public/api")
public class PublicSaglikKartiController {

    private SaglikKartiService saglikKartiService;

    @Autowired
    public PublicSaglikKartiController(SaglikKartiService saglikKartiService) {
        this.saglikKartiService = saglikKartiService;
    }

    @GetMapping("/saglik-kartlari")
    public List<SaglikKarti> findAll() {
        return saglikKartiService.findAll();
    }

    @GetMapping("/saglik-kartlari/{id}")
    public SaglikKarti findById(@PathVariable int id) {
        SaglikKarti saglikKarti = saglikKartiService.findById(id);
        if (saglikKarti == null) {
            throw new RuntimeException("Sağlık kartı bulunamadı - id: " + id);
        }
        return saglikKarti;
    }
}
