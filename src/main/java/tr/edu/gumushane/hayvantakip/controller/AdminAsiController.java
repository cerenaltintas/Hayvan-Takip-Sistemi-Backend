package tr.edu.gumushane.hayvantakip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tr.edu.gumushane.hayvantakip.entity.Animal;
import tr.edu.gumushane.hayvantakip.entity.Asi;
import tr.edu.gumushane.hayvantakip.exception.AnimalNotFoundException;
import tr.edu.gumushane.hayvantakip.exception.AsiNotFoundException;
import tr.edu.gumushane.hayvantakip.service.AnimalService;
import tr.edu.gumushane.hayvantakip.service.AsiService;

@RestController
@RequestMapping("/admin/api")
public class AdminAsiController {

    private AsiService asiService;
    private AnimalService animalService;

    @Autowired
    public AdminAsiController(AsiService asiService, AnimalService animalService) {
        this.asiService = asiService;
        this.animalService = animalService;
    }

<<<<<<< HEAD
=======
    // BİR HAYVANA YENİ BİR AŞI KAYDI EKLEME
    // URL: POST /admin/api/animals/1/asis
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    @PostMapping("/animals/{animalId}/asis")
    public Asi addAsi(@PathVariable int animalId, @RequestBody Asi asi) {
        Animal animal = animalService.findById(animalId);
        if (animal == null) {
            throw new AnimalNotFoundException("Animal id not found - " + animalId);
        }

        asi.setId(0);
        asi.setAnimal(animal);
        return asiService.save(asi);
    }

<<<<<<< HEAD
=======
    // MEVCUT BİR AŞI KAYDINI GÜNCELLEME
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    @PutMapping("/asis")
    public Asi updateAsi(@RequestBody Asi asi) {
        if (asi.getAnimal() == null || asi.getAnimal().getId() == 0) {
             throw new RuntimeException("Asi must be associated with an animal.");
        }
        return asiService.save(asi);
    }

<<<<<<< HEAD
=======
    // BİR AŞI KAYDINI SİLME
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    @DeleteMapping("/asis/{asiId}")
    public String deleteAsi(@PathVariable int asiId) {
        if (asiService.findById(asiId) == null) {
            throw new AsiNotFoundException("Asi id not found - " + asiId);
        }
        asiService.deleteById(asiId);
        return "Deleted asi with id - " + asiId;
    }
}