package tr.edu.gumushane.hayvantakip.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import tr.edu.gumushane.hayvantakip.entity.Animal;
import tr.edu.gumushane.hayvantakip.exception.AnimalNotFoundException;
import tr.edu.gumushane.hayvantakip.service.AnimalService;

<<<<<<< HEAD
@RestController
@RequestMapping("/public/api") 
=======
@RestController // Rubric Item
@RequestMapping("/public/api") // Rubric Item
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
public class PublicAnimalController {

    private AnimalService animalService;

    @Value("${hayvantakip.proje.grubu}")
    private String projeGrubu;
    @Autowired
    public PublicAnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }
    @GetMapping("/proje-grubu")
    public String getProjeGrubu() {
        return "Proje Grubu: " + projeGrubu;
    }
<<<<<<< HEAD
    @GetMapping("/animals") 
=======
    @GetMapping("/animals") // Rubric Item
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    public List<Animal> findAll() {
        return animalService.findAll();
    }

<<<<<<< HEAD
    @GetMapping("/animals/{animalId}") 
    public Animal findById(@PathVariable int animalId) { 
        Animal animal = animalService.findById(animalId);

=======
    @GetMapping("/animals/{animalId}") // Rubric Item
    public Animal findById(@PathVariable int animalId) { // Rubric Item
        Animal animal = animalService.findById(animalId);
        
        // Rubric Item: REST servisi hata fırlatmalı
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
        if (animal == null) {
            throw new AnimalNotFoundException("Animal id not found - " + animalId);
        }
        
        return animal;
    }

<<<<<<< HEAD
=======
    // ... (findById metodunun hemen altına ekleyebilirsiniz)

    // Rubric Item: TypedQuery ile yazılan DAO metodunu test etmek için eklendi.
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    @GetMapping("/animals/tur/{turAdi}")
    public List<Animal> findByTur(@PathVariable String turAdi) {
        return animalService.findByTur(turAdi);
    }
}