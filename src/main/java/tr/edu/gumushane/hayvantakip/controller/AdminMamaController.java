package tr.edu.gumushane.hayvantakip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tr.edu.gumushane.hayvantakip.entity.Animal;
import tr.edu.gumushane.hayvantakip.entity.Mama;
import tr.edu.gumushane.hayvantakip.exception.AnimalNotFoundException;
import tr.edu.gumushane.hayvantakip.exception.MamaNotFoundException;
<<<<<<< HEAD
import tr.edu.gumushane.hayvantakip.service.AnimalService; 
=======
import tr.edu.gumushane.hayvantakip.service.AnimalService; // AnimalService gerekli
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
import tr.edu.gumushane.hayvantakip.service.MamaService;

@RestController
@RequestMapping("/admin/api")
public class AdminMamaController {

    private MamaService mamaService;
<<<<<<< HEAD
    private AnimalService animalService; 
=======
    private AnimalService animalService; // Hayvanı bulmak için
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a

    @Autowired
    public AdminMamaController(MamaService mamaService, AnimalService animalService) {
        this.mamaService = mamaService;
        this.animalService = animalService;
    }

<<<<<<< HEAD
    @PostMapping("/animals/{animalId}/mamas")
    public Mama addMama(@PathVariable int animalId, @RequestBody Mama mama) {
        
=======
    // BİR HAYVANA YENİ BİR MAMA KAYDI EKLEME
    // URL: POST /admin/api/animals/1/mamas
    @PostMapping("/animals/{animalId}/mamas")
    public Mama addMama(@PathVariable int animalId, @RequestBody Mama mama) {
        // 1. Hayvanı bul
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
        Animal animal = animalService.findById(animalId);
        if (animal == null) {
            throw new AnimalNotFoundException("Animal id not found - " + animalId);
        }

<<<<<<< HEAD
        mama.setId(0);

        mama.setAnimal(animal);

        return mamaService.save(mama);
    }

    @PutMapping("/mamas")
    public Mama updateMama(@RequestBody Mama mama) {

=======
        // 2. Mama'ya ID'yi 0 yap (yeni kayıt olsun)
        mama.setId(0);

        // 3. Mama'yı Hayvana bağla
        mama.setAnimal(animal);

        // 4. Kaydet
        return mamaService.save(mama);
    }

    // MEVCUT BİR MAMA KAYDINI GÜNCELLEME
    @PutMapping("/mamas")
    public Mama updateMama(@RequestBody Mama mama) {
        // Bu metod, 'mama' objesinin içinde 'animal' bilgisi (örn: {"id": 1})
        // zaten doluysa çalışır.
        // Daha sağlam bir yöntem 'animalId'yi de URL'den almaktır.

        // Gelen mama objesinin 'animal' alanı dolu gelmeli.
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
        if (mama.getAnimal() == null || mama.getAnimal().getId() == 0) {
             throw new RuntimeException("Mama must be associated with an animal. 'animal' field is missing or animal id is 0.");
        }

<<<<<<< HEAD
        return mamaService.save(mama);
    }

=======
        // Not: Gelen 'mama' objesinin 'animal' alanı null ise,
        // JSONIgnore yüzünden sonsuz döngü olmaz ama DB'de 'animal_id' null olur.
        // Bu yüzden 'animal' nesnesini 'mama' ile birlikte JSON'da göndermek zorundayız.
        // @JsonIgnore'a rağmen @RequestBody gelen JSON'u çözer.

        return mamaService.save(mama);
    }

    // BİR MAMA KAYDINI SİLME
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    @DeleteMapping("/mamas/{mamaId}")
    public String deleteMama(@PathVariable int mamaId) {
        if (mamaService.findById(mamaId) == null) {
            throw new MamaNotFoundException("Mama id not found - " + mamaId);
        }
        mamaService.deleteById(mamaId);
        return "Deleted mama with id - " + mamaId;
    }
}