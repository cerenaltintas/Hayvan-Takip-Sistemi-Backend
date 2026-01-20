package tr.edu.gumushane.hayvantakip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tr.edu.gumushane.hayvantakip.entity.Uzmanlik;
import tr.edu.gumushane.hayvantakip.entity.Veteriner;
import tr.edu.gumushane.hayvantakip.service.UzmanlikService;
import tr.edu.gumushane.hayvantakip.service.VeterinerService;

@RestController
@RequestMapping("/admin/api")
public class AdminUzmanlikController {

    private UzmanlikService uzmanlikService;
    private VeterinerService veterinerService;

    @Autowired
    public AdminUzmanlikController(UzmanlikService uzmanlikService, VeterinerService veterinerService) {
        this.uzmanlikService = uzmanlikService;
        this.veterinerService = veterinerService;
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

    @PostMapping("/uzmanliklar")
    public Uzmanlik addUzmanlik(@RequestBody Uzmanlik uzmanlik) {
        uzmanlik.setId(0); 
        return uzmanlikService.save(uzmanlik);
    }

    @PutMapping("/uzmanliklar")
    public Uzmanlik updateUzmanlik(@RequestBody Uzmanlik uzmanlik) {
        return uzmanlikService.save(uzmanlik);
    }

    @PatchMapping("/uzmanliklar/{id}")
    public Uzmanlik patchUzmanlik(@PathVariable int id, @RequestBody Uzmanlik updates) {
        Uzmanlik existing = uzmanlikService.findById(id);
        if (existing == null) {
            throw new RuntimeException("Uzmanlık alanı bulunamadı - id: " + id);
        }

        if (updates.getAlanAdi() != null) {
            existing.setAlanAdi(updates.getAlanAdi());
        }
        if (updates.getAciklama() != null) {
            existing.setAciklama(updates.getAciklama());
        }

        return uzmanlikService.save(existing);
    }

    @DeleteMapping("/uzmanliklar/{id}")
    public String deleteUzmanlik(@PathVariable int id) {
        Uzmanlik uzmanlik = uzmanlikService.findById(id);
        if (uzmanlik == null) {
            throw new RuntimeException("Uzmanlık alanı bulunamadı - id: " + id);
        }
        uzmanlikService.deleteById(id);
        return "Uzmanlık alanı silindi - id: " + id;
    }

    @PostMapping("/veteriners/{veterinerId}/uzmanliklar/{uzmanlikId}")
    public Veteriner addUzmanlikToVeteriner(@PathVariable int veterinerId, @PathVariable int uzmanlikId) {
        Veteriner veteriner = veterinerService.findById(veterinerId);
        if (veteriner == null) {
            throw new RuntimeException("Veteriner bulunamadı - id: " + veterinerId);
        }

        Uzmanlik uzmanlik = uzmanlikService.findById(uzmanlikId);
        if (uzmanlik == null) {
            throw new RuntimeException("Uzmanlık alanı bulunamadı - id: " + uzmanlikId);
        }

        veteriner.addUzmanlik(uzmanlik);
        return veterinerService.save(veteriner);
    }

    @DeleteMapping("/veteriners/{veterinerId}/uzmanliklar/{uzmanlikId}")
    public Veteriner removeUzmanlikFromVeteriner(@PathVariable int veterinerId, @PathVariable int uzmanlikId) {
        Veteriner veteriner = veterinerService.findById(veterinerId);
        if (veteriner == null) {
            throw new RuntimeException("Veteriner bulunamadı - id: " + veterinerId);
        }

        Uzmanlik uzmanlik = uzmanlikService.findById(uzmanlikId);
        if (uzmanlik == null) {
            throw new RuntimeException("Uzmanlık alanı bulunamadı - id: " + uzmanlikId);
        }

        veteriner.removeUzmanlik(uzmanlik);
        return veterinerService.save(veteriner);
    }
}
