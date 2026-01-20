package tr.edu.gumushane.hayvantakip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.edu.gumushane.hayvantakip.entity.Animal;
import tr.edu.gumushane.hayvantakip.exception.AnimalNotFoundException;
import tr.edu.gumushane.hayvantakip.service.AnimalService;
import java.util.Map;

@RestController
@RequestMapping("/admin/api")
public class AdminAnimalController {

    private AnimalService animalService;

    @Autowired
    public AdminAnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

<<<<<<< HEAD
    @PostMapping("/animals")
    public Animal addAnimal(@RequestBody Animal animal) {
        
=======
    @PostMapping("/animals") // Rubric Item
    public Animal addAnimal(@RequestBody Animal animal) {
        // Yeni kayıt olduğunu garantilemek için id'yi 0 yapalım
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
        animal.setId(0); 
        return animalService.save(animal);
    }

<<<<<<< HEAD
    @PutMapping("/animals") 
    public Animal updateAnimal(@RequestBody Animal animal) {
        
        return animalService.save(animal);
    }

    @DeleteMapping("/animals/{animalId}")
=======
    @PutMapping("/animals") // Rubric Item
    public Animal updateAnimal(@RequestBody Animal animal) {
        // Gelen 'animal' objesini (id'si dahil) direkt güncelle
        return animalService.save(animal);
    }

    @DeleteMapping("/animals/{animalId}") // Rubric Item
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    public String deleteAnimal(@PathVariable int animalId) {
        if (animalService.findById(animalId) == null) {
            throw new AnimalNotFoundException("Animal id not found - " + animalId);
        }
        animalService.deleteById(animalId);
        return "Deleted animal with id - " + animalId;
    }

<<<<<<< HEAD
    @PatchMapping("/animals/{animalId}")
=======
    @PatchMapping("/animals/{animalId}") // Rubric Item
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    public Animal patchAnimal(@PathVariable int animalId, @RequestBody Map<String, Object> updates) {
        Animal animal = animalService.findById(animalId);
        if (animal == null) {
            throw new AnimalNotFoundException("Animal id not found - " + animalId);
        }

<<<<<<< HEAD
=======
        // Gelen 'updates' Map'ini işleyip 'animal' objesini güncelle
        // Not: Bu basit bir implementasyon. 
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
        if (updates.containsKey("ad")) {
            animal.setAd((String) updates.get("ad"));
        }
        if (updates.containsKey("kilo")) {
<<<<<<< HEAD
=======
            // JSON sayıları Double olarak gönderebilir
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
            animal.setKilo(((Number) updates.get("kilo")).doubleValue());
        }
        
        return animalService.save(animal);
    }
}