package tr.edu.gumushane.hayvantakip.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.edu.gumushane.hayvantakip.entity.Asi;
import tr.edu.gumushane.hayvantakip.exception.AsiNotFoundException;
import tr.edu.gumushane.hayvantakip.service.AsiService;

@RestController
@RequestMapping("/public/api")
public class PublicAsiController {

    private AsiService asiService;

    @Autowired
    public PublicAsiController(AsiService asiService) {
        this.asiService = asiService;
    }

<<<<<<< HEAD
=======
    // Belirli bir aşı kaydını ID ile getir
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    @GetMapping("/asis/{asiId}")
    public Asi findById(@PathVariable int asiId) {
        Asi asi = asiService.findById(asiId);
        if (asi == null) {
            throw new AsiNotFoundException("Asi id not found - " + asiId);
        }
        return asi;
    }

<<<<<<< HEAD
=======
    // Belirli bir hayvana ait tüm aşı kayıtlarını getir
    // URL: /public/api/animals/1/asis
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    @GetMapping("/animals/{animalId}/asis")
    public List<Asi> findAsisByAnimalId(@PathVariable int animalId) {
        return asiService.findByAnimalId(animalId);
    }
}