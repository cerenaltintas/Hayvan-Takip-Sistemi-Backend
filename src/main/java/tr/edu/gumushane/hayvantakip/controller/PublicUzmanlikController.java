package tr.edu.gumushane.hayvantakip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tr.edu.gumushane.hayvantakip.entity.Uzmanlik;
import tr.edu.gumushane.hayvantakip.service.UzmanlikService;

@RestController
@RequestMapping("/public/api")
public class PublicUzmanlikController {

    private UzmanlikService uzmanlikService;

    @Autowired
    public PublicUzmanlikController(UzmanlikService uzmanlikService) {
        this.uzmanlikService = uzmanlikService;
    }

    @GetMapping("/uzmanliklar")
    public List<Uzmanlik> findAll() {
        return uzmanlikService.findAll();
    }

    @GetMapping("/uzmanliklar/{id}")
    public Uzmanlik findById(@PathVariable int id) {
        Uzmanlik uzmanlik = uzmanlikService.findById(id);
        if (uzmanlik == null) {
            throw new RuntimeException("Uzmanlık alanı bulunamadı - id: " + id);
        }
        return uzmanlik;
    }
}
