package tr.edu.gumushane.hayvantakip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tr.edu.gumushane.hayvantakip.entity.Animal;
import tr.edu.gumushane.hayvantakip.entity.Ilac;
import tr.edu.gumushane.hayvantakip.exception.AnimalNotFoundException;
import tr.edu.gumushane.hayvantakip.exception.IlacNotFoundException;
import tr.edu.gumushane.hayvantakip.service.AnimalService;
import tr.edu.gumushane.hayvantakip.service.IlacService;

@RestController
@RequestMapping("/admin/api")
public class AdminIlacController {

    private IlacService ilacService;
    private AnimalService animalService;

    @Autowired
    public AdminIlacController(IlacService ilacService, AnimalService animalService) {
        this.ilacService = ilacService;
        this.animalService = animalService;
    }

<<<<<<< HEAD
=======
    // BİR HAYVANA YENİ BİR İLAÇ KAYDI EKLEME
    // URL: POST /admin/api/animals/1/ilacs
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    @PostMapping("/animals/{animalId}/ilacs")
    public Ilac addIlac(@PathVariable int animalId, @RequestBody Ilac ilac) {
        Animal animal = animalService.findById(animalId);
        if (animal == null) {
            throw new AnimalNotFoundException("Animal id not found - " + animalId);
        }

        ilac.setId(0);
        ilac.setAnimal(animal);
        return ilacService.save(ilac);
    }

<<<<<<< HEAD
=======
    // MEVCUT BİR İLAÇ KAYDINI GÜNCELLEME
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    @PutMapping("/ilacs")
    public Ilac updateIlac(@RequestBody Ilac ilac) {
        if (ilac.getAnimal() == null || ilac.getAnimal().getId() == 0) {
             throw new RuntimeException("Ilac must be associated with an animal.");
        }
        return ilacService.save(ilac);
    }

<<<<<<< HEAD
=======
    // BİR İLAÇ KAYDINI SİLME
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    @DeleteMapping("/ilacs/{ilacId}")
    public String deleteIlac(@PathVariable int ilacId) {
        if (ilacService.findById(ilacId) == null) {
            throw new IlacNotFoundException("Ilac id not found - " + ilacId);
        }
        ilacService.deleteById(ilacId);
        return "Deleted ilac with id - " + ilacId;
    }
}