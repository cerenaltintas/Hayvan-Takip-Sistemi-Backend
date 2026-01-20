package tr.edu.gumushane.hayvantakip.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.edu.gumushane.hayvantakip.entity.Mama;
import tr.edu.gumushane.hayvantakip.exception.MamaNotFoundException;
import tr.edu.gumushane.hayvantakip.service.MamaService;

@RestController
@RequestMapping("/public/api")
public class PublicMamaController {

    private MamaService mamaService;

    @Autowired
    public PublicMamaController(MamaService mamaService) {
        this.mamaService = mamaService;
    }

<<<<<<< HEAD
=======
    // Belirli bir mama kaydını ID ile getir
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    @GetMapping("/mamas/{mamaId}")
    public Mama findById(@PathVariable int mamaId) {
        Mama mama = mamaService.findById(mamaId);
        if (mama == null) {
            throw new MamaNotFoundException("Mama id not found - " + mamaId);
        }
        return mama;
    }

<<<<<<< HEAD
    @GetMapping("/animals/{animalId}/mamas")
    public List<Mama> findMamasByAnimalId(@PathVariable int animalId) {
        
=======
    // Belirli bir hayvana ait tüm mama kayıtlarını getir
    // URL: /public/api/animals/1/mamas
    @GetMapping("/animals/{animalId}/mamas")
    public List<Mama> findMamasByAnimalId(@PathVariable int animalId) {
        // Service katmanında bu metodu (findByAnimalId) yazdık.
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
        return mamaService.findByAnimalId(animalId);
    }
}