package tr.edu.gumushane.hayvantakip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tr.edu.gumushane.hayvantakip.entity.Animal;
import tr.edu.gumushane.hayvantakip.entity.SaglikKarti;
import tr.edu.gumushane.hayvantakip.service.AnimalService;
import tr.edu.gumushane.hayvantakip.service.SaglikKartiService;

@RestController
@RequestMapping("/admin/api")
public class AdminSaglikKartiController {

    private SaglikKartiService saglikKartiService;
    private AnimalService animalService;

    @Autowired
    public AdminSaglikKartiController(SaglikKartiService saglikKartiService, AnimalService animalService) {
        this.saglikKartiService = saglikKartiService;
        this.animalService = animalService;
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

    @GetMapping("/animals/{animalId}/saglik-karti")
    public SaglikKarti findByAnimalId(@PathVariable int animalId) {
        SaglikKarti saglikKarti = saglikKartiService.findByAnimalId(animalId);
        if (saglikKarti == null) {
            throw new RuntimeException("Bu hayvan için sağlık kartı bulunamadı - hayvan id: " + animalId);
        }
        return saglikKarti;
    }

    @PostMapping("/animals/{animalId}/saglik-karti")
    public SaglikKarti addSaglikKarti(@PathVariable int animalId, @RequestBody SaglikKarti saglikKarti) {
        Animal animal = animalService.findById(animalId);
        if (animal == null) {
            throw new RuntimeException("Hayvan bulunamadı - id: " + animalId);
        }

        SaglikKarti existing = saglikKartiService.findByAnimalId(animalId);
        if (existing != null) {
            throw new RuntimeException("Bu hayvanın zaten bir sağlık kartı var!");
        }

        saglikKarti.setId(0); 
        saglikKarti.setAnimal(animal);
        return saglikKartiService.save(saglikKarti);
    }

    @PutMapping("/saglik-kartlari")
    public SaglikKarti updateSaglikKarti(@RequestBody SaglikKarti saglikKarti) {
        return saglikKartiService.save(saglikKarti);
    }

    @PatchMapping("/saglik-kartlari/{id}")
    public SaglikKarti patchSaglikKarti(@PathVariable int id, @RequestBody SaglikKarti updates) {
        SaglikKarti existing = saglikKartiService.findById(id);
        if (existing == null) {
            throw new RuntimeException("Sağlık kartı bulunamadı - id: " + id);
        }

        if (updates.getKanGrubu() != null) {
            existing.setKanGrubu(updates.getKanGrubu());
        }
        if (updates.getAlerjiler() != null) {
            existing.setAlerjiler(updates.getAlerjiler());
        }
        if (updates.getKronikHastaliklar() != null) {
            existing.setKronikHastaliklar(updates.getKronikHastaliklar());
        }
        if (updates.getOzelNotlar() != null) {
            existing.setOzelNotlar(updates.getOzelNotlar());
        }

        return saglikKartiService.save(existing);
    }

    @DeleteMapping("/saglik-kartlari/{id}")
    public String deleteSaglikKarti(@PathVariable int id) {
        SaglikKarti saglikKarti = saglikKartiService.findById(id);
        if (saglikKarti == null) {
            throw new RuntimeException("Sağlık kartı bulunamadı - id: " + id);
        }
        saglikKartiService.deleteById(id);
        return "Sağlık kartı silindi - id: " + id;
    }
}
