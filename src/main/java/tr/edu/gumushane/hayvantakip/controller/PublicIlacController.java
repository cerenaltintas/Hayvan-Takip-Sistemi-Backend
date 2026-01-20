package tr.edu.gumushane.hayvantakip.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.edu.gumushane.hayvantakip.entity.Ilac;
import tr.edu.gumushane.hayvantakip.exception.IlacNotFoundException;
import tr.edu.gumushane.hayvantakip.service.IlacService;

@RestController
@RequestMapping("/public/api")
public class PublicIlacController {

    private IlacService ilacService;

    @Autowired
    public PublicIlacController(IlacService ilacService) {
        this.ilacService = ilacService;
    }

<<<<<<< HEAD
=======
    // Belirli bir ilaç kaydını ID ile getir
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    @GetMapping("/ilacs/{ilacId}")
    public Ilac findById(@PathVariable int ilacId) {
        Ilac ilac = ilacService.findById(ilacId);
        if (ilac == null) {
            throw new IlacNotFoundException("Ilac id not found - " + ilacId);
        }
        return ilac;
    }

<<<<<<< HEAD
=======
    // Belirli bir hayvana ait tüm ilaç kayıtlarını getir
    // URL: /public/api/animals/1/ilacs
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    @GetMapping("/animals/{animalId}/ilacs")
    public List<Ilac> findIlacsByAnimalId(@PathVariable int animalId) {
        return ilacService.findByAnimalId(animalId);
    }
}